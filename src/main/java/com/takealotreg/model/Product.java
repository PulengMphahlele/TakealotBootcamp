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
//import org.springframework.web.multipart.MultipartFile;


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
	private String productId;
	
//        @Lob @Basic(fetch = FetchType.LAZY)
	@Column(name="productImage")      
	byte[] productImage;
	
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="productPrice")
	private String productPrice;
        
        @Column(name="productQuantity")
	private String productQuantity;
        
//        @Transient
//        private MultipartFile file;
//
//    public MultipartFile getFile() {
//        return file;
//    }
//
//    public void setFile(MultipartFile file) {
//        this.file = file;
//    }
//  
        

     public Product(){};
    
    public Product(String productId, String productName, String productPrice, byte[] productImage, String productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productQuantity = productQuantity;
      
    }
        
        public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
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


	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
        	public String getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName 
                        + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + "]";
	}
	
	
}
