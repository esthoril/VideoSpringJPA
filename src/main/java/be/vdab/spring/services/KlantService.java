package be.vdab.spring.services;

import java.util.List;

import be.vdab.spring.entities.Klant;

public interface KlantService {

	public List<Klant> findByFamilyName(String namepart);
	public Klant read(int klantnr);	
}
