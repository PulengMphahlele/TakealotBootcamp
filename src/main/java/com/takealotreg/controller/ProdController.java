package com.takealotreg.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.takealotreg.model.Product;
import com.takealotreg.service.ProdService;


@RestController

public class ProdController {

	@Autowired
	private ProdService service;
        
   
        
	//-------------------Add Product--------------------------------------------------------
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public Product addProduct(@RequestBody Product product){
                    Product prod=new Product();
                    
                
			prod.setProductId(product.getProductId());
			prod.setProductImage(product.getProductImage());
			prod.setProductName(product.getProductName());
			prod.setProductPrice(product.getProductPrice());
         
		System.out.println(prod);
                
		int res= service.saveProduct(prod);
		if(res==1){
			return prod;
		}
		return null;
	
		}
        
        @RequestMapping(value = "/getAllProducts", method = RequestMethod.POST)
   
	public List<Product> getProducts(){
            
		List<Product> prodList=service.getAllProducts();
		return prodList;
	}
	
	@RequestMapping(value = "/getProduct", method = RequestMethod.POST)
	public Product getProductDetail(@RequestBody Product pro){
	Product prod=new Product();

	prod=service.getProduct(pro.getProductId());
		return prod;
	}

}
