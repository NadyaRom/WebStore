package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.Color;
import ua.com.shop.entity.PhoneCompatibility;

public interface PhoneCompatibilityDao extends JpaRepository<PhoneCompatibility, Integer>, JpaSpecificationExecutor<PhoneCompatibility> {
	
	PhoneCompatibility findByName(String name);
}
