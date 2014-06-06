package be.vdab.spring.dao;

import java.util.List;

import be.vdab.spring.entities.Klant;

public interface KlantDAO {
	
	public List<Klant> findByFamilyName(String namepart);
	public Klant read(int klantnr);
}
