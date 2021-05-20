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
public class MovieCatalogService {

	@Autowired
	MovieCatalogRepository repository;
	
	public List<MovieCatalogDTO> getAllMovies(Integer page, Integer limit, String sortBy){
		
		List<MovieCatalogDTO> returnValue = new ArrayList<>();
				
		Pageable paging = PageRequest.of(page, limit, Sort.by(sortBy));
		
		Page<MovieCatalogEntity> pagedResult = repository.findAll(paging);
		
		List<MovieCatalogEntity> movies = pagedResult.getContent();
		
		for (MovieCatalogEntity movieCatalogEntity : movies) {
			MovieCatalogDTO movieDTO = new MovieCatalogDTO();
			BeanUtils.copyProperties(movieCatalogEntity, movieDTO);
			returnValue.add(movieDTO);
		}
		
		
		return returnValue;
		
	}
	
}
