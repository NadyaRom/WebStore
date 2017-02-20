package ua.com.shop.entity;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int quantity;
		
	private Calendar date;

	@OneToMany(mappedBy="orders")
	private List<Product> products;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
//	public double getPrice(){
//		double priceofOne = 0;
//		Iterator< Product> iterator= products.iterator();
//		while(iterator.hasNext()){
//			Product product = iterator.next();
//			priceofOne = priceofOne + product.getPrice();
//		}
//		return priceofOne;
//	}
	
	
	
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}

	

	public Orders(int id, int quantity) {
	super();
	this.id = id;
	this.quantity = quantity;
}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Calendar getDate() {
		return date;
	}



	public void setDate(Calendar date) {
		this.date = date;
	}



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
}
