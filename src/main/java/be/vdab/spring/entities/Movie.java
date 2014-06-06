package be.vdab.spring.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "films")
public class Movie {

	@Id
	int filmNr;
	int genreNr;
	String titel;
	int voorraad;
	int gereserveerd;
	BigDecimal prijs;
	
	protected Movie() {
	}
	
	// constructor voor mandje
	public Movie(int filmNr, String titel, int voorraad, int gereserveerd, BigDecimal prijs) {
		this.filmNr = filmNr;
		this.titel = titel;
		this.voorraad = voorraad;
		this.gereserveerd = gereserveerd;
		this.prijs = prijs;
	}
	
	public Movie(int filmNr, int genreNr, String titel, int voorraad, int gereserveerd, BigDecimal prijs) {
		this.filmNr = filmNr;
		this.genreNr = genreNr;
		this.titel = titel;
		this.voorraad = voorraad;
		this.gereserveerd = gereserveerd;
		this.prijs = prijs;
	}

	public int getFilmNr() {
		return filmNr;
	}

	public int getGenreNr() {
		return genreNr;
	}

	public String getTitel() {
		return titel;
	}

	public int getVoorraad() {
		return voorraad;
	}

	public void setVoorraad(int voorraad) {
		this.voorraad = voorraad;
	}

	public int getGereserveerd() {
		return gereserveerd;
	}

	public void setGereserveerd(int gereserveerd) {
		this.gereserveerd = gereserveerd;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}
	
	public boolean isReservable() {
		if(gereserveerd < voorraad) {
			return true;
		} else {
			return false;
		}
	}
	
	public void reservatie() {
		this.gereserveerd++;
	}
	
	@Override
	public String toString() {
		return filmNr + " " + titel + " (€" +prijs+")";
	}
}