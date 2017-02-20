package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ua.com.shop.dao.CategoryDao;
import ua.com.shop.dao.ColorDao;
import ua.com.shop.dao.DesignDao;
import ua.com.shop.dao.MaterialDao;
import ua.com.shop.dao.PhoneCompatibilityDao;
import ua.com.shop.dao.ProducerDao;
import ua.com.shop.dao.ProductDao;
import ua.com.shop.dao.TypeDao;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Design;
import ua.com.shop.entity.Material;
import ua.com.shop.entity.Product;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProducerDao producerDao;
	
	@Autowired
	private ColorDao colorDao;
	
	@Autowired
	private DesignDao designDao;
	
	@Autowired
	private MaterialDao materialDao;
	
	@Autowired
	private TypeDao typeDao;
	
	@Autowired
	private PhoneCompatibilityDao phoneCompatibilityDao;
	
	public void save(Product product) {
		productDao.save(product);
	}

	public Product findById(int id) {
		return productDao.findOne(id);
	}

	public void update(Product product) {
		productDao.save(product);
		
	}

	public void deleteById(int id) {
		productDao.delete(id);
		
	}
	
	public List<Product> getAll() {
		return productDao.findAll();
	}

	@Transactional
	public void save(String name, double price, int categoryId, int producerId, int colorId, int designId,
			int materialId, int typeId, int psId) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setCategory(categoryDao.findOne(categoryId));
		product.setProducer(producerDao.findOne(producerId));
		product.setColor(colorDao.findOne(colorId));
		product.setDesign(designDao.findOne(designId));
		product.setMaterial(materialDao.findOne(materialId));
		product.setType(typeDao.findOne(typeId));
		product.setPhoneCompatibility(phoneCompatibilityDao.findOne(psId));
		productDao.save(product);
		
	}

	public List<Product> findAll() {
		return productDao.findAll();
	}

	public List<Product> findByCategoryId(int id){
		return productDao.findByCategoryId(id);
		
	}
	
	public List<Product> findAllbyCategoryId(int id){
		return productDao.findAllbyCategoryId(id);
	}
	
	public Product findAllbyId(int id){
		return productDao.findAllbyId(id);
		
	}

}