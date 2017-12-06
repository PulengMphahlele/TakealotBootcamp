/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takealotreg.dao.ProdDao;
import com.takealotreg.model.Product;
import com.takealotreg.model.User;

@Service("prodService")

public class ProdServiceImpl implements ProdService {

	@Autowired
	private ProdDao dao;
	
		
	public void setDao(ProdDao dao) {
		this.dao = dao;
	}




	

	@Override
	public int saveProduct(Product product) {
        int res=0;
		try{
			System.out.println("In Dao");
		 dao.saveProduct(product);
		 res=1;
		}catch(Exception e){
			
			
			
		}
		return res;
		
	}

@Override
	public Product getProductByPriductId(int productId) {
		// TODO Auto-generated method stub
		return dao.getProductByProductId(productId);
	}




	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAllProducts();
	}




	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return dao.getProduct(productId);
	}
        
        @Override 
        public void deleteProductById(Product product) {
                       dao.deleteProductById(product);
               }


 
}
