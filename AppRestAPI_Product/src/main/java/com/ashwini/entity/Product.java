package com.ashwini.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	Integer productId;
	@Column(name="product_name")
	String productName;
	@Column(name="product_quantity")
	Integer productquantity;
	@Column(name="product_price")
	Double productPrice;
	
	public Product()
	{
		
	}
	public Product(Integer productId, String productName, Integer productquantity, Double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productquantity = productquantity;
		this.productPrice = productPrice;
	}
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductquantity() {
		return productquantity;
	}
	public void setProductquantity(Integer productquantity) {
		this.productquantity = productquantity;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
