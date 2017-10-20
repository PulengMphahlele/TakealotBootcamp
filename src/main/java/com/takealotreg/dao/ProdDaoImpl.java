/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.dao;

import com.takealotreg.model.User;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.takealotreg.model.Product;

@Repository
@Transactional
public class ProdDaoImpl implements ProdDao {

	 @Autowired
	    private SessionFactory sessionFactory;

	
	@Override
	public void saveProduct(Product product) {
	Session sess=sessionFactory.getCurrentSession();
	System.out.println("In Dao");
	sess.save(product);
		
	}

        @Override
	public Product getProductByProductId(int productId) {
	String hql="from Product u where u.productId=:productId";
	Session sess=sessionFactory.getCurrentSession();
	Query qry=sess.createQuery(hql);
	System.out.println("***"+productId);
	qry.setInteger("productId", productId);
	Product u=(Product) qry.uniqueResult();

	return u;
	
	}

	@Override
	public List<Product> getAllProducts() {
	String hql="from Product";
	Session sess=sessionFactory.getCurrentSession();
	Query qry=sess.createQuery(hql);
	List<Product> alist=qry.list();
	System.out.println(alist.size());
	return alist;
	}

	@Override
	public Product getProduct(int productId) {
		Session sess=sessionFactory.getCurrentSession();
		Product prod=(Product) sess.load(Product.class, productId);
		return prod;
	}
	
	
}
