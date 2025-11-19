package com.te.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	static {
		
		try {
		  factory = new Configuration().configure().buildSessionFactory();
		}
		
	    catch(Exception e) {
	    	System.out.println(e.getMessage());
	    }
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	

}
