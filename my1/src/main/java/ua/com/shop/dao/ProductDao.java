package ua.com.shop.dao;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;

import org.dom4j.swing.LeafTreeNode;
import org.hibernate.annotations.Where;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.orm.hibernate3.FilterDefinitionFactoryBean;

import ua.com.shop.dto.filter.ProductFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Orders;
import ua.com.shop.entity.Producer;
import ua.com.shop.entity.Product;
import ua.com.shop.spec.ProductSpec;

public interface ProductDao extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product>{
	
	@Query("SELECT p FROM Product p WHERE p.category.id = ?1")
	List<Product> findByCategoryId(int id);
	
	@Query("SELECT p FROM Product p JOIN FETCH p.color JOIN FETCH  p.material JOIN FETCH p.design JOIN FETCH p.producer JOIN FETCH p.category JOIN FETCH p.type JOIN FETCH p.phoneCompatibility")
	List<Product> findAll();
	
	@Query("SELECT p FROM Product p JOIN FETCH p.color JOIN FETCH  p.material JOIN FETCH p.design JOIN FETCH p.producer JOIN FETCH p.category JOIN FETCH p.type JOIN FETCH p.phoneCompatibility WHERE p.category.id = ?1")
	List<Product> findAllbyCategoryId(int id);
	
	@Query("SELECT p FROM Product p JOIN FETCH p.color JOIN FETCH  p.material JOIN FETCH p.design JOIN FETCH p.producer JOIN FETCH p.category  JOIN FETCH p.type JOIN FETCH p.phoneCompatibility WHERE p.id = ?1")
	Product findAllbyId(int id);
	
	Product findByName(String name);
	
	@Query(value="SELECT p FROM Product p LEFT JOIN FETCH p.category LEFT JOIN FETCH p.type LEFT JOIN FETCH p.color LEFT JOIN FETCH p.design LEFT JOIN FETCH p.material LEFT JOIN FETCH p.phoneCompatibility LEFT JOIN FETCH p.producer",
			countQuery="SELECT count(p.id) FROM Product p")
	Page<Product> findAll(Pageable pageable);
	
	
}


