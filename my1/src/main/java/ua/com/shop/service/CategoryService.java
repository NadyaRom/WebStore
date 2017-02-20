package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Category;

public interface CategoryService {
	void save (String name);
	
	void save (Category category);

	Category findById(int id);

	void update(int id, String name);

	void deleteById(int id);
	
	List<Category> getAll();
	
	List<Category> findProducts();

}
