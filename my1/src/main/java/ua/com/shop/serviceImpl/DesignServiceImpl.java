package ua.com.shop.serviceImpl;

import java.util.List;

import javax.swing.DefaultBoundedRangeModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.shop.dao.DesignDao;
import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Design;
import ua.com.shop.service.DesignService;
import ua.com.shop.spec.CategorySpec;
import ua.com.shop.spec.DesignSpec;

@Service
public class DesignServiceImpl  implements DesignService{
	
	@Autowired
	private DesignDao designDao;

	public void save(String name) {
		Design design = new Design();
		design.setName(name);
		designDao.save(design);
	}

	public Design findById(int id) {
		return  designDao.findOne(id);
	}

	public void update(int id, String name) {
		designDao.findOne(id).setName(name);
		
	}

	public void deleteById(int id) {
		designDao.delete(id);
		
	}

	public List<Design> getAll() {
		return designDao.findAll();
	}

	public void save(Design design) {
		designDao.save(design);
	}

	public Design findByName(String name) {
		return designDao.findByName(name);
	}
	@Override
	public Page<Design> findAll(Pageable pageable, BasicFilter filter) {
		return designDao.findAll(new DesignSpec(filter), pageable);
	}
}
	

