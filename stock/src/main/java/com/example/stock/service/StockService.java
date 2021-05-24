package com.example.stock.service;

import com.example.stock.dto.StockDTO;
import com.example.stock.dto.StockResponseDTO;

public interface StockService {
	
	public StockResponseDTO saveOrUpdateProduct(StockDTO request);
	
	public StockResponseDTO getProducts();
	
	public StockResponseDTO deleteProduct(Integer id);

}
