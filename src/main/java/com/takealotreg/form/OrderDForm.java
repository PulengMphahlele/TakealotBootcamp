/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.form;

/**
 *
 * @author RSS
 */
public class OrderDForm {
    
        private int orderId;
	private String cardNumber;

	private String accountNumber;
	
	private String phone;
        private String code;

	private String address;
	
	private String city;
        private String emailAddress;

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

    public String getEmailAddress() {
            return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
    }
//
//    @Override
//	public String toString() {
//		return "OrderDetail [orderId=" + orderId + ", cardNumber=" + cardNumber + ", accountNumber="
//                            + accountNumber + ", phone=" + phone + ", address=" + address 
//                            + ", code=" + code + ", city=" + city + "]";
//	}
//	
}
