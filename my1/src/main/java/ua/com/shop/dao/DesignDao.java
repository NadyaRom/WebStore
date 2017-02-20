package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Design;

public interface DesignDao extends JpaRepository<Design, Integer> {

}
