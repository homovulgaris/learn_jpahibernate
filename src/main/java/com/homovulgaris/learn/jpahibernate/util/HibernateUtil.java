package com.homovulgaris.learn.jpahibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.homovulgaris.learn.jpahibernate.entity.*;

public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		try {
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
			 configuration.addAnnotatedClass(Message.class);
			 configuration.addAnnotatedClass(Person.class);
			 configuration.addAnnotatedClass(Guide.class);
			 configuration.addAnnotatedClass(Student.class);
			 configuration.addAnnotatedClass(Passport.class);
			 configuration.addAnnotatedClass(Customer.class);
			 configuration.addAnnotatedClass(Actor.class);
			 configuration.addAnnotatedClass(Movie.class);
			 configuration.addAnnotatedClass(Employee.class);
			 configuration.addAnnotatedClass(Friend.class);
			 configuration.addAnnotatedClass(Parent.class);
			
			return configuration.buildSessionFactory(
					new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
		} catch (Exception e) {
			throw new ExceptionInInitializerError("Session factory init failed " + e.toString());
		}

	}

	/**
	 * 
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
