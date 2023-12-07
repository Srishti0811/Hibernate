package com.srishti.Hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.sql.internal.SQLQueryParser;

import jakarta.persistence.FetchType;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class App 
{
    public static void main( String[] args )
    {
//    1.	//Main Hibernate Code for saving/inserting an object into DB:
        
    	Student stu = new Student();
        stu.setId(155);
        stu.setName("Phil");
        stu.setAge(31);
        
        
        //Main Hibernate Code below:
        //Configuration is a class - no need to mention the config file name as its default. If the name is different (other than hibernate.cfg.xml) mention it -  configure("hibernate.cfg.xml");
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
       
        //SessionFactory is an interface which needs to be implemented.
        SessionFactory sf = con.buildSessionFactory();
        
        //Session is an interface which needs to be implemented.
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(stu);		
        
        tx.commit();
//    	
    	
//   2. 	//Code to fetch record from Database
//    	
//    	 Student stu = null;
//    	 
//    	 Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
//    	 SessionFactory sf = con.buildSessionFactory();
//    	 Session session = sf.openSession();
//    	 Transaction tx = session.beginTransaction();
//    	 
//    	 stu = (Student) session.get(Student.class, 2);
//    	 
//    	 tx.commit();
//    	 System.out.println(stu);
//   
    	
//  3.  //To save: Embedded example
    	
    	
		/*
		 * Name n = new Name(); n.setFname("Srishti"); n.setLname("Dixit");
		 * 
		 * Student st = new Student(); st.setId(5); st.setAge(43); st.setName(n);
		 * 
		 * Configuration con = new
		 * Configuration().configure().addAnnotatedClass(Student.class); SessionFactory
		 * sf = con.buildSessionFactory(); Session session = sf.openSession();
		 * Transaction tx = session.beginTransaction();
		 * 
		 * session.save(st);
		 * 
		 * tx.commit();
		 */
    	
 //		4. Example for relationships - many-one etc
//    	
//    	Laptop lap = new Laptop();
//    	lap.setName("Mac");
//    	lap.setId(102);
//    	
//    	ArrayList<Laptop> lapList = new ArrayList<Laptop>();
//    	lapList.add(lap);
//    	
//    	Student stu = new Student();
//    	stu.setName("Srishti");
//    	stu.setAge(21);
//    	stu.setId(51);
//    	stu.setLaptop(lapList);
//    	
//    	ArrayList<Student> stuList = new ArrayList<Student>();
//    	
//    	lap.setStu(stuList);
//    	
//    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
//    	SessionFactory sf = con.buildSessionFactory();
//    	Session session = sf.openSession();
//    	Transaction tx = session.beginTransaction();
//    	
//    	session.save(stu);
//    	session.save(lap);
//    	
//    	tx.commit(); //OR session.getTransaction().commit();
    	
//		5. Example for eager and Lazy fetching
    	
//    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
//    	SessionFactory sf = con.buildSessionFactory();
//    	Session session = sf.openSession();
//    	Transaction tx = session.beginTransaction();
//    	
//    	
//    	//incase of lazy load it will only run 1 query to fetch the name
//    	//to change it to eager load -> in student - OneToMany(fetch = FetchType.EAGER)
//    	Student st = session.get(Student.class, 51);
//    	
//    	
//    //	When below is called another query is executed to fetch lap details.
//    	Collection<Laptop> laps = st.getLaptop();
//    	
//    	for(Laptop lap:laps) {
//    		System.out.println(lap.getId());
//    	}
//    	
//    	System.out.println(st.getName());
//    	
//    	
//    	    	
//    	tx.commit();
    	
    	
    	//6. Hibernate Cache
    	
//    	Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
//    	SessionFactory sf = conf.buildSessionFactory();
//    	Session session = sf.openSession();
//    	Transaction tx = session.beginTransaction();
    	
    	//First level cache:
    	//Only fetches the query 1 time provided its in the same session.
    	//Hibernate implements First level cache by default.
    	
//    	Student st = session.get(Student.class, 51);
//    	System.out.println(st.getName());
//    	//tx.commit();
//    	
//    	Student st1 = session.get(Student.class, 51);
//    	System.out.println(st1.getName());
//    	tx.commit();
    	
    	//Since its a new session, a new query is fired.
    	//Second level cache needs to be configured
    	
    	//To use second level cache: 
    		//a. add dependency for ehcache and hibernate-ehcache
    		//b. add 2 property tags in hibernate.cfg.xml 
    		//c. Specify @Cachable and @Cache annotation on the POJO class - table (student)
    		//d. Make sure hibernate-ehcache and hibernate jars are proper
    	
    	
    	//This is using get. We can also use query to fetch result. To make hibernate second
    	//level cache work we need to make some changes.
//    	Session session2 = sf.openSession();
//    	Transaction tx1 = session2.beginTransaction();
//    	
//    	Student st2 = session2.get(Student.class, 51);
//    	System.out.println(st2.getName());
//    	tx1.commit();

    	
    	//****Second Level cache when using query****
    	//Mention in conf file as well
    	
//    	Query q1 = session.createQuery("from Student where id = 51");
//    	//not showing up but a step
//		/* q1.setCachable(true); */
//    	
//    	int i = q1.getFirstResult();
//    	System.out.println(i);
//    	tx.commit();
//    	session.close();
//    	
//    	Session session2 = sf.openSession();
//    	Transaction txn = session2.beginTransaction();
//    	
//    	Query q2 = session2.createQuery("from Student where id = 51");
//    	//not showing up but a step
//    	/* q2.setCachable(true); */
//    	
//    	int i2 = q2.getFirstResult(); 
//    	System.out.println(i);
//    	
//    	txn.commit();
//    	session2.close();
    	
    	
    	//7. HQL
    	
    	//in sql we get resultset, in HQL we fetch a list of objects
    	
//    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
//    	SessionFactory sf = con.buildSessionFactory();
//    	Session session = sf.openSession();
//    	Transaction tx = session.beginTransaction();
    	
    	//Use to insert multiple rows at once
//    	Random r = new Random();
//    	
//    	for(int i = 1; i <= 50; i++) {
//    		Student s = new Student();
//    		s.setId(i);
//    		s.setAge(r.nextInt(50));
//    		s.setName("Name" + i);
//    		session.save(s);
//    		
//    		
//    	}
//    	
    	
    	//To fetch records
    	
    	//To fetch all the records:
    	
    	//Query q = session.createQuery("from Student"); - or -  from Student where age < 10;
    	//List<Student> list = q.getResultList();
    	
//    	for(Student s : list) {
//    		System.out.println(s);
//    	}
    	
    	//To fetch specific record:
//    	Query q = session.createQuery("from Student where id = 30");
//    	Student s = (Student)q.getSingleResult();
//    	
//    	System.out.println(s);
    	
    	//To fetch using col names:
//    	Query q = session.createQuery("select id, age, name from Student where id = 30");
//    	Object[] student = (Object[])q.getSingleResult();
//    	
//    	for(Object s : student) {
//    		System.out.println(s);
//    	}
//    	
//    	//OR
//    	Query q1 = session.createQuery("select id, age, name from Student");
//    	List<Object[]> students = (List<Object[]>)q1.getResultList();
//    	
//    	for(Object[] s : students) {
//    		System.out.println(s[0] + " : " + s[1] + " : " + s[2]);
//    	}
//    	
//    	//OR - you can also use SQL 
//    	int a = 30;
//    	Query q2 = session.createQuery("select sum(age) from Student where age < :a");
//    	q2.setParameter("a", a);
//    	Long age = (Long)q2.getSingleResult();
//    	System.out.println(age);
//    	    	
//    	tx.commit();
//    	session.clear();
    	
    	
    	//8. Hibernate Object State
    	
//    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
//    	SessionFactory sf = con.buildSessionFactory();
//    	Session session = sf.openSession();
//    	Transaction tx = session.beginTransaction();
//    	
//    	//This is transient state
//    	Student s = new Student();
//    	s.setId(153);
//    	s.setName("Srish");
//    	s.setAge(21);
//    	
//    	//Now goes to persist state
//    	session.save(s);
//    	
//    	//Even after save if we make any changes to the obj it will be updated as it is in persistent state
//    	s.setAge(39);
//    	
//    	//We can also use remove to remove the object from db
//    	session.remove(s);
//    	
//    	
//    	tx.commit();
//    	
//    	//Any changes made after commit will not reflect in db, we dont really require detach but in some instances we might
//    	//Detach - will not update the object in db
//    	session.detach(s);
//    	s.setAge(29);
//    	
//    	
//    	session.close();
    	
    	
    	
    	//9. Get vs Load
    	
    	
//    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
//    	SessionFactory sf = con.buildSessionFactory();
//    	Session session = sf.openSession();
//    	Transaction tx = session.beginTransaction();
//    	
//    	//get fires the query each time
//    	//if there is no data fetched from the db and then we access that to get a value - nullPointer Exception
//    	System.out.println(session.get(Student.class, 150));
//    	
//    	//Load only fires when we try to use the fetched object - gives u a proxy object initially
//    	//if there is no data fetched from the db and then we access that to get a value - Object N Exception
//    	Student s = session.load(Student.class, 150));
//
//    	try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	
//    	System.out.println(s);
//    	
//    	tx.commit();
//    	session.close();
    	
    	
    }
}
