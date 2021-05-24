package com.example.stock.util;

import com.example.stock.dto.StockDTO;
import com.example.stock.entity.StockEntity;

public class MapperUtil {

	public static StockDTO stockEntityToDto(StockEntity entity) {
		
			StockDTO response = new StockDTO();
			response.setId(entity.getId());
			response.setName(entity.getName());
			response.setDescription(entity.getDescription());
			response.setStock(entity.getStock());
			response.setState(entity.getState());
			return response;
		
	}

}
