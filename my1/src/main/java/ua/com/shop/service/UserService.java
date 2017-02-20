package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.User;

public interface UserService {
	
	void save(User user);

	User findById(int id);

	void update(User user);

	void deleteById(int id);
	
	List<User> getAll();
}
