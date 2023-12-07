package com.srishti.Hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

//to allow the class to save in db - if we mention name, hibernate will create a table with that name in the DB @Entity(name = "Student_new") -  (use - <property name="hbm2ddl.auto">create</property>) 
@Entity

//need to mention only when name of table is different from the class name.
//@Table(name = "student")

//Second level cacheß
//@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student {
	
	@Id
	private int id;
	
	//@Transient - used to avoid the creation of the col.(use - <property name="hbm2ddl.auto">create</property>) 
	
	//Below is embedded example
	/*
	 * @Embedded private Name name;
	 */
	
	private String name;
	
	//Col added to explain relationships
	//@OneToOne - use just laptop instead of laptop list
	//@OneToMany(mappedBy = "stu")  //- creates a new table student_laptop to store the mapping
	//to avoid creation of the extra table we need to add @ManytoOne mapping in Laptop class for student.
	//that way the mapping will be done in laptop table only
//	@ManyToMany(mappedBy = "stu")
//	private List<Laptop> laptop;
	
	//Early/Lazy loading example
	//@OneToMany(mappedBy = "stu", fetch = FetchType.EAGER)
	//private Collection<Laptop> laptop = new ArrayList<Laptop>();
	

	//@Column(name = "marks") - used to create col name according to what is mentioned in brackets - (use - <property name="hbm2ddl.auto">create</property>) 
	private int age;
	
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	public Collection<Laptop> getLaptop() {
//		return laptop;
//	}
//	public void setLaptop(Collection<Laptop> laptop) {
//		this.laptop = laptop;
//	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	

}

