package com.istrategies.movierental.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * REST Response Model
 * @author CrisR
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRest {
	
	private String title;
	private String movieDescription;
	private int movieStock;
	private double rentalPrice;
	private double salePrice;
	private boolean availability;

}
