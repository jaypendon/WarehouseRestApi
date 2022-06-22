package com.jpendon.WarehouseRestAPI.domain.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpendon.WarehouseRestAPI.domain.product.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	
}
