package com.istrategies.movierental.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieCatalogDTO {
	
	private long id;
	private String title;
	private String movieDescription;
	private int movieStock;
	private double rentalPrice;
	private double salePrice;
	private boolean availability;

}
