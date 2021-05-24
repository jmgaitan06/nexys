package com.example.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.dto.StockDTO;
import com.example.stock.dto.StockResponseDTO;
import com.example.stock.service.StockService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("${server.servlet.context-path}")
public class StockController {

	@Autowired
	StockService service;

	@PostMapping(value = "/createOrUpdate/product", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "create or update product", response = String.class, httpMethod = "POST")
	@ApiResponses({ @ApiResponse(code = 200, message = "Correct"),
			@ApiResponse(code = 400, message = "Incorrect data"),
			@ApiResponse(code = 500, message = "Unspected error"),
			@ApiResponse(code = 408, message = "TimeOut") })
	public StockResponseDTO saveOrUpdateProduct(@RequestBody StockDTO request) {
		return service.saveOrUpdateProduct(request);
	}
	
	@GetMapping(value = "/get/stock", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get products", response = String.class, httpMethod = "POST")
	@ApiResponses({ @ApiResponse(code = 200, message = "Correct"),
			@ApiResponse(code = 400, message = "Incorrect data"),
			@ApiResponse(code = 500, message = "Unspected error"),
			@ApiResponse(code = 408, message = "TimeOut") })
	public StockResponseDTO getProducts() {
		return service.getProducts();
	}

	@DeleteMapping(value = "/delete/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get products", response = String.class, httpMethod = "POST")
	@ApiResponses({ @ApiResponse(code = 200, message = "Correct"),
			@ApiResponse(code = 400, message = "Incorrect data"),
			@ApiResponse(code = 500, message = "Unspected error"),
			@ApiResponse(code = 408, message = "TimeOut") })
	public StockResponseDTO deleteProduct(@PathVariable("id") Integer id) {
		return service.deleteProduct(id);
	}
	
}
