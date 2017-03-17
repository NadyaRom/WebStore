package ua.com.shop.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.Category;
import ua.com.shop.entity.Color;
import ua.com.shop.spec.ColorSpec;

public interface ColorDao extends JpaRepository<Color, Integer>, JpaSpecificationExecutor<Color> {
	
	Color findByName(String name);

	
	

}