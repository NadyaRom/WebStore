package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.entity.Type;

public interface TypeService {
	
	void save (String name);
	
	void save (Type type);

	Type findById(int id);

	void update(int id, String name);

	void deleteById(int id);
	
	List<Type> getAll();

	Type findByName(String name);

	Page<Type> findAll(Pageable pageable, BasicFilter filter);
	

}
