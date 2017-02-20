package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Color;

public interface ColorService {
	
	void save (String name);
	
	void save (Color color);

	Color findById(int id);

	void update(int id, String name);

	void deleteById(int id);
	
	List<Color> getAll();

}
