package ua.com.shop.entity;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name = "version", nullable = true)
	private Integer version;
	
	private BigDecimal price;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Type type;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Design design;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Color color;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Material material;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private PhoneCompatibility phoneCompatibility;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Producer producer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Category category;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Orders orders;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public Product(String name, BigDecimal price, Type type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}




	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
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


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public Design getDesign() {
		return design;
	}


	public void setDesign(Design design) {
		this.design = design;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public Material getMaterial() {
		return material;
	}


	public void setMaterial(Material material) {
		this.material = material;
	}


	public PhoneCompatibility getPhoneCompatibility() {
		return phoneCompatibility;
	}


	public void setPhoneCompatibility(PhoneCompatibility phoneCompatibility) {
		this.phoneCompatibility = phoneCompatibility;
	}


	public Producer getProducer() {
		return producer;
	}


	public void setProducer(Producer producer) {
		this.producer = producer;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Orders getOrders() {
		return orders;
	}


	public void setOrders(Orders orders) {
		this.orders = orders;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + "]";
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
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	



}
