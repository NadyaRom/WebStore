package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Material;

public interface MaterialDao extends JpaRepository<Material, Integer> {

}
