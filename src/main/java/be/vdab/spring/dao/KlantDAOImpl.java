package be.vdab.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import be.vdab.spring.entities.Klant;

@Repository
public class KlantDAOImpl implements KlantDAO {

	private EntityManager entityManager;
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public Klant read(int klantNr) {
		return entityManager.find(Klant.class, klantNr);
	}
	
	public List<Klant> findByFamilyName(String woord) {
		TypedQuery<Klant> query = entityManager.createNamedQuery("findByFamilyName", Klant.class);
		query.setParameter("woord", '%' + woord + '%');
		return query.getResultList();
	}
}