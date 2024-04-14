package com.demo.restapi.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "product")
public class Category {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private  int id ;
	@Column(name = "product_name")
	private String product_name;
	@Column(name = "product_price")
	private Double price;
	@Column(name = "product_mfg")
	private Date mfg_date;
	@Column(name ="product_type")
	private String product_type; 
	
	
	public Category() {
		
	}
	


	public Category(String product_name, Double price, Date mfg_date, String product_type) {
		super();
		this.product_name = product_name;
		this.price = price;
		this.mfg_date = mfg_date;
		this.product_type = product_type;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Date getMfg_date() {
		return mfg_date;
	}


	public void setMfg_date(Date mfg_date) {
		this.mfg_date = mfg_date;
	}


	public String getProduct_type() {
		return product_type;
	}


	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	
	@Override  
	public String toString() {
		return "Category [id=" + id + ", product_name=" + product_name + ", price=" + price + ", mfg_date=" + mfg_date
				+ ", product_type=" + product_type + "]";
	}

}
