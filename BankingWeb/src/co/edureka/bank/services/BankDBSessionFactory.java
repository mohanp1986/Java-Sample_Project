package co.edureka.bank.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class BankDBSessionFactory {
	
	
	public static Session getSession() {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()). buildServiceRegistry();
	    
		
		SessionFactory sf=cfg.buildSessionFactory(serviceRegistry);
		Session session=sf.openSession();
		
		return(session);
	}

}
