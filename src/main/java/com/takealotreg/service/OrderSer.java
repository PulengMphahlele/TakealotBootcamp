/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.service;
import java.util.List;

import com.takealotreg.model.User;
import com.takealotreg.model.OrderDetails;

public interface OrderSer {


	public int saveOrderDetails(OrderDetails order);
        public User getOrderByEmailAddress(String emailAddress);
	public List<OrderDetails> getAllOrderDetails();
	public OrderDetails getOrderDetails(int orderId);
     
}
