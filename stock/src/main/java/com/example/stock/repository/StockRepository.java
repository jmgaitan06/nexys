package com.example.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.stock.entity.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Integer> {

	List<StockEntity> findAllByState(Boolean state);
	@Query("select s from StockEntity s where s.state='true'")
	List<StockEntity> findAllByStateTrue();
	
}

