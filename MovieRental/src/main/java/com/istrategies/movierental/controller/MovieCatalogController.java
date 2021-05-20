package com.istrategies.movierental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.istrategies.movierental.dto.MovieCatalogDTO;
import com.istrategies.movierental.service.MovieCatalogService;

@RestController
@RequestMapping("/movies")
public class MovieCatalogController {
	
	@Autowired
	MovieCatalogService service;

	@GetMapping
	public List<MovieCatalogDTO> getAllMovies(
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer limit,
			@RequestParam(defaultValue = "id") String sortBy){

		List<MovieCatalogDTO> moviesDTO = service.getAllMovies(page, limit, sortBy);
		
		return moviesDTO;
	}
	
}

