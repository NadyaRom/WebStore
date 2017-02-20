package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.ColorDao;

import ua.com.shop.entity.Color;
import ua.com.shop.service.ColorService;

@Service
public class ColorServiceImpl  implements ColorService{
	
	@Autowired
	private ColorDao colorDao;

	public void save(String name) {
		Color color = new Color();
		color.setName(name);
		colorDao.save(color);
	}

	public Color findById(int id) {
		return  colorDao.findOne(id);
	}
	
	public void update(int id, String name){
		colorDao.findOne(id).setName(name);
		
	}

	public void deleteById(int id) {
		colorDao.delete(id);
		
	}

	public List<Color> getAll() {
		return colorDao.findAll();
	}

	public void save(Color color) {
		colorDao.save(color);
	}
	

}
