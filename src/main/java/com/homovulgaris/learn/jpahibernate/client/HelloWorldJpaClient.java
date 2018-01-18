package com.homovulgaris.learn.jpahibernate.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.homovulgaris.learn.jpahibernate.entity.Message;



public class HelloWorldJpaClient {

	
	private static final Logger logger = Logger.getLogger(HelloWorldJpaClient.class);
	
	public static void main(String [] args) {
		saveMessage();
	}
	
	private static EntityManager obtainEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager entityManager = emf.createEntityManager();
		
		return entityManager;
	}
	
	public static Message saveMessage() {
		EntityManager entityManager = obtainEntityManager(); 
		EntityTransaction etsn = entityManager.getTransaction();
		Message theMessage = null;
		try {
			etsn.begin();
			theMessage = new Message("Creating some message with Hibernate as JPA provider");
			entityManager.persist(theMessage);
			etsn.commit();
			logger.info("The message should be saved " + theMessage);
		} catch (Exception e) {
			if(etsn!= null) {
				etsn.rollback();
				logger.error("Some error ocured " + e);
			}
		}finally {
			if(entityManager != null) {
				entityManager.close();
			}
		}
		return theMessage;
	}
	
	

}
