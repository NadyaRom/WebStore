package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.PhoneCompatibility;

public interface PhoneCompatibilityDao extends JpaRepository<PhoneCompatibility, Integer> {

}
