/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.dao;
import com.takealotreg.model.User;
import java.util.List;

import com.takealotreg.model.OrderDetails;

public interface OrderDao {


	public void saveOrderDetails(OrderDetails order);
	public User getOrderByEmailAddress(String emailAddress);
	
	public List<OrderDetails> getAllOrderDetails();
	public OrderDetails getOrderDetails(int orderId);
        public void deleteOrderById(int orderId);

}