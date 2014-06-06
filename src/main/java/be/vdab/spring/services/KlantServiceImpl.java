package be.vdab.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.spring.dao.KlantDAO;
import be.vdab.spring.entities.Klant;

@Service
@Transactional(readOnly = true)
public class KlantServiceImpl implements KlantService {

	private KlantDAO klantDAO;
	
	@Autowired
	public KlantServiceImpl(KlantDAO klantDAO) {
		this.klantDAO = klantDAO;
	}
		
	@Override
	public List<Klant> findByFamilyName(String namepart) {
		return klantDAO.findByFamilyName(namepart);
	}

	@Override
	public Klant read(int klantnr) {
		return klantDAO.read(klantnr);
	}

}
