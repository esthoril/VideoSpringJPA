package be.vdab.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Mandje implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Movie> movieList;
	
	public Mandje() {
		movieList = new ArrayList<Movie>();
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
	
	public void clear() {
		this.movieList.clear();
	}
	
	public void addMovie(Movie movie) {
		movieList.add(movie);
	}
	
	public void removeMovie(int filmnr) {
		
		// loop through mandje, remove movie if it has the same number
		for(int i=0;i<movieList.size();i++) {
			if(movieList.get(i).filmNr == filmnr) {
				movieList.remove(i);				
			}
		}
	}
}