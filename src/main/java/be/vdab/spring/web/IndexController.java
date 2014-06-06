package be.vdab.spring.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.spring.entities.Genre;
import be.vdab.spring.services.GenreService;

@Controller
@RequestMapping("/")
@SessionAttributes("genres")
class IndexController {

	private final GenreService genreService;
	@Autowired
	public IndexController(GenreService genreService) {
		this.genreService = genreService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index() {

		ModelAndView modelAndView = new ModelAndView("index");
		List<Genre> genres = genreService.findAll();
		modelAndView.addObject("genres",  genres);
	
		return modelAndView;
	}
}