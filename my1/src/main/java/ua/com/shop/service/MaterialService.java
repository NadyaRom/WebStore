package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.entity.Material;

public interface MaterialService{
	void save (String name);
	
	void save (Material material);

	Material findById(int id);

	void update(int id, String name);

	void deleteById(int id);
	
	List<Material> getAll();

	Material findByName(String name);

	Page<Material> findAll(Pageable pageable, BasicFilter filter);
}
