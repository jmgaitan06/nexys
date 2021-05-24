package com.example.stock.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockDTO {
	
	private Integer id;
		
	private String name;

	private String description;
	
	private Integer stock;
	
	private Boolean state;

}
