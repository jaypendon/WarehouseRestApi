package com.jpendon.WarehouseRestAPI.domain.order.dto;

import java.util.Collection;

import com.jpendon.WarehouseRestAPI.domain.product.dto.ProductResponse;
import com.jpendon.WarehouseRestAPI.domain.user.dto.UserResponse;
import com.jpendon.WarehouseRestAPI.domain.user.model.User;

public record OrderResponse (
	Long id, 
	Collection<ProductResponse> products, 
	UserResponse user,
	Collection<OrderedProductsResponse> orderedProducts	
		){

}
