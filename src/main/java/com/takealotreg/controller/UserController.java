package com.takealotreg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.takealotreg.form.UserForm;
import com.takealotreg.form.CartForm;
import com.takealotreg.model.Cart;
import com.takealotreg.model.User;
import com.takealotreg.model.Admin;
import com.takealotreg.model.Product;
import com.takealotreg.service.UserService;
import com.takealotreg.service.CartService;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@RestController


public class UserController {

	@Autowired
	private UserService service;
        @Autowired
	private CartService ser;
	
      
        /*
	 * This method will list all existing Users.
	 
	@RequestMapping(value = {"/index"}, method = RequestMethod.GET)
	public String homePage() {
		return "index";
	}
        */
        
        @RequestMapping(value = "/isvalid", method = RequestMethod.POST)
                public User isValid(@RequestBody User user){

                        User us= service.isValidUser(user.getEmailAddress(), user.getPassword());
                        System.out.println(us.getEmailAddress());

                                return us;
                        }

                @RequestMapping(value = "/validAdmin", method = RequestMethod.POST)
                public Admin validAdmin(@RequestBody Admin admin){

                        Admin us= service.validAdmin(admin.getEmailAddress(), admin.getPassword());
                        System.out.println(us.getEmailAddress());

                                return us;
                        }
	//-------------------Create a User--------------------------------------------------------
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public User createUser(@RequestBody UserForm user){
		User us=new User();
                
                us.setUserID(user.getUserID());
		us.setFirstName(user.getFirstName());
		us.setLastName(user.getLastName());
		us.setEmailAddress(user.getEmailAddress());
                us.setPassword(user.getPassword());
		us.setPhone(user.getPhone());
                us.setGender(user.getGender());
		us.setBirthdate(user.getBirthdate());
		
                
		int res= service.saveUser(us);
		if(res==1){
			return us;
		}
		return null;
	
		}
      //-------------------Add to cart--------------------------------------------------------
	
        @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public Cart addCart(@RequestBody CartForm product){
		Cart prod=new Cart();
                prod.setProductId(product.getProductId());
                prod.setProductName(product.getProductName());
		prod.setProductPrice(product.getProductPrice());
                prod.setProductQuantity(product.getProductQuantity());
		prod.setUsers(ser.getUserByEmailAddress(product.getEmailAddress()));
		
		int res= ser.saveProduct(prod);
		if(res==1){
			return prod;
		}
		return null;
	
		}
        
        //-------------------Updating cart--------------------------------------------------------
	
        @RequestMapping(value = "/updateCart", method = RequestMethod.PUT)
	public Cart updateCart(@RequestBody CartForm product){
		Cart prod=new Cart();
                prod.setProductId(product.getProductId());
                prod.setProductName(product.getProductName());
		prod.setProductPrice(product.getProductPrice());
                prod.setProductQuantity(product.getProductQuantity());
		prod.setUsers(ser.getUserByEmailAddress(product.getEmailAddress()));
		
		int res= ser.updateProduct(prod);
		if(res==1){
			return prod;
		}
		return null;
	
		}
	
	@RequestMapping(value = "/getCart", method = RequestMethod.POST)
	public List<Cart> getProduct(@RequestBody User user){
		List<Cart> prodList=new ArrayList<>();

	prodList=ser.getAllProducts(user.getEmailAddress());
		return prodList;
	}
	
	@RequestMapping(value = "/getProd", method = RequestMethod.POST)
	public Cart getCartDetail(@RequestBody Cart prod){
	Cart artcl=new Cart();

	artcl=ser.getProduct(prod.getProductId());
		return artcl;
	}
        
        	 //------------------- Delete a Product --------------------------------------------------------
     
//    @RequestMapping(value = "/deleteProd/{productId}", method = RequestMethod.DELETE)
//    public ResponseEntity<Cart> deleteProduct(@PathVariable("productId") int productId, int userId) {
//        System.out.println("Fetching & Deleting Product with id " + productId);
// 
//        Cart product = ser.getCartByPriductId(int productId , int userId);
//        if (product == null) {
//            System.out.println("Unable to delete. User with id " + productId + " not found");
//            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
//        }
// 
//        service.deleteProductById(product);
//        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
//    }
//        
        @RequestMapping(path="/deleteProduct/{userId}",method=RequestMethod.DELETE)
        public ResponseEntity<Void> deleteById(@PathVariable ("productId") Cart cart) {
            ser.deleteCartById(cart);
            return ResponseEntity.noContent().build();
        }

}
