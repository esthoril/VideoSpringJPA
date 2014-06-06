package be.vdab.spring.web;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.spring.entities.Mandje;
import be.vdab.spring.entities.Movie;

@Controller
@RequestMapping("/order")
@SessionAttributes("mandje")
public class MandjeController {

	
	/**
	 * aanmaken sessieattribuut mandje
	 * 
	 * in deze controller aan te roepen via method variabele
	 *		@ModelAttribute("mandje") Mandje mandje)
	 * in andere controllers aan te roepen via method variabele
	 * 		HttpSession session
	 *		Mandje mandje = (Mandje) session.getAttribute("mandje");
	 */
	@ModelAttribute("mandje")
    public Mandje getMandje() {
        return new Mandje();
	}

	
	/**
	 * mandje weergeven
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showMandje(@ModelAttribute("mandje") Mandje mandje) {
		
		List<Movie> movieList = mandje.getMovieList();
		
		// totale prijs van alle films
		BigDecimal totaal = BigDecimal.ZERO;
		for(Movie m : movieList) {
			totaal = totaal.add(m.getPrijs());
		}
				
		ModelAndView modelAndView =	new ModelAndView("mandje", "movieList", movieList);
		modelAndView.addObject("totaal",  totaal);

		return modelAndView;
	}
	
	
	/**
	 * film toevoegen aan mandje 
	 */
	@RequestMapping(method = RequestMethod.POST,
			params={"filmnr","titel", "voorraad", "gereserveerd", "prijs"})
	public String addMovieToMandje(@RequestParam int filmnr,
			@RequestParam String titel,
			@RequestParam int voorraad,
			@RequestParam int gereserveerd,
			@RequestParam BigDecimal prijs,
			@ModelAttribute("mandje") Mandje mandje) {
		
		Movie m = new Movie(filmnr, titel, voorraad, gereserveerd, prijs);
		mandje.addMovie(m);
		
		return "redirect:/order";
	}


	/*
	 * film(s) verwijderen uit mandje
	 */
	@RequestMapping(method = RequestMethod.POST, params ="nummer")
	public String removeMovieFromMandje(@RequestParam int[] nummer,
			@ModelAttribute("mandje") Mandje mandje) {
		
		// film met deze nummers uit mandje halen
		for(int n : nummer) {
			mandje.removeMovie(n);
		}
		
		return "redirect:/order";
	}


	/*
	 * geen films aangevinkt doet niets
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView noMovieToRemove() {

		ModelAndView modelAndView = new ModelAndView("redirect:/order");		
		return modelAndView;
	}
}