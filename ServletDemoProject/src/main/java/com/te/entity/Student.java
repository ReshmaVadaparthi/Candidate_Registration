package com.te.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student_details")
public class Student {

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   
   
   private String name;
   
   private String gender;
   
   private String location;
   
   
   public Student(String name, String gender, String location) {

	this.name = name;
	this.gender = gender;
	this.location = location;
}
   
   public Student() {
	   
   }

   public int getId() {
	return id;
   }

   public void setId(int id) {
	this.id = id;
   }

   public String getName() {
	return name;
   }

   public void setName(String name) {
	this.name = name;
   }

   public String getGender() {
	return gender;
   }

   public void setGender(String gender) {
	this.gender = gender;
   }

   public String getLocation() {
	return location;
   }

   public void setLocation(String location) {
	this.location = location;
   }
   
      	
}
