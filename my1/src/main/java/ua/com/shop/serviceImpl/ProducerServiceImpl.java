package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.ProducerDao;
import ua.com.shop.entity.Producer;
import ua.com.shop.service.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService{
	
	@Autowired
	private ProducerDao producerDao;
	
	public void save(String name) {
		Producer producer = new Producer();
		producer.setName(name);
		producerDao.save(producer);
		
	}

	public Producer findById(int id) {
		return producerDao.findOne(id);
	}

	public void update(int id, String name) {
		producerDao.findOne(id).setName(name);
		
	}

	public void deleteById(int id) {
		producerDao.delete(id);
		
	}

	public List<Producer> getAll() {
		return producerDao.findAll();
	}

	public List<Producer> fetchProducerWithProducts(String name) {
		return producerDao.fetchProducerWithProducts(name);
	}

	public void save(Producer producer) {
		producerDao.save(producer);		
	}
	
	
	

}
