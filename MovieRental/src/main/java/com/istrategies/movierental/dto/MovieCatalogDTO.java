package com.istrategies.movierental.dto;

import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieCatalogDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String title;
	private String movieDescription;
	private int movieStock;
	private double rentalPrice;
	private double salePrice;
	private boolean availability = true;

}
