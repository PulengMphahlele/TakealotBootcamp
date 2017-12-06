/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takealotreg.dao.CartDao;
import com.takealotreg.model.Cart;
import com.takealotreg.model.User;
 

 
@Service("cartService")
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao dao;

	
	
	
	public void setDao(CartDao dao) {
		this.dao = dao;
	}




	@Override
	public User isValidUser(String user, String pass) {
		// TODO Auto-generated method stub
		return dao.validate(user, pass);
	}




	@Override
	public int saveProduct(Cart product) {
        int res=0;
		try{
			System.out.println("In Dao");
		 dao.saveProduct(product);
		 res=1;
		}catch(Exception e){
			
			
			
		}
		return res;
		
	}

        @Override
	public int updateProduct(Cart product) {
        int res=0;
		try{
			System.out.println("In Dao");
		 dao.updateProduct(product);
		 res=1;
		}catch(Exception e){
			
			
			
		}
		return res;
		
	}



	@Override
	public User getUserByEmailAddress(String emailAddress) {
		// TODO Auto-generated method stub
		return dao.getUserByEmailAddress(emailAddress);
	}




	@Override
	public List<Cart> getAllProducts(String emailAddress) {
		// TODO Auto-generated method stub
		return dao.getAllProducts(emailAddress);
	}




	@Override
	public Cart getProduct(int productId) {
		// TODO Auto-generated method stub
		return dao.getProduct(productId);
	}
  
        @Override 
        public void deleteCartById(Cart cart) {
                       dao.deleteCartById(cart);
               }
 
        @Override
	public Cart getCartByPriductId(int productId , int userId) {
		// TODO Auto-generated method stub
		return dao.getCartByProductId(productId , userId);
	}

}