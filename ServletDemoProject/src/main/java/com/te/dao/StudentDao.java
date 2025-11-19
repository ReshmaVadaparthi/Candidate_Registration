package com.te.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.te.entity.Student;
import com.te.util.HibernateUtil;


public class StudentDao {

	public void saveStudent(Student student) {
		
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
			session.persist(student);	
			transaction.commit();
		
		}
		
		catch(Exception e) {
			if(transaction!=null){
				transaction.rollback();
			}
			e.printStackTrace();
		}	
		
	}
	
	public Student getStudent(String username , String gender, String location) {
		
		Student student = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
		   student = session.createQuery("from Student where username = :username and gender = :gender and location = :location", Student.class)
				     .setParameter("username", username)
				     .setParameter("gender" , gender)
				     .setParameter("location", location)
				     .uniqueResult();
		   
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return student;
	}
	
}
