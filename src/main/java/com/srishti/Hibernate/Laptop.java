package com.srishti.Hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {
	
	private String name;
	@Id
	private int id;
	
	//Laptop should also know abt the student
	//to avoid table creation in case of one to Many mapping(present in laptop class)
	//Declare it here so that laptop table is only updated n no new table gets created
	//@ManyToOne
	//private List<Student> stu;
	
	
	//Early/Lazy loading example
	//@ManyToOne
	private Student stu;
	
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
