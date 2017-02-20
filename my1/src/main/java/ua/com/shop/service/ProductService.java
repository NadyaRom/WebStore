package ua.com.shop.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Category;
import ua.com.shop.entity.Product;

public interface ProductService {
	void save(Product product);

	Product findById(int id);

	void update(Product item);

	void deleteById(int id);
	
	List<Product> getAll();

	void save(String name, double price, int categoryId, int producerId, int coloroId, int designId, int materialId, int typeId, int psId);
	
	List<Product> findAll();

	List<Product> findByCategoryId(int id);
	
	List<Product> findAllbyCategoryId(int id);
	
	Product findAllbyId(int id);
	
}
