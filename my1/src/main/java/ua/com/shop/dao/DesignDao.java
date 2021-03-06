package ua.com.shop.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.Color;
import ua.com.shop.entity.Design;
import ua.com.shop.spec.DesignSpec;

public interface DesignDao extends JpaRepository<Design, Integer>, JpaSpecificationExecutor<Design>{
	
	Design findByName(String name);


}
