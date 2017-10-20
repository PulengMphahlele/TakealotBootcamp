/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.dao;

import com.takealotreg.model.User;
import java.util.List;

import com.takealotreg.model.Product;

public interface ProdDao {


	public void saveProduct(Product product);
	public Product getProductByProductId(int productId);
	
	public List<Product> getAllProducts();
	public Product getProduct(int productId);


}
