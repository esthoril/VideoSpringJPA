package be.vdab.spring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "klanten")
public class Klant {

	@Id
	int klantNr;
	String familienaam;
	String voornaam;
	String straatNummer;
	int postcode;
	String gemeente;
	
	protected Klant() {
	}
	
	public Klant(int klantNr, String familienaam, String voornaam, String straatNummer, int postcode, String gemeente) {
		this.klantNr = klantNr;
		this.familienaam = familienaam;
		this.voornaam = voornaam;
		this.straatNummer = straatNummer;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}

	public int getKlantNr() {
		return klantNr;
	}

	public void setKlantNr(int klantNr) {
		this.klantNr = klantNr;
	}

	public String getFamilienaam() {
		return familienaam;
	}

	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getStraatNummer() {
		return straatNummer;
	}

	public void setStraatNummer(String straatNummer) {
		this.straatNummer = straatNummer;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}
}