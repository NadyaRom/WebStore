package ua.com.shop.dao;

import java.util.List;

public interface Dao <T> {

	T save(T item);

	T findById(int id);

	void update(T item);

	void deleteById(int id);

	List<T> getAll();


}


