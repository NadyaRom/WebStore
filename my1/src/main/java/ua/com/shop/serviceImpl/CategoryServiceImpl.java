package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.CategoryDao;
import ua.com.shop.entity.Category;
import ua.com.shop.service.CategoryService;

@Service
public class CategoryServiceImpl  implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;

	public void save(String name) {
		Category category = new Category();
		category.setName(name);
		categoryDao.save(category);
	}

	public Category findById(int id) {
		return  categoryDao.findOne(id);
	}

	public void update(int id, String name) {
		categoryDao.findOne(id).setName(name);	
	}

	public void deleteById(int id) {
		categoryDao.delete(id);
		
	}

	public List<Category> getAll() {
		return categoryDao.findAll();
	}

	public List<Category> findProducts() {
		return categoryDao.findProducts();
	}

	public void save(Category category) {
		categoryDao.save(category);
		
	}
	
	

}
