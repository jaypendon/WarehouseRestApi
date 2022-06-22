package com.jpendon.WarehouseRestAPI.domain.order.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jpendon.WarehouseRestAPI.domain.user.model.User;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long orderId;
	
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="user_id", nullable=false)
	private User user;
		
	@OneToMany(mappedBy="order", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<OrderedProducts> orderedProducts; 
	
	
	public Order() {
		
	}
	
	public Order(User user) {
		this.user = user;
	}

	public Order(User user, List<OrderedProducts> orderedProducts) {
		this.user = user;
		this.orderedProducts = orderedProducts;
	}

	public Long getId() {
		return orderId;
	}

	public void setId(Long id) {
		this.orderId = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public List<OrderedProducts> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(List<OrderedProducts> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}

	
}
