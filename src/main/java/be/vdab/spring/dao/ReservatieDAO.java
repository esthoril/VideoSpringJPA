package be.vdab.spring.dao;

import java.util.List;

import be.vdab.spring.entities.Reservatie;

public interface ReservatieDAO {

	public List<Reservatie>findAll();
	public void create(int filmnr, int klantnr);
}
