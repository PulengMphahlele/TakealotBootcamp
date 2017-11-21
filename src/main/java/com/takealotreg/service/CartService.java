/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.service;
import java.util.List;

import com.takealotreg.model.Cart;
import com.takealotreg.model.User;

public interface CartService {
	public User isValidUser(String user,String pass);
	public int saveProduct(Cart product);
	public User getUserByEmailAddress(String emailAddress);
	public List<Cart> getAllProducts(String emailAddress);
	public Cart getProduct(int productId);
        public int updateProduct(Cart product);
     
    /*User findById(long id);
     
    User findByName(String name);
     
    void saveUser(User user);
     
    void updateUser(User user);
     
    void deleteUserById(long id);
 
    List<User> findAllUsers(); 
     
    void deleteAllUsers();
     
    public boolean isUserExist(User user);*/
     
}