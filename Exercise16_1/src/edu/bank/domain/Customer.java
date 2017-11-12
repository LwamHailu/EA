package edu.bank.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer_Table")
public class Customer {
	@Id
	@GeneratedValue
	 private int id;
//	@OneToMany(mappedBy="customer", cascade={CascadeType.ALL})
//	Collection<Account> entryList = new ArrayList<Account>();
	private String name;
	public Customer(){
		
	}
	
	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
}
