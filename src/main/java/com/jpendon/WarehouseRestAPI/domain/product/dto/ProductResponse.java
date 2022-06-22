package com.jpendon.WarehouseRestAPI.domain.product.dto;

public record ProductResponse (
		Long id,
		String productName, 
		Long amount, 
		Double price		
		) {
}
