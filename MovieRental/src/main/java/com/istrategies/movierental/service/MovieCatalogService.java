package com.istrategies.movierental.service;

import java.util.List;

import com.istrategies.movierental.dto.MovieCatalogDTO;


public interface MovieCatalogService {

	MovieCatalogDTO createMovie(MovieCatalogDTO movieDTO);

	List<MovieCatalogDTO> getAllMovies(Integer page, Integer limit, String sortBy);
	
}
