package be.vdab.spring.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.spring.entities.Mandje;
import be.vdab.spring.entities.Movie;
import be.vdab.spring.entities.Reservatie;
import be.vdab.spring.services.MovieService;
import be.vdab.spring.services.ReservatieService;


@Controller
@RequestMapping("/reservaties")
public class ReservatieController {

	private final ReservatieService reservatieService;
	private final MovieService movieService;
	@Autowired
	public ReservatieController (ReservatieService reservatieService, MovieService movieService) {
		this.reservatieService = reservatieService;
		this.movieService = movieService;
	}
	
	
	/**
	 * weergeven alle reservaties
	 */
	@RequestMapping(value="overzicht", method = RequestMethod.GET)
	public ModelAndView showReservations() {
		
		List<Reservatie> reservaties = reservatieService.findAll();
		
		ModelAndView modelAndView =
				new ModelAndView("reservaties/overzicht", "reservaties", reservaties);

		return modelAndView;
	}
	
	
	/**
	 * weergeven alle reservaties
	 */
	@RequestMapping(value="rapport", method = RequestMethod.GET, params="klantnr")
	public ModelAndView confirmReservations(HttpSession session, @RequestParam int klantnr) {
	
		ModelAndView modelAndView =
				new ModelAndView("reservaties/rapport");

		Mandje mandje = (Mandje) session.getAttribute("mandje");
		if (!mandje.getMovieList().isEmpty()) {
			
			List<Movie> nonReservableMovies = new ArrayList<Movie>();

			for(int i=0;i<mandje.getMovieList().size();i++) {
				
				// film opnieuw lezen om te kijken of hij nog steeds te reserveren is
 				Movie m = movieService.read(mandje.getMovieList().get(i).getFilmNr());
				if(m.isReservable()) {

					// effectieve reservatie van de film
					int filmnr = m.getFilmNr();
					reservatieService.create(filmnr, klantnr);

				} else {
					nonReservableMovies.add(m);
				}
			}
			
			// add nonreservable movies to a list
			modelAndView.addObject("nonReservableMovies", nonReservableMovies);
		
			// reservatie confirmed/executed. filmlijst uit mandje leegmaken
			mandje.clear();
		} else {
			modelAndView.addObject("leeg", "Geen films in mandje");
		}
		return modelAndView;
	}
}