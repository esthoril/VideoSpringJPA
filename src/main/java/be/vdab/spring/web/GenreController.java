package be.vdab.spring.web;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.spring.entities.Genre;
import be.vdab.spring.entities.Movie;
import be.vdab.spring.services.MovieService;

@Controller
@RequestMapping("/genre")
@SessionAttributes("selectedgenre")
public class GenreController {

	private final MovieService movieService;
	@Autowired
	public GenreController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, params="nr")
	public ModelAndView findMoviesByGenre(@RequestParam int nr, HttpSession session) {

		// via HttpSession en session.getAttribute gezien we geen entity object hebben
		// en dus niet via @ModelAttribute kunnen gaan
		
		List<Movie> movieList = movieService.findMoviesByGenre(nr);

		List<Genre> genres = (List<Genre>) session.getAttribute("genres");
		Genre selectedGenre = null;
		for(Genre g : genres) {
			if(g.getGenreNr() == nr) {
				selectedGenre = g;
			}
		}
		
		ModelAndView modelAndView =	new ModelAndView("genre", "movies", movieList);
		modelAndView.addObject("selectedgenre", selectedGenre);
		modelAndView.addObject("aantal", movieList.size());
				
		return modelAndView;
	}
}