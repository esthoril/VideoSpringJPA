package be.vdab.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.spring.dao.GenreDAO;
import be.vdab.spring.entities.Genre;

@Service
@Transactional(readOnly = true)
class GenreServiceImpl implements GenreService {

	private final GenreDAO genreDAO;
	@Autowired
	public GenreServiceImpl(GenreDAO genreDAO) {
		this.genreDAO = genreDAO;
	}
	
	@Override
	public List<Genre> findAll() {
		return genreDAO.findAll();
	}
}
