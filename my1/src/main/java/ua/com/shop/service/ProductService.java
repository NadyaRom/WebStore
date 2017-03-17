package ua.com.shop.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.dto.filter.ProductFilter;
import ua.com.shop.dto.form.ProductForm;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Product;

public interface ProductService {


	Product findById(int id);

	void update(Product item);

	void deleteById(int id);
	
	List<Product> getAll();
	
	List<Product> findAll();

	List<Product> findByCategoryId(int id);
	
	List<Product> findAllbyCategoryId(int id);
	
	Product findAllbyId(int id);

	Product findByName(String name);

	Page<Product> findAll(Pageable pageable, ProductFilter filter);

	void save(ProductForm product);

	ProductForm findForm(Integer id);


}
