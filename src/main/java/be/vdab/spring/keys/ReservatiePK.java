package be.vdab.spring.keys;

import java.io.Serializable;

import javax.persistence.Column;


public class ReservatiePK implements Serializable {

	/*
	 * composed triple primary key for Reservatie class 
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@Column(name="ReservatieDatum")
	protected String datum;
	protected int klantNr;
	protected int filmNr;

	public ReservatiePK() {
	}
	
	public int hashCode() {
		return (filmNr + klantNr + datum).toUpperCase().hashCode();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof ReservatiePK)) { return false; }
		ReservatiePK reservatieKey = (ReservatiePK) obj;
		return (reservatieKey.filmNr == filmNr &&
				reservatieKey.klantNr == klantNr &&
				reservatieKey.datum.equalsIgnoreCase(datum));
	}
}
