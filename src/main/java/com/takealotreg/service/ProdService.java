/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.service;

import java.util.List;

import com.takealotreg.model.User;
import com.takealotreg.model.Product;

public interface ProdService {


	public int saveProduct(Product product);
        public Product getProductByPriductId(int productId);
	public List<Product> getAllProducts();
	public Product getProduct(int productId);
     
}
