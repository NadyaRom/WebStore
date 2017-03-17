package ua.com.shop.dto.form;

import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.entity.Category;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.Design;
import ua.com.shop.entity.Material;
import ua.com.shop.entity.Orders;
import ua.com.shop.entity.PhoneCompatibility;
import ua.com.shop.entity.Producer;
import ua.com.shop.entity.Type;

public class ProductForm {
	
	private int id;
	
	private String name;
	
	private String price;
	
	private Type type;
	
	private Design design;
	
	private Color color;
	
	private Material material;
	
	private PhoneCompatibility phoneCompatibility;
	
	private Producer producer;
	
	private Category category;
	
	private Orders orders;
	
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
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

	
	
	

}
