package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.PhoneCompatibilityDao;
import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.PhoneCompatibility;
import ua.com.shop.service.PhoneCompatibilityService;
import ua.com.shop.spec.CategorySpec;
import ua.com.shop.spec.PhoneCompatibilitySpec;

@Service
public class PhoneCompatibilityServiceImpl  implements PhoneCompatibilityService{
	
	@Autowired
	private PhoneCompatibilityDao phoneCompatibilityDao;

	public void save(String name) {
		PhoneCompatibility phoneCompatibility = new PhoneCompatibility();
		phoneCompatibility.setName(name);
		phoneCompatibilityDao.save(phoneCompatibility);
	}

	public PhoneCompatibility findById(int id) {
		return  phoneCompatibilityDao.findOne(id);
	}

	public void update(int id, String name) {
		phoneCompatibilityDao.findOne(id).setName(name);
		
	}

	public void deleteById(int id) {
		phoneCompatibilityDao.delete(id);
		
	}

	public List<PhoneCompatibility> getAll() {
		return phoneCompatibilityDao.findAll();
	}

	public void save(PhoneCompatibility phoneCompatibility) {
		phoneCompatibilityDao.save(phoneCompatibility);
		
	}

	public PhoneCompatibility findByName(String name) {
		return phoneCompatibilityDao.findByName(name);
	}
	
	@Override
	public Page<PhoneCompatibility> findAll(Pageable pageable, BasicFilter filter) {
		return phoneCompatibilityDao.findAll(new PhoneCompatibilitySpec(filter), pageable);
	}
}