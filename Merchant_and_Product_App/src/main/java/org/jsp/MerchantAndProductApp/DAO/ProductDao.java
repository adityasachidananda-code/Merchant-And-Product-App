package org.jsp.MerchantAndProductApp.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.MerchantAndProductApp.DTO.Merchant;
import org.jsp.MerchantAndProductApp.DTO.Product;

public class ProductDao
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vision");
	EntityManager em = emf.createEntityManager();
	
	public Product addProduct(int mid, Product p) 
	{
		EntityTransaction etran = em.getTransaction();
		etran.begin();
		Merchant mdb = em.find(Merchant.class, mid);
		if(mdb!=null)
		{
			p.setMer(mdb);
			mdb.getProd().add(p);
			em.persist(p);
			etran.commit();
			return p;
		}
		else
		{
			return null;
		}
	}

	public Product updateProduct(Product p) 
	{
		EntityTransaction etran = em.getTransaction();
		etran.begin();
		Product pdb = em.find(Product.class, p.getId());
		if(pdb!=null)
		{
			pdb.setName(p.getName());
			pdb.setBrand(p.getBrand());
			pdb.setCategory(p.getCategory());
			pdb.setPrice(p.getPrice());
			etran.commit();
			return pdb;
		}
		else
		{
			return null;
		}
	}

	public Product findProductById(int pid) 
	{
		return em.find(Product.class, pid);
	}

	public Product findProductByBrandAndCategory(String b, String cat) {
		Query q = em.createQuery("select p from Product p where p.brand=?1 and p.category=?2" );
		q.setParameter(1, b);
		q.setParameter(2, cat);
		try
		{
			Product pdao = (Product)q.getSingleResult();
			return pdao;
		}
		catch(NoResultException e)
		{
			return null;
		}
	}

	public List<Product> findProductByMerchantId(int mid) 
	{
		Query q = em.createQuery("select m.prod from Merchant m where m.id=?1");
		q.setParameter(1, mid);
		List<Product> plist = q.getResultList();
		return plist;
	}	
}
