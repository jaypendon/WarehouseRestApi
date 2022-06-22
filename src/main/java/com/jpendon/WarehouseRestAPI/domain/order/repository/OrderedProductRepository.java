package com.jpendon.WarehouseRestAPI.domain.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpendon.WarehouseRestAPI.domain.order.model.OrderedProducts;

@Repository
public interface OrderedProductRepository extends CrudRepository<OrderedProducts, Long>{

}
