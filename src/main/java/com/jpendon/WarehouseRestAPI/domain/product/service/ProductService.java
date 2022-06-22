package com.jpendon.WarehouseRestAPI.domain.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpendon.WarehouseRestAPI.domain.product.model.Product;
import com.jpendon.WarehouseRestAPI.domain.product.repository.ProductRepository;


@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository; 
	
	@Override
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product findById(Long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
	}

}
