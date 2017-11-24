/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.model;

import javax.persistence.Column;
//import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author RSS
 */
@Entity
@Table(name="orderDetails")
public class OrderDetails {
    
       @Id
	@Column(name="orderId")
	private int orderId;
        
	@Column(name="CarNumber")
	private String cardNumber;
        
        @Column(name="AccountNumber")
	private String accountNumber;
	
	@Column(name="Phone")
	private String phone;
        
        @Column(name="Code")
	private String code;
        
        @Column(name="Address")
	private String address;
	
	@Column(name="City")
	private String city;
        
      @ManyToOne
	@JoinColumn(name="UserId",nullable=false)
	private User users;
        
         
        public OrderDetails(){}
        
    public int getOrderId() {
        return orderId;
    }
       

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

   public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}
//    @Override
//	public String toString() {
//		return "OrderDetail [orderId=" + orderId + ", cardNumber=" + cardNumber + ", accountNumber="
//                            + accountNumber + ", phone=" + phone + ", address=" + address 
//                            + ", code=" + code + ", city=" + city + "]";
//	}
	
}
