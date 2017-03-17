package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.entity.Producer;

public interface ProducerService {
	
	void save(String name);
	
	void save (Producer producer);

	Producer findById(int id);

	void update(int id, String name);
	
	void deleteById(int id);
	
	List<Producer> getAll();
	
	List<Producer> fetchProducerWithProducts(String name);

	Producer findByName(String name);

	Page<Producer> findAll(Pageable pageable, BasicFilter filter);
	
}
