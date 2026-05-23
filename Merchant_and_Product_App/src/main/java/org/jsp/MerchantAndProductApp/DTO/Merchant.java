package org.jsp.MerchantAndProductApp.DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Merchant
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String gst_num;
	private long phone;
	private String password;
	@OneToMany(mappedBy = "mer")
	private List<Product> prod;

	public int getId()
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getGst_num() 
	{
		return gst_num;
	}

	public void setGst_num(String gst_num) 
	{
		this.gst_num = gst_num;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public List<Product> getProd() 
	{
		return prod;
	}

	public void setProd(List<Product> prod) 
	{
		this.prod = prod;
	}

	@Override
	public String toString()
	{
		return "Merchant [id=" + id + ", name=" + name + ", email=" + email + ", gst_num=" + gst_num + ", phone="
				+ phone + ", password=" + password + "]";
	}	
}
