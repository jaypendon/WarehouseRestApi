package com.jpendon.WarehouseRestAPI.domain.order.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.jpendon.WarehouseRestAPI.domain.order.dto.OrderResponse;
import com.jpendon.WarehouseRestAPI.domain.order.dto.OrderedProductsResponse;
import com.jpendon.WarehouseRestAPI.domain.order.model.Order;
import com.jpendon.WarehouseRestAPI.domain.order.model.OrderedProducts;
import com.jpendon.WarehouseRestAPI.domain.order.repository.OrderRepository;
import com.jpendon.WarehouseRestAPI.domain.product.dto.ProductRequested;
import com.jpendon.WarehouseRestAPI.domain.product.dto.ProductResponse;
import com.jpendon.WarehouseRestAPI.domain.product.dto.ProductSaleRequest;
import com.jpendon.WarehouseRestAPI.domain.product.repository.ProductRepository;
import com.jpendon.WarehouseRestAPI.domain.user.dto.UserResponse;
import com.jpendon.WarehouseRestAPI.domain.user.model.User;
import com.jpendon.WarehouseRestAPI.domain.user.repository.UserRepository;

@Service
public class OrderService implements IOrderService {

	@Autowired 
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Order> getOrders() {
			
		return (List<Order>) orderRepository.findAll();	
	}
	
	
	@Override
	public Order getOrderById(Long id) {
		return orderRepository.findById(id).get();		
	}
	
	@Override
	public void deleteOrderById(Long id) {
		orderRepository.deleteById(id);
	}
	
	@Override
	public Order createOrder(Order order) {
		orderRepository.save(order);
		
		return order;
	}
	
	
	
	private OrderResponse createOrderResponse(Order order) {
		return new OrderResponse(
				order.getId(), 
				OrderService.mapResponseForOrder(order),
				new UserResponse(
						order.getUser().getId(), 
						order.getUser().getFirstName(),
						order.getUser().getLastName(), 
						order.getUser().getAddress(), 
						order.getUser().getEmail()
						),				
				OrderService.mapResponseForOrderedProducts(order)					
				);
	} 
	
	
	private static Collection<OrderedProductsResponse> mapResponseForOrderedProducts(Order order) {
		Collection<OrderedProductsResponse> orderedProductsResponse = new ArrayList<OrderedProductsResponse>(); 
		
		for (OrderedProducts orderedProduct : order.getOrderedProducts()) {
			orderedProductsResponse.add(new OrderedProductsResponse (
					orderedProduct.getAmountOrdered()
					));	
		}
		
		return orderedProductsResponse;

	}
	
	private static Collection<ProductResponse> mapResponseForOrder(Order order) {
		return order.getOrderedProducts().stream().map(
					product -> new ProductResponse(
							product.getProduct().getId(),
							product.getProduct().getProductName(), 
							product.getProduct().getAmount(), 
							product.getProduct().getPrice()							
				)).collect(Collectors.toList());
	}





}
