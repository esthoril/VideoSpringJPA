package be.vdab.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.spring.services.MovieService;

@Controller
@RequestMapping("/moviedetail")
public class MovieController {

	private final MovieService movieService;
	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@RequestMapping(method = RequestMethod.GET, params="filmnr")
	public ModelAndView read(@RequestParam int filmnr) {
		return new ModelAndView("moviedetail", "movie", movieService.read(filmnr));
	}
}