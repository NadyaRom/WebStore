package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Type;

public interface TypeService {
	
	void save (String name);
	
	void save (Type type);

	Type findById(int id);

	void update(int id, String name);

	void deleteById(int id);
	
	List<Type> getAll();
	

}
