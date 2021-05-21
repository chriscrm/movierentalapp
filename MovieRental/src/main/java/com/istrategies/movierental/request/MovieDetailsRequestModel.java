package com.istrategies.movierental.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDetailsRequestModel {
	
	private String title;
	private String movieDescription;
	private int movieStock;
	private double rentalPrice;
	private double salePrice;
	private boolean availability;

}
