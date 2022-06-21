package com.jpendon.WarehouseRestAPI.domain.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpendon.WarehouseRestAPI.domain.user.model.User;


@Repository
public interface UserRepository extends CrudRepository<User,Long> {

	
}
