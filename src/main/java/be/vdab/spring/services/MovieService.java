package be.vdab.spring.services;


import java.util.List;

import be.vdab.spring.entities.Movie;

public interface MovieService {

	public List<Movie> findMoviesByGenre(int genre);
	public Movie read(int filmNr);
}