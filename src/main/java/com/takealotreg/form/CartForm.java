/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.form;

public class CartForm {
	
        private int cartId;
	private String cartProductName;
	
	private int productId;

	private float cartProductPrice;
        
        private int cartProductQuantity;

        public int getCartProductQuantity() {
        return cartProductQuantity;
    }

    public void setCartProductQuantity(int cartProductQuantity) {
        this.cartProductQuantity = cartProductQuantity;
    }
	
	private String emailAddress;
        
        
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

        public int getCartId() {
            return cartId;
        }

        public void setCartId(int cartId) {
            this.cartId = cartId;
        }
	
	

}
