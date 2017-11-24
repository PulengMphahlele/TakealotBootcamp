/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.takealotreg.model.User;
import com.takealotreg.model.OrderDetails;
import com.takealotreg.form.OrderDForm;
import com.takealotreg.service.OrderSer;
import java.util.ArrayList;

@RestController
public class OrderDController {

	@Autowired
	private OrderSer serv;
	
      
        
	//-------------------Add Order--------------------------------------------------------
	
	@RequestMapping(value = "/saveorderD", method = RequestMethod.POST)
	public OrderDetails saveorderD(@RequestBody OrderDForm order){
		OrderDetails ord= new OrderDetails();
                
			ord.setOrderId(order.getOrderId());
			ord.setCardNumber(order.getCardNumber());
                        ord.setAccountNumber(order.getAccountNumber());
			ord.setPhone(order.getPhone());
			ord.setCode(order.getCode());
                        ord.setAddress(order.getAddress());
                        ord.setUsers(serv.getOrderByEmailAddress(order.getEmailAddress()));
         
		System.out.println(ord);
                
		int res= serv.saveOrderDetails(ord);
		if(res==1){
			return ord;
		}
		return null;
	
		}
        
        @RequestMapping(value = "/getAllOrders", method = RequestMethod.POST)
	public List<OrderDetails> getOrders(){
		List<OrderDetails> prodList=new ArrayList<>();

	prodList=serv.getAllOrderDetails();
		return prodList;
	}
	
	@RequestMapping(value = "/getOrder", method = RequestMethod.POST)
	public OrderDetails getOrderDetail(@RequestBody OrderDetails ordr){
	OrderDetails ord=new OrderDetails();

	ord=serv.getOrderDetails(ordr.getOrderId());
		return ord;
	}

}