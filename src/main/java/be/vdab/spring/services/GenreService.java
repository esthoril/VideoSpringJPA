package be.vdab.spring.services;

import java.util.List;

import be.vdab.spring.entities.Genre;

public interface GenreService {

	List<Genre> findAll();
}
