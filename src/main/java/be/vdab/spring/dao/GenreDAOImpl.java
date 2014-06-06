package be.vdab.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import be.vdab.spring.entities.Genre;

@Repository
public class GenreDAOImpl implements GenreDAO {

	private EntityManager entityManager;
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Genre> findAll() {
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("findgenres");
		return query.getResultList();
	}
	
	/*
	 * using stored procedure so we can easily add a column with
	 * the amount of films in a particular genre
	 *
		DELIMITER $$
		CREATE PROCEDURE findgenres()
		  BEGIN
		    SELECT genres.genrenr, naam, COUNT(films.filmNr) aantal
		    FROM genres LEFT JOIN films ON genres.genrenr = films.genrenr
		    GROUP BY genres.genrenr ORDER BY naam;
		  END $$
		DELIMITER ;
	*/
}