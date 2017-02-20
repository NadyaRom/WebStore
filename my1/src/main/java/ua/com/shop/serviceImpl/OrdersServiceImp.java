package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.OrdersDao;
import ua.com.shop.entity.Orders;
import ua.com.shop.service.OrdersService;

@Service
public class OrdersServiceImp implements OrdersService{
	
	@Autowired
	private OrdersDao ordersDao;

	public void save(Orders orders) {
		ordersDao.save(orders);
		
	}

	public Orders findById(int id) {
		return ordersDao.findOne(id);
	}

	public void update(Orders orders) {
		ordersDao.save(orders);
		
	}

	public void deleteById(int id) {
		ordersDao.delete(id);
		
	}

	public List<Orders> getAll() {
		return ordersDao.findAll();
	}
	
	
}
