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
import javax.persistence.Lob;
import javax.persistence.Basic;
import javax.persistence.Table;
import javax.persistence.*;


/**
 *
 * @author User
 */
@Entity
@Table(name="product")
public class Product {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productId")
	private int productId;
	
        @Lob @Basic(fetch = FetchType.LAZY)
	@Column(name="productImage")      
	byte[] productImage;
	
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="productPrice")
	private float productPrice;
        
  

     public Product(){};
    
    public Product(int productId, String productName, float productPrice, byte[] productImage) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
      
    }
        
        public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
                            + productName + ", productPrice=" + productPrice + "]";
	}
	
	
}
