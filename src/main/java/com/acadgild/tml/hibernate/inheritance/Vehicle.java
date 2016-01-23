package com.acadgild.tml.hibernate.inheritance;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="Type", discriminatorType=DiscriminatorType.STRING)
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private String license;
	
	public Vehicle(){
		
	}
	
	public Vehicle(int id, String name, String license) {
		super();
		this.id = id;
		this.name = name;
		this.license = license;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + ", license=" + license
				+ "]";
	}
	
	
	
	
}
