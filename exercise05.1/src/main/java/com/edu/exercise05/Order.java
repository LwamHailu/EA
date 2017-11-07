package com.edu.exercise05;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Order_Table")

public class Order {
	@Id @GeneratedValue
	private int id;
	private String date;
	@ManyToOne
	@JoinColumn
	private Customer customer;
	@OneToMany
	@JoinColumn
	private List<OrderLine>orderLine= new ArrayList<OrderLine>();
	public Order() {}
	public Order(String date, Customer customer, List<OrderLine> orderLine) {
		super();
		this.date = date;
		this.customer = customer;
		this.orderLine = orderLine;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<OrderLine> getOrderLine() {
		return orderLine;
	}
	public void setOrderLine(List<OrderLine> orderLine) {
		this.orderLine = orderLine;
	}
		
	
}
