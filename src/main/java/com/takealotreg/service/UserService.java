/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.service;

import java.util.List;

import com.takealotreg.model.Admin;
import com.takealotreg.model.User;

public interface UserService {

	public User isValidUser(String emailAddress,String password);
        public Admin validAdmin(String emailAddress,String password);
	public int saveUser(User user);
	public User getUserByEmailAddress(String emailAddress);
	public List<User> getAllUser(String emailAddress);
	public User getUser(int userID);
     
}
