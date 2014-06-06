package be.vdab.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.spring.dao.ReservatieDAO;
import be.vdab.spring.entities.Reservatie;

@Service
@Transactional(readOnly = true)
public class ReservatieServiceImpl implements ReservatieService {

	private final ReservatieDAO reservatieDAO;
	@Autowired
	public ReservatieServiceImpl(ReservatieDAO reservatieDAO) {
		this.reservatieDAO = reservatieDAO;
	}
	
	@Override
	public List<Reservatie> findAll() {
		return reservatieDAO.findAll();
	}
	
	@Override
	public void create(int filmnr, int klantnr) {
		reservatieDAO.create(filmnr, klantnr);
	}
	
}
