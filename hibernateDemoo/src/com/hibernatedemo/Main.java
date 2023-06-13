package com.hibernatedemo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory =new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(City.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			  /*List<String>countryCodes =session.
			  createQuery("select c.countryCode from City c GROUP BY c.countryCode ").
			  getResultList();
			  
			  for(String countryCode:countryCodes) { System.out.println(countryCode); }*/
			  
			 
			/*
			 * //INSERT KOD 
			 * City city = new City(); city.setName("Adana");
			 * city.setCountryCode("TUR"); city.setDistrict("AKD");
			 * city.setPopulation(2500);
			 * 
			 * session.save(city);
			 */
			
			//UPDATE
			 // City city = session.get(City.class, 4171);
			 // city.setPopulation(50000);
			  
			 // session.save(city);
			
			 // DELETE
			City city = session.get(City.class, 4171);
			session.delete(city);
			
			
			
			session.getTransaction().commit();
			System.out.println("Şehir eklendi:");
		} 
		finally {
			factory.close();
			
		}

	}

}
