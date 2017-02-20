package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.PhoneCompatibilityDao;
import ua.com.shop.entity.PhoneCompatibility;
import ua.com.shop.service.PhoneCompatibilityService;

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
}