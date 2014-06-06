package be.vdab.spring.services;

import java.util.List;

import be.vdab.spring.entities.Reservatie;

public interface ReservatieService {

	public List<Reservatie> findAll();
	public void create(int filmnr, int klantnr);
}
