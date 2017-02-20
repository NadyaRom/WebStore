package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Producer;

public interface ProducerDao extends JpaRepository<Producer, Integer> {
	
	@Query("select p from Producer p "
			+ "left join fetch p.products where p.name=:name")
	List<Producer> fetchProducerWithProducts(@Param("name") String name);

	
}