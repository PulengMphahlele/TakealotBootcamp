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

import com.takealotreg.model.OrderDetails;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

	 @Autowired
	    private SessionFactory sessionFactory;

	
	@Override
	public void saveOrderDetails(OrderDetails order) {
	Session sess=sessionFactory.getCurrentSession();
	System.out.println("In Dao");
	sess.save(order);
		
	}

        @Override
	public User getOrderByEmailAddress(String emailAddress) {
	String hql="from User u where u.emailAddress=:emailAddress";
	Session sess=sessionFactory.getCurrentSession();
	Query qry=sess.createQuery(hql);
	System.out.println("***"+emailAddress);
	qry.setParameter("emailAddress", emailAddress);
	User u=(User) qry.uniqueResult();

	return u;
	
	}

	@Override
	public List<OrderDetails> getAllOrderDetails() {
	String hql="from Product";
	Session sess=sessionFactory.getCurrentSession();
	Query qry=sess.createQuery(hql);
	List<OrderDetails> alist=qry.list();
	System.out.println(alist.size());
	return alist;
	}

	@Override
	public OrderDetails getOrderDetails(int orderId) {
		Session sess=sessionFactory.getCurrentSession();
		OrderDetails prod=(OrderDetails) sess.load(OrderDetails.class, orderId);
		return prod;
	}
	
	  @Override
        public void deleteOrderById(int orderId) {
            
                OrderDetails ord = new OrderDetails();
		Session sess=sessionFactory.getCurrentSession();
                ord.setOrderId(orderId);
		sess.delete(ord);

        }
}
