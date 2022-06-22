package com.jpendon.WarehouseRestAPI.domain.order.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.jpendon.WarehouseRestAPI.domain.order.model.Order;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long>{


}
