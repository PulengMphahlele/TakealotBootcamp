package com.takealotreg.controller;

import com.takealotreg.form.FileBucket;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import com.takealotreg.model.Product;
import com.takealotreg.service.ProdService;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController


public class ProdController {

	@Autowired
	private ProdService service;
        
        
	
      
        
	//-------------------Add Product--------------------------------------------------------
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST, headers="Accept=application/json")
	public  @ResponseBody String addProduct(@RequestBody Product product) throws IOException{
		
                    
		System.out.println(product);
                
		service.saveProduct(product);

		return "Ok";
	
		}
        
        @RequestMapping(value = "/getAllProducts", method = RequestMethod.POST)
	public List<Product> getProducts(){
		List<Product> prodList=new ArrayList<>();

	prodList=service.getAllProducts();
		return prodList;
	}
	
	@RequestMapping(value = "/getProduct", method = RequestMethod.POST)
	public Product getProductDetail(@RequestBody Product pro){
	Product prod=new Product();

	prod=service.getProduct(pro.getProductId());
		return prod;
	}
        
	 //------------------- Delete a Product --------------------------------------------------------
     
    @RequestMapping(value = "/deleteProd/{productId}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteProduct(@PathVariable("productId") int productId) {
        System.out.println("Fetching & Deleting Product with id " + productId);
 
        Product product = service.getProductByPriductId(productId);
        if (product == null) {
            System.out.println("Unable to delete. User with id " + productId + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
 
        service.deleteProductById(product);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }
    
       // saving the New product
   
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, headers="Accept=application/json")
     public @ResponseBody Product newProduct
            (@RequestParam(value = "productImage") MultipartFile productImage,@RequestParam(value = "productId") String productId,
             @RequestParam(value = "productName") String productName,@RequestParam(value = "productPrice") Integer productPrice,
             @RequestParam(value = "productQuantity") Integer productQuantity) {
     
              
      byte [] byteArr = null;
            try {
                byteArr = productImage.getBytes();
                System.out.println("image..."+ productImage);
                
            } catch (IOException ex) {
                Logger.getLogger(ProdController.class.getName()).log(Level.SEVERE, null, ex);
            }
      InputStream inputStream = new ByteArrayInputStream(byteArr);
            try {
                inputStream.read(byteArr);
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ProdController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
              Product item=new Product();
              item.setProductId(productId);
              item.setProductName(productName);
              item.setProductPrice(productPrice);
              item.setProductQuantity(productQuantity);
              item.setProductImage(byteArr);
              
              System.out.print(item);
              service.saveProduct(item);
            
              return null;
         }
}