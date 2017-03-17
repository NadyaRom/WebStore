package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.PhoneCompatibility;


public interface PhoneCompatibilityService {

	void save (String name);
	
	void save (PhoneCompatibility phoneCompatibility);

	PhoneCompatibility findById(int id);

	void update(int id, String name);

	void deleteById(int id);
	
	List<PhoneCompatibility> getAll();

	PhoneCompatibility findByName(String name);

	Page<PhoneCompatibility> findAll(Pageable pageable, BasicFilter filter);
}
