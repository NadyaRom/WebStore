package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.UserDao;
import ua.com.shop.entity.User;
import ua.com.shop.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void save(User user) {
		userDao.save(user);
	}

	public User findById(int id) {
		return userDao.findOne(id);
	}

	public void update(User user) {
		userDao.save(user);
		
	}

	public void deleteById(int id) {
		userDao.delete(id);
		
	}

	public List<User> getAll() {
		return userDao.findAll();
	}
	
	
}

