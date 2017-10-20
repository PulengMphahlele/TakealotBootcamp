/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.dao;

import com.takealotreg.model.Admin;
import java.util.List;

import com.takealotreg.model.User;

public interface UserDao {

public User validate(String emailAddress,String password);
	public void saveUser(User user);
	public Admin validateAdmin(String emailAddress,String password);
	public User getUserByEmailAddress(String EmailADdress);
	
	public List<User> getAllUser(String emailAddress);
	public User getUser(int userID);

}
