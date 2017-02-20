package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Orders;

public interface OrdersService  {
	void save(Orders orders);

	Orders findById(int id);

	void update(Orders orders);

	void deleteById(int id);
	
	List<Orders> getAll();
}
