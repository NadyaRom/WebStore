package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

	@Query("SELECT c FROM Category c JOIN FETCH c.products")
	List<Category> findProducts();
}
