/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.takealotreg.dao;

import com.takealotreg.model.Admin;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.takealotreg.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

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
	public Admin validateAdmin(String emailAddress, String password) {
		Session sess=sessionFactory.getCurrentSession();
		String hql="FROM Admin u where u.emailAddress=:emailAddress and u.password=:password";
		Query query = sess.createQuery(hql);
		query.setParameter("emailAddress",emailAddress);
		query.setParameter("password",password);
		List results = query.list();
		Admin us=null;
		
		if(results.size()>0){
			us=(Admin) results.get(0);
			return us;
		}else{
			return us;
		}
		
	}

	@Override
	public void saveUser(User user) {
	Session sess=sessionFactory.getCurrentSession();
	System.out.println("In Dao");
	sess.save(user);
		
	}

	@Override
	public User getUserByEmailAddress(String emailAddress) {
	String hql="from User u where u.emailAddress=:emailAddress";
	Session sess=sessionFactory.getCurrentSession();
	Query qry=sess.createQuery(hql);
	System.out.println("***"+emailAddress);
	qry.setString("emailAddress", emailAddress);
	User u=(User) qry.uniqueResult();

	return u;
	
	}

	@Override
	public List<User> getAllUser(String emailAddress) {
	String hql="from User a where a.user.emailAddress=:emailAddress";
	Session sess=sessionFactory.getCurrentSession();
	Query qry=sess.createQuery(hql);
	System.out.println("***"+emailAddress);
	qry.setString("emailAddress", emailAddress);
	List<User> alist=qry.list();
	System.out.println(alist.size());
	return alist;
	}

	@Override
	public User getUser(int userID) {
		Session sess=sessionFactory.getCurrentSession();
		User us=(User) sess.load(User.class, userID);
		return us;
	}
	
	
}
