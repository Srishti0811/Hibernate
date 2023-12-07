Hibernate

create a maven-archetype-quickstart project - (meaning Spring core)


Prereq: Core Java, Connector- JDBC, MySql(RDBMS)

Solution to store data into database without using SQL.
If we have an obj - Student : 3 properties - name, marks, age.

For saving the above obj we can just say save(obj) instead of knowing SQL.

ORM - Object relational Mapping is used to do so. 
Class structure is same as table structure. Class represents table. Object1 represents row 1

To create this relationship we use ORM.

To implement ORM we need to use some tool. One such tool is Hibernate/iBatis.

To save(obj) we can create a Session obj. To create session we need to create object of SessionFactory. In SessionFactory we need to provide config details.

We can config using XML or java. We need to provide Drivername, url, username, password.

Add mySql and hibernate core dependencies in pom.xml.

Need to install a JBoss Plugin as well using marketPlace. Search hibernate and search for JBoss which has hibernate in description.

To add the database config we use hibernate.cfg.xml. When we create a new file, search hibernate config file. 
Let the fold structure be the same, add database details(check drive). Finish.


https://www.youtube.com/watch?v=JR7-EdxDSf0

//Once done check JPA.