package com.jpendon.WarehouseRestAPI.domain.order.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jpendon.WarehouseRestAPI.domain.order.dto.OrderResponse;
import com.jpendon.WarehouseRestAPI.domain.order.model.Order;
import com.jpendon.WarehouseRestAPI.domain.product.dto.ProductSaleRequest;

public interface IOrderService {
	
	Page<OrderResponse> getOrders(Pageable pageable);
			
	OrderResponse getOrderById(Long id);
	
	void deleteOrderById(Long id);
	
	OrderResponse createOrder(ProductSaleRequest productSaleRequest);
	
}
