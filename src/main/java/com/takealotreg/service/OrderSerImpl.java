/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takealotreg.dao.OrderDao;
import com.takealotreg.model.OrderDetails;
import com.takealotreg.model.User;

@Service("orderService")

public class OrderSerImpl implements OrderSer {

	@Autowired
	private OrderDao dao;
	
		
	public void setDao(OrderDao dao) {
		this.dao = dao;
	}




	

	@Override
	public int saveOrderDetails(OrderDetails order) {
        int res=0;
		try{
			System.out.println("In Dao");
		 dao.saveOrderDetails(order);
		 res=1;
		}catch(Exception e){
			
			
			
		}
		return res;
		
	}

@Override
	public User getOrderByEmailAddress(String emailAddress) {
		// TODO Auto-generated method stub
		return dao.getOrderByEmailAddress(emailAddress);
	}




	@Override
	public List<OrderDetails> getAllOrderDetails() {
		// TODO Auto-generated method stub
		return dao.getAllOrderDetails();
	}




	@Override
	public OrderDetails getOrderDetails(int orderId) {
		// TODO Auto-generated method stub
		return dao.getOrderDetails(orderId);
	}
  


 
}
