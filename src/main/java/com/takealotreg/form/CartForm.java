/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.form;

public class CartForm {
	
        
	private String cartProductName;
	
	private int productId;

	private float cartProductPrice;
        
        private int cartProductQuantity;
        
	private String emailAddress;
        

        public int getProductQuantity() {
        return cartProductQuantity;
        }

        public void setProductQuantity(int cartProductQuantity) {
            this.cartProductQuantity = cartProductQuantity;
        }
	        
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
        }

	public String getProductName() {
		return cartProductName;
	}

	public void setProductName(String cartProductName) {
		this.cartProductName = cartProductName;
	}

	public float getProductPrice() {
		return cartProductPrice;
	}

	public void setProductPrice(float cartProductPrice) {
		this.cartProductPrice = cartProductPrice;
	}
	

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	

}
