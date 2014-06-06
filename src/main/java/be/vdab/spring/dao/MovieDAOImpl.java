package be.vdab.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import be.vdab.spring.entities.Movie;

@Repository
public class MovieDAOImpl implements MovieDAO {
	
	private EntityManager entityManager;
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}	
	
	@Override
	public List<Movie> findMoviesByGenre(int genrenr) {
		TypedQuery<Movie> query = entityManager.createNamedQuery("findMoviesByGenre", Movie.class);
		query.setParameter("genre", genrenr);
		return query.getResultList();
	}
	
	@Override
	public Movie read(int filmNr) {
		return entityManager.find(Movie.class, filmNr);
	}
}