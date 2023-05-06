package com.school.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.school.connection.HyberConfig;
import com.school.model.Admin;


public class AdminLoginOperation {
	SessionFactory sf=null;
	
	public AdminLoginOperation() {
		sf=HyberConfig.getSessionFactory();
	}
	public Admin checkLoginDetails(String uname,String pwd) {
		Session session=sf.openSession();
		TypedQuery qry=session.createQuery("from UserAdmin");
		List<Admin> pall=qry.getResultList();
		Admin user=null;
		for(Admin p:pall) {
			if(p.getEmail().equals(uname)&&p.getPwd().equals(pwd)) {
				user=new Admin();
				user =p;
				break;
			}
			
		}
		return user;
	}
	}
	
	

