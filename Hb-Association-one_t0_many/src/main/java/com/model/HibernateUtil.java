package com.model;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sf;
	private static StandardServiceRegistry sr;
    
	public static SessionFactory getSessionFactory() {	
		if(sf==null) {
			try {
				
			sr=new StandardServiceRegistryBuilder().configure("hiberntae.cfg.xml").build();
			Metadata md=new MetadataSources(sr).buildMetadata();
			sf=md.buildSessionFactory();
			
		}
		catch(HibernateException h) {
			
			h.printStackTrace();
			
		   }
	   }
		return sf;
	
	}
}
