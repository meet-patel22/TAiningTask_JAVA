package com.demo.HibernateCache;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;

public class App {
	public static void main(String[] args) {

		// UserName un = new UserName();
		// un.setFname("meet");
		// un.setMname("nitin");
		// un.setLname("patel");
		// User user = new User();
		//
		// user.setUserId(2);
		// user.setUserName(un);
		// // user.setLastName("patel");

		User user = null;

		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);

		Session session1 = sf.openSession();
		session1.beginTransaction();

		Query q1 = session1.createQuery("from User where userid=1");
		q1.setCacheable(true);
		user = (User) q1.uniqueResult();

		// user= (User)session1.get(User.class,1);
		System.out.println(user);

		session1.getTransaction().commit();
		session1.close();

		Session session2 = sf.openSession();
		session2.beginTransaction();

		Query q2 = session2.createQuery("from User where userid=1");
		q1.setCacheable(true);
		user = (User) q2.uniqueResult();

		// user= (User)session2.get(User.class,1);
		System.out.println(user);

		session2.getTransaction().commit();
		session2.close();

		// user = (User) session1.get(User.class, 2);

		// session.save(user);

	}
}
