package ca.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	 
    private static final SessionFactory sessionFactory;
 
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure("ca/configs/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static Session getSession(){
    	Session session =null;
    	if(sessionFactory==null){
    		SessionFactory sessionFactoryBis = new Configuration().configure("ca/configs/hibernate.cfg.xml").buildSessionFactory();
        	session = sessionFactoryBis.openSession();
    	}else{
    		session=sessionFactory.openSession();
    	}
    	
    	return session;
    	
    }
 
}
