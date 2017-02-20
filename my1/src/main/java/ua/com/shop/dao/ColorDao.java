package ua.com.shop.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Color;

public interface ColorDao extends JpaRepository<Color, Integer> {
	

}