package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.MaterialDao;
import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Material;
import ua.com.shop.service.MaterialService;
import ua.com.shop.spec.CategorySpec;
import ua.com.shop.spec.MaterialSpec;

@Service
public class MaterialServiceImpl  implements MaterialService{
	
	@Autowired
	private MaterialDao materialDao;

	public void save(String name) {
		Material material = new Material();
		material.setName(name);
		materialDao.save(material);
	}

	public Material findById(int id) {
		return  materialDao.findOne(id);
	}

	public void update(int id, String name) {
		materialDao.findOne(id).setName(name);
		
	}

	public void deleteById(int id) {
		materialDao.delete(id);
		
	}

	public List<Material> getAll() {
		return materialDao.findAll();
	}

	public void save(Material material) {
		materialDao.save(material);		
	}

	public Material findByName(String name) {
		return materialDao.findByName(name);
	}
	@Override
	public Page<Material> findAll(Pageable pageable, BasicFilter filter) {
		return materialDao.findAll(new MaterialSpec(filter), pageable);
	}
}
