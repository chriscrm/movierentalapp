package com.istrategies.movierental.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "movie_catalog")
public class MovieCatalogEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String movieDescription;
	
	@Column(nullable = false)
	private int movieStock;
	
	@Column(nullable = false)
	private double rentalPrice;
	
	@Column(nullable = false)
	private double salePrice;
	
	private boolean availability;
}
