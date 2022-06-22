package com.jpendon.WarehouseRestAPI.domain.product.dto;

import java.util.Collection;

public record ProductSaleRequest (
		Long userId,
		Collection<ProductRequested> productsRequested	
		){

}
