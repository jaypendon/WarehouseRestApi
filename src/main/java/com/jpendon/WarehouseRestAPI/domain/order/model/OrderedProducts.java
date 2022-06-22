package com.jpendon.WarehouseRestAPI.domain.order.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jpendon.WarehouseRestAPI.domain.product.model.Product;

@Entity
@Table(name="ordered_products")
public class OrderedProducts {

	@ManyToOne
	@JoinColumn(name="product_id", nullable=false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="order_id", nullable=false)
	private Order order;
	
	@Column(name="ordered_amount", nullable=false)
	private Long amountOrdered;
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private Long orderedProductId;
	
	public OrderedProducts() {
		
	}

	public OrderedProducts(Product product, Order order, Long amountOrdered) {
		this.product = product;
		this.order = order;
		this.amountOrdered = amountOrdered;
	}



	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Long getAmoundOrdered() {
		return amountOrdered;
	}

	public void setAmoundOrdered(Long amountOrdered) {
		this.amountOrdered = amountOrdered;
	}

	public Long getOrderedProductId() {
		return orderedProductId;
	}

	public void setOrderedProductId(Long orderedProductId) {
		this.orderedProductId = orderedProductId;
	}
	
	
}
	
	
