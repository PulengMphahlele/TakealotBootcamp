/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.dao;

import java.util.List;

import com.takealotreg.model.Cart;
import com.takealotreg.model.User;

public interface CartDao {
	
	public User validate(String user,String pass);
	public void saveProduct(Cart product);
        public void updateProduct(Cart product);
        public void deleteProduct(Cart product);
	public User getUserByEmailAddress(String emailAddress);
	public List<Cart> getAllProducts(String emailAddress);
	public Cart getProduct(int productId);
        public void deleteCartById(Cart cart);
        public Cart getCartByProductId(int productId , int userId);

}