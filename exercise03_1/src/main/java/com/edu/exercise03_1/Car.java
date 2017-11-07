package com.edu.exercise03_1;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Car {
	@Id @GeneratedValue
	private int id;
	private String brand;
	private int year;
	private double price;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private Owner owner;
	
	
	public Car() {
		
	}
	
	public Car(String brand, int year, double price, Owner owner) {
		super();
		this.brand = brand;
		this.year = year;
		this.price = price;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	

}
