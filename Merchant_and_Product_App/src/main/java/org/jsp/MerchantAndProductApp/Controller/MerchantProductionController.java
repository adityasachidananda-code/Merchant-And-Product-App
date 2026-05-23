package org.jsp.MerchantAndProductApp.Controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.MerchantAndProductApp.DAO.MerchantDao;
import org.jsp.MerchantAndProductApp.DAO.ProductDao;
import org.jsp.MerchantAndProductApp.DTO.Merchant;
import org.jsp.MerchantAndProductApp.DTO.Product;

public class MerchantProductionController
{
	static Scanner sc = new Scanner(System.in);
	static MerchantDao mdao = new MerchantDao();
	static ProductDao pdao = new ProductDao();
	
	public static void main(String[] args) 
	{
		System.out.println("1. Save Merchant");
		System.out.println("2. Update Merchant");
		System.out.println("3. Find Merchant By ID");
		System.out.println("4. Verify Merchant by email and password");
		System.out.println("5. Verify Merchant by phone and password");
		System.out.println();
		System.out.println("6. Add Product");
		System.out.println("7. Update Product");
		System.out.println("8. Find Products by ID");
		System.out.println("9. Find Products by Brand and Category");
		System.out.println("10. Find Products by Merchant ID");
		
		System.out.println("Enter your Choice");
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1:saveMerchant();
		break;
		
		case 2:updateMerchant();
		break;
		
		case 3:findMerchantById();
		break;
		
		case 4:verifyMerchantByEmailAndPassword();
		break;
		
		case 5:verifyMerchantByPhoneAndPassword();
		break;
		
		case 6:addProduct();
		break;
		
		case 7:updateProduct();
		break;
		
		case 8:findProductById();
		break;
		
		case 9:findProductByBrandAndCategory();
		break;
		
		case 10:findProductByMerchantId();
		break;
		
		default:System.err.println("The Number is greater than 10 for which choice is invalid");
		break;
		}
	}

	private static void findProductByMerchantId() 
	{
		System.out.println("Enter Merchant ID to find Product Details");
		int mid = sc.nextInt();
		List<Product> lpdb = pdao.findProductByMerchantId(mid);
		if(lpdb.size()>0)
		{
			lpdb.forEach(p->System.out.println(p));
		}
		else
		{
			System.err.println("Unable to find Product Details based on Merchant ID or ID is invalid");
		}
	}

	private static void findProductByBrandAndCategory()
	{
		System.out.println("Enter Product Brand : ");
		String b = sc.next();
		System.out.println("Enter Product Category : ");
		String cat = sc.next();
		Product pdb = pdao.findProductByBrandAndCategory(b,cat);
		if(pdb!=null)
		{
			System.out.println(pdb);
		}
		else
		{
			System.err.println("Unable to find Product Based on this Brand and Category");
		}
	}

	private static void findProductById() 
	{
		System.out.println("Enter Merchant id to find Merchant");
		int pid = sc.nextInt();
		Product pdb = pdao.findProductById(pid);
		if(pdb!=null)
		{
			System.out.println(pdb);
		}
		else
		{
			System.err.println("Unable to find Product based on this id");
		}
	}

	private static void updateProduct() 
	{
		System.out.println("Enter the Product Info---id,name,brand,category,cost");
		Product p = new Product();
		p.setId(sc.nextInt());
		p.setName(sc.next());
		p.setBrand(sc.next());
		p.setCategory(sc.next());
		p.setPrice(sc.nextDouble());
		Product pdb=pdao.updateProduct(p);
	}

	private static void addProduct() 
	{
		
		System.out.println("Enter Merchant ID to add the Product");
		int mid = sc.nextInt();
		System.out.println("Enter the product info---name , brand , category , cost");
		Product p = new Product();
		p.setName(sc.next());
		p.setBrand(sc.next());
		p.setCategory(sc.next());
		p.setPrice(sc.nextDouble());
		
		Product pdb = pdao.addProduct(mid,p);
		
		if(pdb!=null)
		{
			System.out.println("Product Added Sucessfully");
		}
		else 
		{
			System.err.println("Merchant Not Found !");
		}
	}

	private static void verifyMerchantByPhoneAndPassword() 
	{
		System.out.println("Enter Phone Number : ");
		long ph = sc.nextLong();
		System.out.println("Enter Password : ");
		String psd = sc.next();
		Merchant mdb = mdao.verifyMerchantByPhoneAndPassword(ph,psd);
		if(mdb!=null)
		{
			System.out.println(mdb);
		}
		else
		{
			System.err.println("Unable to find Merchant on this Phone and Password");
		}
	}

	private static void verifyMerchantByEmailAndPassword() 
	{
		System.out.println("Enter Email : ");
		String em = sc.next();
		System.out.println("Enter Password : ");
		String psd = sc.next();
		Merchant mdb = mdao.verifyMerchantByEmailAndPassword(em , psd);
		if(mdb!=null)
		{
			System.out.println(mdb);
		}
		else
		{
			System.err.println("Unable to find Merchant on this Email and Password");
		}
	}

	private static void findMerchantById() 
	{
		System.out.println("Enter Merchant id to find Merchant");
		int mid = sc.nextInt();
		Merchant mdb = mdao.findMerchantById(mid);
		if(mdb!=null)
		{
			System.out.println(mdb);
		}
		else
		{
			System.err.println("Unable to find Merchant based on this id");
		}
	}

	private static void updateMerchant()
	{
		System.out.println("Enter Merchant info---name,phone,gstno,email,password");
		Merchant m = new Merchant();
		m.setId(sc.nextInt());
		m.setPhone(sc.nextLong());
		m.setName(sc.next());
		m.setGst_num(sc.next());
		m.setEmail(sc.next());
		m.setPassword(sc.next());
		
		Merchant mdb = mdao.updateMerchant(m);
		if(mdb!=null)
		{
			System.out.println("Merchant is updated : "+mdb);
		}
		else
		{
			System.err.println("Unable to update the merchant since id is invalid");
		}
	}

	private static void saveMerchant() 
	{
		System.out.println("Enter Merchant info---name,phone,gstno,email,password");
		String name = sc.next();
		long ph = sc.nextLong();
		String gst = sc.next();
		String em = sc.next();
		String pw = sc.next();
		
		Merchant m = new Merchant();
		
		m.setName(name);
		m.setPhone(ph);
		m.setGst_num(gst);
		m.setEmail(em);
		m.setPassword(pw);
		
		Merchant mdb = mdao.saveMerchant(m);
		System.out.println("Merchant is saved with an id :"+mdb.getId());
	}
}
