package be.vdab.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import be.vdab.spring.entities.Reservatie;

@Repository
public class ReservatieDAOImpl implements ReservatieDAO {

	private EntityManager entityManager;
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Reservatie> findAll() {
		TypedQuery<Reservatie> query = entityManager.createNamedQuery("findReservations", Reservatie.class);
		return query.getResultList();
	}
	
	public void create(int filmnr, int klantnr) {

		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("reserveMovie");
		query.setParameter("filmnummer", filmnr);
		query.setParameter("klantnummer", klantnr);
		query.execute();
	}
	
	/*
	SQL procedure om film te reserveren 
	 
	DELIMITER //
	CREATE PROCEDURE reserveMovie(filmnummer INT, klantnummer INT)
	BEGIN
	INSERT INTO reservaties VALUES(klantnummer,filmnummer,NOW());
	UPDATE films SET gereserveerd = gereserveerd +1 WHERE filmNr = filmnummer;
	END //
	DELIMITER;
	*/
	
}