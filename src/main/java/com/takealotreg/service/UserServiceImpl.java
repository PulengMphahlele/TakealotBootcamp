/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takealotreg.dao.UserDao;
import com.takealotreg.model.Admin;
import com.takealotreg.model.User;

@Service("userService")

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
		
	public void setDao(UserDao dao) {
		this.dao = dao;
	}




	@Override
	public User isValidUser(String emailAddress, String password) {
		// TODO Auto-generated method stub
		return dao.validate(emailAddress, password);
	}


         @Override
	public Admin validAdmin(String emailAddress, String password) {
		// TODO Auto-generated method stub
		return dao.validateAdmin(emailAddress, password);
	}


	@Override
	public int saveUser(User user) {
        int res=0;
		try{
			System.out.println("In Dao");
		 dao.saveUser(user);
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
	public List<User> getAllUser(String emailAddress) {
		// TODO Auto-generated method stub
		return dao.getAllUser(emailAddress);
	}




	@Override
	public User getUser(int userID) {
		// TODO Auto-generated method stub
		return dao.getUser(userID);
	}
  
 
}
