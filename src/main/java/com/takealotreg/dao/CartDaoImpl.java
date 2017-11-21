/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.takealotreg.model.Cart;
import com.takealotreg.model.User;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {
	
	 @Autowired
	    private SessionFactory sessionFactory;

	@Override
	public User validate(String emailAddress, String password) {
		Session sess=sessionFactory.getCurrentSession();
		String hql="FROM User u where u.emailAddress=:emailAddress and u.password=:password";
		Query query = sess.createQuery(hql);
		query.setParameter("emailAddress",emailAddress);
		query.setParameter("password",password);
		List results = query.list();
		User us=null;
		
		if(results.size()>0){
			us=(User) results.get(0);
			return us;
		}else{
			return us;
		}
		
	}

	@Override
	public void saveProduct(Cart product) {
	Session sess=sessionFactory.getCurrentSession();
	System.out.println("In Dao");
	sess.save(product);
		
	}
        @Override
	public void updateProduct(Cart product) {
	Session sess=sessionFactory.getCurrentSession();
	System.out.println("In Dao");
	sess.update(product);
		
	}
        @Override
	public void deleteProduct(Cart product) {
	Session sess=sessionFactory.getCurrentSession();
	System.out.println("In Dao");
	sess.delete(product);
		
	}

	@Override
	public User getUserByEmailAddress(String emailAddress) {
            Session sess=sessionFactory.getCurrentSession();
            String hql="FROM User u where u.emailAddress=:emailAddress";
            Query query = sess.createQuery(hql);
            query.setParameter("emailAddress",emailAddress);
            List results = query.list();
            User us=null;
            
            if(results.size()>0){
			us=(User) results.get(0);
			return us;
		}else{
			return us;
		}
	}

	@Override
	public List<Cart> getAllProducts(String emailAddress) {
	String hql="from Cart a where u.emailAddress=:emailAddress";
	Session sess=sessionFactory.getCurrentSession();
	Query qry=sess.createQuery(hql);
	System.out.println("***"+emailAddress);
	qry.setString("emailAddress", emailAddress);
	List<Cart> alist=qry.list();
	System.out.println(alist.size());
	return alist;
	}

	@Override
	public Cart getProduct(int productId) {
		Session sess=sessionFactory.getCurrentSession();
		Cart art=(Cart) sess.load(Cart.class, productId);
		return art;
	}
	
	

}
