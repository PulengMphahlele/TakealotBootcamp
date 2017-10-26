/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productId")
	private int productId;
	
	@Column(name="cartProductName")
	private String cartProductName;
	
	
	@Column(name="cartProductPrice")
	private String cartProductPrice;
	
	
	@ManyToOne
	@JoinColumn(name="userID",nullable=false)
	private User users;

	public int getProductId() {
		return productId;
	}

	public void setCartId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return cartProductName;
	}

	public void setProductName(String cartProductName) {
		this.cartProductName = cartProductName;
	}


	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public String getProductPrice() {
		return cartProductPrice;
	}

	public void setProductPrice(String cartProductPrice) {
		this.cartProductPrice = cartProductPrice;
	}
	
	
}
