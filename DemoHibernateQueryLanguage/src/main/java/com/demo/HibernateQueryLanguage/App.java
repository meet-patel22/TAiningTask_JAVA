package com.demo.HibernateQueryLanguage;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);

		Session session = sf.openSession();
		session.beginTransaction();
		Random r = new Random();

		// for(int i=0;i<=50;i++)
		// {
		// Student s=new Student();
		// s.setRollno(i);
		// s.setName("name"+i);
		// s.setMarks(r.nextInt(100));
		// session.save(s);
		//
		// }

		// Query q=session.createQuery("from Student where marks>50");
		// Query q=session.createQuery("select rollno,marks,name from Student where
		// rollno=5");
		Query q = session.createQuery("select sum(marks) from Student where marks>60 ");

		List students = (List) q.list();
		for (Object marks : students)
			System.out.println(marks);

		// Object[]student= (Object[]) q.uniqueResult();
		// System.out.println(student[0] + ":" +student[1]+ ":" +student[2]);
		// for(Object o:student)
		// {
		// System.out.println(o);
		// }

		// Student student=(Student) q.uniqueResult();
		// System.out.println(student);

		// List<Student> student=q.list();

		// for(Student s:student)
		// {
		// System.out.println(s);
		// }
		//

		session.getTransaction().commit();

	}
}
