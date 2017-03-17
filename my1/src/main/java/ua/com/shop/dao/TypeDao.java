package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.Color;
import ua.com.shop.entity.Type;

public interface TypeDao extends JpaRepository<Type, Integer>, JpaSpecificationExecutor<Type> {
	
	Type findByName(String name);
}
