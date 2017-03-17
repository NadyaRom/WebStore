package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.TypeDao;
import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Type;
import ua.com.shop.service.TypeService;
import ua.com.shop.spec.CategorySpec;
import ua.com.shop.spec.TypeSpec;

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

	public Type findByName(String name) {
		// TODO Auto-generated method stub
		return typeDao.findByName(name);
	}
	@Override
	public Page<Type> findAll(Pageable pageable, BasicFilter filter) {
		return typeDao.findAll(new TypeSpec(filter), pageable);
	}
	

	

}
