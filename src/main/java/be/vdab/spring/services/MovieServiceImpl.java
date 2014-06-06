package be.vdab.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.spring.dao.MovieDAO;
import be.vdab.spring.entities.Movie;

@Service
@Transactional(readOnly = true)
public class MovieServiceImpl implements MovieService {

	private MovieDAO movieDAO;
	
	@Autowired
	public MovieServiceImpl(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}
	
	@Override
	public List<Movie> findMoviesByGenre(int genre) {
		return movieDAO.findMoviesByGenre(genre);
	}

	@Override
	public Movie read(int filmNr) {
		return movieDAO.read(filmNr);
	}
}