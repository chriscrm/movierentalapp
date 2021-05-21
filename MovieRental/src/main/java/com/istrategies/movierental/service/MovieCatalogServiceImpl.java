package com.istrategies.movierental.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.istrategies.movierental.dto.MovieCatalogDTO;
import com.istrategies.movierental.entity.MovieCatalogEntity;
import com.istrategies.movierental.repository.MovieCatalogRepository;

@Service
public class MovieCatalogServiceImpl implements MovieCatalogService {
	
	@Autowired
	MovieCatalogRepository movieRepository;

	@Override
	public MovieCatalogDTO createMovie(MovieCatalogDTO movieDTO) {

		MovieCatalogEntity movieEntity = new MovieCatalogEntity();
		BeanUtils.copyProperties(movieDTO, movieEntity);
		
		MovieCatalogEntity movieSaved = movieRepository.save(movieEntity);
		
		MovieCatalogDTO returnValue = new MovieCatalogDTO();
		BeanUtils.copyProperties(movieSaved, returnValue);
		
		
		return returnValue;
	}

	@Override
	public List<MovieCatalogDTO> getAllMovies(Integer page, Integer limit, String sortBy) {

		List<MovieCatalogDTO> returnValue = new ArrayList<>();

		Pageable pageableRequest = PageRequest.of(page, limit, Sort.by(sortBy));
		
		Page<MovieCatalogEntity> moviePage = movieRepository.findAll(pageableRequest);
		
		List<MovieCatalogEntity> movies = moviePage.getContent();
		
		for (MovieCatalogEntity entity : movies) {
			MovieCatalogDTO movieDTO = new MovieCatalogDTO();
			BeanUtils.copyProperties(entity, movieDTO);
			returnValue.add(movieDTO);
		}
		
		
		return returnValue;
	}

}
