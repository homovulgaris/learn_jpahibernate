package com.homovulgaris.learn.jpahibernate.client;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.homovulgaris.learn.jpahibernate.entity.Actor;
import com.homovulgaris.learn.jpahibernate.entity.Adress;
import com.homovulgaris.learn.jpahibernate.entity.Customer;
import com.homovulgaris.learn.jpahibernate.entity.Employee;
import com.homovulgaris.learn.jpahibernate.entity.Friend;
import com.homovulgaris.learn.jpahibernate.entity.Guide;
import com.homovulgaris.learn.jpahibernate.entity.Message;
import com.homovulgaris.learn.jpahibernate.entity.Movie;
import com.homovulgaris.learn.jpahibernate.entity.Parent;
import com.homovulgaris.learn.jpahibernate.entity.ParentCompositeKey;
import com.homovulgaris.learn.jpahibernate.entity.Passport;
import com.homovulgaris.learn.jpahibernate.entity.Person;
import com.homovulgaris.learn.jpahibernate.entity.Student;
import com.homovulgaris.learn.jpahibernate.enumerations.EmployeeStatus;
import com.homovulgaris.learn.jpahibernate.util.HibernateUtil;

public class HelloWorldClient {

	private static final Logger logger = Logger.getLogger(HelloWorldClient.class);

	public static void main(String[] args) {

		// obtainMessage(1L);
		// updateMessage(1L, "Wanna some update");
		// dirtyUpdateMessage(2L, "Wanna some dirty update");
		// for(long i = 3; i<=10;i++) {
		// deleteMessage(new Long(i));
		// }

		// createPerson("Jozef Marcin", "Bardejov", "17", "Lesna");
		obtainPerson(1L);
		// Guide theGuide = createGuide("P3502823", 2380L, "Thomas House");
		// persistTransitiveStudentAndGuide("Enrolment22", "Hibernate Student",
		// theGuide);
		// createStudent("APCop4455", "Tamara Hellbuck", theGuide);
		// deleteStudent(2L);
		// tryManyToOne();
		// updateUnsatisfiedBecouseOfUpdatingInverseEnd();
		// updateSatisfiedByUpdatingInverseEnd();
		// getAllGuidesWithStudents();
		// createMovieActorNtoN();
		// updateMovieActorNtoN();
		//saveEmployee();
		//saveFriend();
		//obtainFriend();
		saveWithCompositePrimaryKey();
	}

	private static void obtainFriend() {
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		try {
			tsc.begin();
			
			Friend friend = session.get(Friend.class, 1L);
			
			tsc.commit();
			logger.info("The Friend has been retrieved " + friend);
			

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

	public static Person obtainPerson(final Long number) {
		Person person = null;
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		try {
			tsc.begin();
			person = session.get(Person.class, number);
			tsc.commit();
			logger.info("The retrieved Person is: " + person);
			logger.info("Addres is: " + person.getAdress());
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

		return person;
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

		logger.info("The Person " + person);
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

	public static Student createStudent(final String enrollmentId, final String studentName, final Guide aGuide) {

		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		Student theStudent = new Student(enrollmentId, studentName, aGuide);

		logger.info("The Student " + theStudent);
		try {
			tsc.begin();
			session.save(theStudent);
			tsc.commit();
			logger.info("Saved student is " + theStudent);
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

		return theStudent;
	}

	public static Guide createGuide(final String staffId, final Long salary, final String name) {
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		Guide guide = new Guide(staffId, salary, name);

		logger.info("The Student " + guide);
		try {
			tsc.begin();
			session.save(guide);
			tsc.commit();
			logger.info("Saved student is " + guide);
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

		return guide;
	}

	public static void persistTransitiveStudentAndGuide(final String enrollmentId, final String studentName,
			final Guide aGuide) {
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		Student theStudent = new Student(enrollmentId, studentName, aGuide);

		logger.info("The Student " + theStudent);
		try {
			tsc.begin();
			session.persist(theStudent);
			tsc.commit();
			logger.info("Saved student is " + theStudent);
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
	}

	public static void deleteStudent(final Long id) {
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		logger.info("The Id of deleting student is " + id);
		try {
			tsc.begin();
			Student theStudent = session.get(Student.class, id);
			session.delete(theStudent);
			tsc.commit();
			logger.info("Deleted student is " + theStudent);
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
	}

	public static void tryManyToOne() {
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		try {
			tsc.begin();
			Guide guide1 = new Guide("Staff1234", 3500L, "Marius Thefirst");
			Guide guide2 = new Guide("Staff2234", 3502L, "Euridikus Thesecond");

			Student student1 = new Student("Enrolment1", "Responsible Student", guide1);
			Student student2 = new Student("Enrolment2", "Unresponsible Student", guide1);

			guide1.getStudents().add(student1);
			guide1.getStudents().add(student2);

			session.persist(guide1);
			session.persist(guide2);

			tsc.commit();
			logger.info("Saved guide is student is " + guide1);
			logger.info("Saved guide is student is " + guide2);
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
	}

	public static void updateUnsatisfiedBecouseOfUpdatingInverseEnd() {
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		try {
			tsc.begin();

			Guide guide2 = session.get(Guide.class, 2L);
			Student student2 = session.get(Student.class, 2L);

			guide2.getStudents().add(student2);

			/*
			 * This wont change the student2 relationship, because of inverse end updating,
			 * which means, that guide table is not owner of relationship and does not care
			 * about relations.
			 */
			session.save(guide2);

			tsc.commit();

			logger.info("Saved guide is student is " + guide2);
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
	}

	public static void updateSatisfiedByUpdatingInverseEnd() {
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		try {
			tsc.begin();

			Guide guide2 = session.get(Guide.class, 2L);
			Student student2 = session.get(Student.class, 2L);

			guide2.addStudent(student2);

			session.save(guide2);

			tsc.commit();

			logger.info("Saved guide is student is " + guide2);
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
	}

	@SuppressWarnings("deprecation")
	public static void getAllGuidesWithStudents() {
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		try {
			tsc.begin();

			List<Guide> theGuides = session.createQuery("SELECT E from Guide E").getResultList();
			tsc.commit();

			logger.info("The Guides " + theGuides.get(0).getStudents());

			// theGuides.stream().forEach(guide -> logger.info("The hello.guide is: " +
			// guide));

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
	}

	public static void persistCustomerWithPassport() {
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		try {
			tsc.begin();

			Passport thePassport = new Passport(1244578L);
			Customer theCustomer = new Customer("ANDIAMO CAMO", thePassport);

			session.persist(theCustomer);

			tsc.commit();
			logger.info("The Customer has been saved " + theCustomer);

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

	}

	public static void createMovieActorNtoN() {
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		try {
			tsc.begin();

			Actor actor1 = new Actor("Marian Gajsberk");
			Actor actor2 = new Actor("Roman Bombos");

			Movie movie1 = new Movie("Neodkladny osud");
			Movie movie2 = new Movie("Zelenina je zdrava");

			movie1.getActors().add(actor1);
			movie1.getActors().add(actor2);
			movie2.getActors().add(actor1);

			session.persist(movie1);
			session.persist(movie2);

			tsc.commit();
			logger.info("The Movie has been saved " + movie1);
			logger.info("The Movie has been saved " + movie2);

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

	}

	public static void updateMovieActorNtoN() {
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		try {
			tsc.begin();

			Actor actor1 = session.get(Actor.class, 1L);

			Movie movie1 = session.get(Movie.class, 1L);

			logger.info("The Movie before edit " + movie1);

			movie1.getActors().remove(actor1);
			session.save(movie1);

			tsc.commit();
			logger.info("The Movie has been edited " + movie1);

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

	}

	public static void saveEmployee() {
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		try {
			tsc.begin();
			Employee employee = new Employee("Marian Olej", "44558AA445A", EmployeeStatus.FULL_TIME);
			session.save(employee);
			tsc.commit();
			logger.info("The Employee has been saved " + employee);

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

	}
	public static void saveFriend() {
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		try {
			tsc.begin();
			Friend friend = new Friend();
			friend.setName("Ezechiel Kaligula");
			friend.setEmail("ezechiel.kaligula@gmail.com");
			friend.getAdresses().add(new Adress("Lesna","Bardejov", "17"));
			friend.getAdresses().add(new Adress("Braniskova","Kosice", "34"));
			
			Friend friend2 = new Friend();
			friend2.setName("Eugen Onegin");
			friend2.setEmail("eugen.onegin@gmail.com");
			friend2.getAdresses().add(new Adress("Braniskova","Kosice", "34"));
			
			session.persist(friend);
			session.persist(friend2);
			tsc.commit();
			logger.info("The Friend has been saved " + friend);
			logger.info("The Friend has been saved " + friend2);

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

	}
	
	public static void saveWithCompositePrimaryKey() {
		Session session = obtainSession();
		Transaction tsc = session.getTransaction();

		try {
			tsc.begin();
			ParentCompositeKey theKey = new ParentCompositeKey("Antoine", "Greizmann");
			Parent theParent = new Parent(theKey);
			session.persist(theParent);
			
			tsc.commit();
			logger.info("The Parent has been saved " + theParent);

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

	}
}
