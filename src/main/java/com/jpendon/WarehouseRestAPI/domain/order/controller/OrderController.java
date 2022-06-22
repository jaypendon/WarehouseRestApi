package com.jpendon.WarehouseRestAPI.domain.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpendon.WarehouseRestAPI.domain.order.dto.OrderResponse;
import com.jpendon.WarehouseRestAPI.domain.order.model.Order;
import com.jpendon.WarehouseRestAPI.domain.order.service.IOrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired 
	private IOrderService orderService;

	@GetMapping("/")
	public Page<OrderResponse> getOrders(Pageable pageable) {
		return orderService.getOrders(pageable);
	}
	
	@GetMapping("/{orderId}")
	public OrderResponse getOrder(@PathVariable("orderId") Long id) {
		return orderService.getOrderById(id);
	}
	
	@DeleteMapping("/{orderId}")
	public String deleteOrderById(@PathVariable("orderId") Long id) {
		orderService.deleteOrderById(id);
		
		return "Successfully delete order id - " + id;
	}
}
