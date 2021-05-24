package com.example.stock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockResponseDTO {

	private Integer code;

	private String message;
	
	private StockDTO product;
	
	private List<StockDTO> products;

}
