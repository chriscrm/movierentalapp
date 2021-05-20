package com.istrategies.movierental.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.istrategies.movierental.entity.MovieCatalogEntity;

@Repository
public interface MovieCatalogRepository extends PagingAndSortingRepository<MovieCatalogEntity, Long> {
	MovieCatalogEntity findByTitle(String title);
	List<MovieCatalogEntity> findAllByRentalPrice(double price, Pageable pageable);
}
