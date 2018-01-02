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
import java.util.Iterator;

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
            public Product findById(String productId) {
                for (Product product : dao.getAllProducts()) {
                        if (product.getProductId().equals(productId)) {
                                return product;
                        }
                }
                return null;
            }



	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAllProducts();
	}




	@Override
	public Product getProduct(String productId) {
		// TODO Auto-generated method stub
		return dao.getProduct(productId);
	}
        
      
    @Override
    public void updateProduct(Product product) {
	int index = dao.getAllProducts().indexOf(product);
	dao.getAllProducts().set(index, product);
    }

    @Override
    public void deleteProductById(String productId) {
	for (Iterator<Product> iterator = dao.getAllProducts().iterator(); iterator.hasNext();) {
	    Product product = iterator.next();
	    if (product.getProductId().equals(productId)) {
		iterator.remove();
	    }
	}
    }


 
}
