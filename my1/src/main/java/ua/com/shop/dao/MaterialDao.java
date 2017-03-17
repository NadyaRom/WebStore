package ua.com.shop.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.Color;
import ua.com.shop.entity.Material;
import ua.com.shop.spec.MaterialSpec;

public interface MaterialDao extends JpaRepository<Material, Integer>, JpaSpecificationExecutor<Material> {

	Material findByName(String name);


}
