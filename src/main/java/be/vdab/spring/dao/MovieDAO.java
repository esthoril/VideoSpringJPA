package be.vdab.spring.dao;

import java.util.List;

import be.vdab.spring.entities.Movie;

public interface MovieDAO {

	public List<Movie> findMoviesByGenre(int genre);
	public Movie read(int filmNr);
}
