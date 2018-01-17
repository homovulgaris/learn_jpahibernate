package com.homovulgaris.learn.jpahibernate.client;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.homovulgaris.learn.jpahibernate.entity.Adress;
import com.homovulgaris.learn.jpahibernate.entity.Message;
import com.homovulgaris.learn.jpahibernate.entity.Person;
import com.homovulgaris.learn.jpahibernate.util.HibernateUtil;

public class HelloWorldClient {

	private static final Logger logger = Logger.getLogger(HelloWorldClient.class);

	public static void main(String[] args) {

//		obtainMessage(1L);
//		updateMessage(1L, "Wanna some update");
//		dirtyUpdateMessage(2L, "Wanna some dirty update");
//		for(long i = 3; i<=10;i++) {
//			deleteMessage(new Long(i));
//		}
		
		createPerson("Jozef Marcin", "Bardejov", "17", "Lesna");
	}

	private static Session obtainSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}

	public static Message obtainMessage(final Long number) {
		Message msg = null;
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		try {
			tsc.begin();
			msg = session.get(Message.class, number);
			tsc.commit();
			logger.info("The retrieved message is: " + msg);
		} catch (Exception e) {

			logger.error("something happend wrong ");
			if (tsc != null) {
				tsc.rollback();
			}

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}
	
	public static Message deleteMessage(final Long number) {
		Message msg = null;
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();
		logger.info("Trying to delete message with number " + number);
		try {
			tsc.begin();
			msg = session.get(Message.class, number);
			session.delete(msg);
			tsc.commit();
			logger.info("The deleted message is: " + msg);
		} catch (Exception e) {

			logger.error("something happend wrong ");
			if (tsc != null) {
				tsc.rollback();
			}

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}
	public static Message dirtyUpdateMessage(final Long number, final String theTextToUpdate) {
		Message msg = null;
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		try {
			tsc.begin();
			msg = session.get(Message.class, number);
			msg.setText(theTextToUpdate);
			tsc.commit();
			logger.info("The retrieved message is: " + msg);
		} catch (Exception e) {

			logger.error("something happend wrong ");
			if (tsc != null) {
				tsc.rollback();
			}

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}
	
	public static Message updateMessage(final Long number, final String theTextToUpdate) {
		Message msg = null;
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		try {
			tsc.begin();
			msg = session.get(Message.class, number);
			msg.setText(theTextToUpdate);
			session.save(msg);
			tsc.commit();
			logger.info("The retrieved message is: " + msg);
		} catch (Exception e) {

			logger.error("something happend wrong ");
			if (tsc != null) {
				tsc.rollback();
			}

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}
	
	public static Message createPerson(final String name, final String city, final String code, final String street) {
		Message msg = null;
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		Adress adress = new Adress(street, city, code);
		Person person = new Person(name, adress);
		
		logger.info("The Person " +person);
		try {
			tsc.begin();
			session.save(person);
			tsc.commit();
			logger.info("Saved person is " + person);
		} catch (Exception e) {

			logger.error("something happend wrong " + e);
			if (tsc != null) {
				tsc.rollback();
			}

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}
}
