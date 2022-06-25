package com.jpendon.WarehouseRestAPI.domain.order.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jpendon.WarehouseRestAPI.domain.order.dto.OrderResponse;
import com.jpendon.WarehouseRestAPI.domain.order.model.Order;
import com.jpendon.WarehouseRestAPI.domain.product.dto.ProductSaleRequest;

public interface IOrderService {
	
	List<Order> getOrders();
			
	Order getOrderById(Long id);
	
	void deleteOrderById(Long id);
	
	Order createOrder(Order order);

	
	
}
