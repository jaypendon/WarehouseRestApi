package com.jpendon.WarehouseRestAPI.domain.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpendon.WarehouseRestAPI.domain.order.dto.OrderResponse;
import com.jpendon.WarehouseRestAPI.domain.order.service.IOrderService;
import com.jpendon.WarehouseRestAPI.domain.product.dto.ProductSaleRequest;
import com.jpendon.WarehouseRestAPI.domain.product.model.Product;
import com.jpendon.WarehouseRestAPI.domain.product.service.IProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@Autowired 
	private IOrderService orderService;
	
	public ProductController() {
		
	}
	
	@GetMapping("/")
	public List<Product> getAllProducts() {
		return productService.findAll();
	}
	
	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable("productId") Long productId) {
		return productService.findById(productId);
	}
	
	@PostMapping("/")
	public Product saveProduct(@RequestBody Product product) {
		productService.save(product);
		
		return product;
	}
	
	@PutMapping("/")
	public Product updateProduct(@RequestBody Product product) {
		productService.save(product);
		
		return product;
	}
	
	@DeleteMapping("/{productId}")
	public String deleteById(@PathVariable Long productId) {
		productService.deleteById(productId);
		
		return "Successfully deleted product id - " + productId;
	}	
	
	@DeleteMapping("/")
	public String delete(@RequestBody Product product) {
		productService.delete(product);
		
		return "Successfully deleted product: " + product;
	}
	
	@PostMapping("/sell")
	public OrderResponse createOrder(@RequestBody ProductSaleRequest productSaleRequest) {
		
		return orderService.createOrder(productSaleRequest);
	}
}
