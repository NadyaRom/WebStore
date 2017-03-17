package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.entity.Design;;

public interface DesignService {

	void save (String name);
	
	void save (Design design);

	Design findById(int id);

	void update(int id, String name);

	void deleteById(int id);
	
	List<Design> getAll();

	Design findByName(String name);

	Page<Design> findAll(Pageable pageable, BasicFilter filter);
}
