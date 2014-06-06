package be.vdab.spring.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import be.vdab.spring.keys.ReservatiePK;


@NamedStoredProcedureQuery(
		name="reserveMovie",
		procedureName ="reserveMovie",
		parameters = {
				@StoredProcedureParameter(name="filmnummer", type=Integer.class),
				@StoredProcedureParameter(name="klantnummer", type=Integer.class)
		}
)

@Entity
@IdClass(ReservatiePK.class)
@Table(name="reservaties")
public class Reservatie implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String datum;
	@Id
	private int klantNr;
	@Id
	private int filmNr;

	protected Reservatie() {
	}
	
	public Reservatie(int filmNr, int klantNr) {
		
		this.klantNr = klantNr;
		this.filmNr = filmNr;
		
		// create timestamp when a reservation object is made
		Date now = Calendar.getInstance().getTime();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.datum = df.format(now);
	}

	public int getKlantNr() {
		return klantNr;
	}

	public int getFilmNr() {
		return filmNr;
	}

	public String getDatum() {
		return datum;
	}
}