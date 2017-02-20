package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.MaterialDao;
import ua.com.shop.entity.Material;
import ua.com.shop.service.MaterialService;

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
}
