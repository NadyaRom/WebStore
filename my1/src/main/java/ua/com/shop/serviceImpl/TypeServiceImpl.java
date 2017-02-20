package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.TypeDao;
import ua.com.shop.entity.Type;
import ua.com.shop.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService{

	@Autowired
	private TypeDao typeDao;

	public void save(String name) {
		Type type = new Type();
		type.setName(name);
		typeDao.save(type);
	}

	public Type findById(int id) {
		return  typeDao.findOne(id);
	}

	public void update(int id, String name) {
		typeDao.findOne(id).setName(name);	
	}

	public void deleteById(int id) {
		typeDao.delete(id);
		
	}

	public List<Type> getAll() {
		return typeDao.findAll();
	}

	public void save(Type type) {
		typeDao.save(type);
	}

	

	

}
