package com.example.stock.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.dto.StockDTO;
import com.example.stock.dto.StockResponseDTO;
import com.example.stock.entity.StockEntity;
import com.example.stock.repository.StockRepository;
import com.example.stock.service.StockService;
import com.example.stock.util.MapperUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	private static final Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);

	@Override
	public StockResponseDTO saveOrUpdateProduct(StockDTO request) {
		StockResponseDTO response = new StockResponseDTO();
		try {
			logger.info("request: " + request.toString());
			StockEntity entity = new StockEntity();
			entity.setId(request.getId());
			entity.setName(request.getName());
			entity.setDescription(request.getDescription());
			entity.setStock(request.getStock());
			entity.setState(Boolean.TRUE);
			stockRepository.save(entity);
			request.setId(entity.getId());
			response.setCode(0);
			response.setMessage("OK");
			response.setProduct(request);
		} catch (Exception e) {
			logger.error("", e);
			response.setCode(1);
			response.setMessage("Error in creating or updating proces");
		}
		logger.info("response: " + response.toString());
		return response;
	}

	@Override
	public StockResponseDTO getProducts() {
		StockResponseDTO response = new StockResponseDTO();
		try {
			List<StockDTO> products = new ArrayList<>();
			List<StockEntity> findAllByState = stockRepository.findAllByStateTrue();
			if (!findAllByState.isEmpty()) {
				for (StockEntity stockEntity : findAllByState) {
					products.add(MapperUtil.stockEntityToDto(stockEntity));
				}
				response.setCode(0);
				response.setMessage("OK");
				response.setProducts(products);
			} else {
				response.setCode(4);
				response.setMessage("not exist active products");
			}
		} catch (Exception e) {
			logger.error("", e);
			response.setCode(2);
			response.setMessage("Error getting products");
		}
		logger.info("response: " + response.toString());
		return response;
	}

	@Override
	public StockResponseDTO deleteProduct(Integer id) {
		StockResponseDTO response = new StockResponseDTO();
		try {
			Optional<StockEntity> findById = stockRepository.findById(id);
			if (findById.isPresent()) {
				StockEntity entity = findById.get();
				entity.setState(Boolean.FALSE);
				stockRepository.save(entity);
				response.setCode(0);
				response.setMessage("OK");
			} else {
				response.setCode(3);
				response.setMessage("the product don't exist");
			}
		} catch (Exception e) {
			logger.error("", e);
			response.setCode(4);
			response.setMessage("Error deleting product");
		}
		logger.info("response: " + response.toString());
		return response;
	}

}
