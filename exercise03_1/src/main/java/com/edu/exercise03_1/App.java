package com.edu.exercise03_1;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;





/**
 * Hello world!
 *
 */
public class App 
{
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Session session = null;
		Transaction tx = null;
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Owner owner1= new Owner("Lwam Hailu","Oaklnad ,CA");
			Owner owner2= new Owner("lulu tekle","fairfield ,IA");
			Car car1= new Car("Honda",2000,30.21,owner1);
			Car car2= new Car("Ford",2009,13.21,owner1);
			Car car3= new Car("MVN",2015,40.0,owner2);
			session.persist(car1);
			session.persist(car2);
			session.persist(car3);
		
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				System.err.println("Rolling back: " + e.getMessage());
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}


    }
}


