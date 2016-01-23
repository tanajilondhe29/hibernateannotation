package com.acadgild.tml.hibernate.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CART_MN")
public class CartMN {
 
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 
    @Column(name = "cart_total")
    private double total;
 
    @ManyToMany(targetEntity = ItemMN.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "CART_ITEMS", 
                joinColumns = { @JoinColumn(name = "cart_id") }, 
                inverseJoinColumns = { @JoinColumn(name = "item_id") })
    private Set<ItemMN> items;

	public CartMN() {
		// TODO Auto-generated constructor stub
	}
	
	public CartMN(long id, double total, Set<ItemMN> items) {
		super();
		this.id = id;
		this.total = total;
		this.items = items;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Set<ItemMN> getItems() {
		return items;
	}

	public void setItems(Set<ItemMN> items) {
		this.items = items;
	}
	
	
 
    
}
