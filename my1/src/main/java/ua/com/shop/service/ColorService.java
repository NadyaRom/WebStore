package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.entity.Color;

public interface ColorService {
	
	void save (String name);
	
	void save (Color color);

	Color findById(int id);

	void update(int id, String name);

	void deleteById(int id);
	
	List<Color> getAll();

	Color findByName(String name);

	Page<Color> findAll(Pageable pageable, BasicFilter filter);

}
