/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.model;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Basic;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.persistence.*;
import javax.validation.constraints.Min;
import org.springframework.web.multipart.MultipartFile;

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
	String productImage;
	
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="productPrice")
	private float productPrice;
        
  

     public Product(){};
    
    public Product(int productId, String productName, float productPrice, String productImage) {
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

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
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
                            + productName + ", productImage="
                            + productImage + ", productPrice=" + productPrice + "]";
	}
	
	
}
