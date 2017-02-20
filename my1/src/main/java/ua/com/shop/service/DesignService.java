package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Design;;

public interface DesignService {

	void save (String name);
	
	void save (Design design);

	Design findById(int id);

	void update(int id, String name);

	void deleteById(int id);
	
	List<Design> getAll();
}
