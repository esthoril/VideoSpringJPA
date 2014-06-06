package be.vdab.spring.dao;

import java.util.List;

import be.vdab.spring.entities.Genre;

public interface GenreDAO {

	List<Genre> findAll();
}
