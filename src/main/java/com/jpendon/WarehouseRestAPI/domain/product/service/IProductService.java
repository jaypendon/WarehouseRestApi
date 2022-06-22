package com.jpendon.WarehouseRestAPI.domain.product.service;

import java.util.List;

import com.jpendon.WarehouseRestAPI.domain.product.model.Product;

public interface IProductService {

	public List<Product> findAll();
	
	public Product findById(Long id);
	
	public void save(Product product);	
	
	public void deleteById(Long id); 
	
	public void delete(Product product);

}
