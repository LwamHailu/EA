package com.edu.exercise05;

import java.util.ArrayList;
import java.util.List;

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
            
			
		Product product= new Product();
		product.setName("Book");
		product.setDescription("having many awards");
		OrderLine orderLine1=new OrderLine();
		orderLine1.setProduct(product);
		orderLine1.setQuantity(4);
		OrderLine orderLine2=new OrderLine();
		orderLine2.setProduct(product);
		orderLine2.setQuantity(9);
		List<OrderLine>orderLines= new ArrayList<OrderLine>();
		orderLines.add(orderLine2);
		orderLines.add(orderLine1);
		Customer customer= new Customer();
		customer.setFirstName("Leam");
		customer.setLastNmae("hailu");
	
	       Order order1= new Order();
	       order1.setOrderLine(orderLines);
	       order1.setCustomer(customer);
	       Order order2= new Order();
	       order1.setOrderLine(orderLines);
	       order1.setCustomer(customer);
	   	List<Order>orders= new ArrayList<Order>();
	   	orders.add(order1);
	   	orders.add(order2);
		customer.setOrder(orders);
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
