package com.acadgild.tml.hibernate.manytomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEM_MN")
public class ItemMN {
 
    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
     
    @Column(name="item_price")
    private double price;
     
    @Column(name="item_desc")
    private String description;

	public ItemMN() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemMN(long id, double price, String description) {
		super();
		this.id = id;
		this.price = price;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}