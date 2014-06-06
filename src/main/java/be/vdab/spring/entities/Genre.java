package be.vdab.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

/**
 * really need to add the 'resultClasses' to the NamedStoredProcedureQuery
 * else you get parse errors when calling the query resultset from .jsp
 */
@NamedStoredProcedureQuery(name="findgenres", resultClasses=Genre.class, procedureName ="findgenres")

@Entity
@Table(name ="genres")
public class Genre implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int genreNr;
	private String naam;
	private int aantal;
		
	protected Genre() {
	}
	
	public Genre(int genreNr, String naam, int aantal) {
		this.genreNr = genreNr;
		this.naam = naam;
		this.aantal = aantal;
	}

	public int getGenreNr() {
		return genreNr;
	}

	public String getNaam() {
		return naam;
	}
	
	public int getAantal() {
		return aantal;
	}
}