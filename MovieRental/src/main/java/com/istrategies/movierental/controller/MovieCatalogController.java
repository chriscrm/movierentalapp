package com.istrategies.movierental.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.istrategies.movierental.dto.MovieCatalogDTO;
import com.istrategies.movierental.request.MovieDetailsRequestModel;
import com.istrategies.movierental.response.MovieRest;
import com.istrategies.movierental.service.MovieCatalogService;

@RestController
@RequestMapping("/movies")
public class MovieCatalogController {
	
	@Autowired
	MovieCatalogService service;
	
	@GetMapping(path = "/{id}")
	public String getMovie(@PathVariable int movieId) {
		return "get movie entity-dto";
	}
	
	@PostMapping
	public MovieRest createMovie(@RequestBody MovieDetailsRequestModel movieDetails) {
		
		MovieRest returnValue = new MovieRest();
		
		MovieCatalogDTO movieDTO = new MovieCatalogDTO();
		BeanUtils.copyProperties(movieDetails, movieDTO);
		
		MovieCatalogDTO createdMovie = service.createMovie(movieDTO);
		BeanUtils.copyProperties(createdMovie, returnValue);
		
		return returnValue;
	}
	
	@PutMapping
	public String updateMovie() {
		return "update movie";
	}
	
	@DeleteMapping
	public String deleteMovie() {
		return "delete movie";
	}

	@GetMapping
	public List<MovieCatalogDTO> getAllMovies(
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer limit,
			@RequestParam(defaultValue = "id") String sortBy){

		List<MovieCatalogDTO> moviesDTO = service.getAllMovies(page, limit, sortBy);
		
		return moviesDTO;
	}
	
}

