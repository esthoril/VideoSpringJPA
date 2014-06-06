package be.vdab.spring.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.spring.entities.Klant;
import be.vdab.spring.entities.Mandje;
import be.vdab.spring.entities.Movie;
import be.vdab.spring.services.KlantService;

@Controller
@RequestMapping("/klanten")
public class KlantController {

	private final KlantService klantService;
	@Autowired
	public KlantController(KlantService klantService) {
		this.klantService = klantService;
	}
	
	@RequestMapping(value="zoeken", method = RequestMethod.GET)
	public String search() {
		return "klanten/zoeken";
	}

	
	/**
	 * zoeken van klanten op deel van familienaam
	 */
	@RequestMapping(value="zoeken", method = RequestMethod.GET, params = "naam")
	public ModelAndView showClientsWithName(@RequestParam String naam) {
		
		List<Klant> klanten = klantService.findByFamilyName(naam);
		
		return new ModelAndView("klanten/zoeken", "klanten", klanten);
	}
	
	
	/**
	 * zoeken enkele klant
	 */
	@RequestMapping(value="detail", method = RequestMethod.GET, params="klantnr")
	public ModelAndView read(@RequestParam int klantnr) {
		return new ModelAndView("klanten/detail", "klant", klantService.read(klantnr));
	}
			
	
	/**
	 * overzicht mandje voor bevestiging bestelling
	 */
	@RequestMapping(value="bevestigen", method = RequestMethod.GET, params = "klantnr")
	public ModelAndView confirmOrder(@RequestParam int klantnr, HttpSession session) {
		
		Klant klant = klantService.read(klantnr);
		ModelAndView modelAndView = new ModelAndView("klanten/bevestigen", "klant", klant);

		Mandje mandje = (Mandje) session.getAttribute("mandje");
		if(mandje != null) {
			
			List<Movie> movieList = mandje.getMovieList();
			modelAndView.addObject("movieList", movieList);
		}
		return modelAndView;
	}	
	
}

