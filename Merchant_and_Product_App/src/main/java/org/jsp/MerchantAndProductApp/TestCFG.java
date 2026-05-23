package org.jsp.MerchantAndProductApp;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestCFG
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vision");
		System.out.println(emf);
	}
}
