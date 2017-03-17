package ua.com.shop.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import ua.com.shop.dto.filter.ProductFilter;
import ua.com.shop.dto.form.ProductForm;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Design;
import ua.com.shop.entity.Material;
import ua.com.shop.entity.Producer;
import ua.com.shop.entity.Product;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.FileWriter;
import ua.com.shop.service.FileWriter.Folder;
import ua.com.shop.service.ProductService;
import ua.com.shop.spec.ProductSpec;

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
	private FileWriter fileWriter;

	@Autowired
	private PhoneCompatibilityDao phoneCompatibilityDao;
	

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

//	@Transactional
//	public void save(String name, BigDecimal price, int categoryId, int producerId, int colorId, int designId,
//			int materialId, int typeId, int psId) {
//		Product product = new Product();
//		product.setName(name);
//		product.setPrice(price);
//		product.setCategory(categoryDao.findOne(categoryId));
//		product.setProducer(producerDao.findOne(producerId));
//		product.setColor(colorDao.findOne(colorId));
//		product.setDesign(designDao.findOne(designId));
//		product.setMaterial(materialDao.findOne(materialId));
//		product.setType(typeDao.findOne(typeId));
//		product.setPhoneCompatibility(phoneCompatibilityDao.findOne(psId));
//		productDao.save(product);
//		
//	}
	@Override
	@Transactional
	public void save(ProductForm productForm) {
		Product product = new Product();
		product.setId(productForm.getId());
		product.setPrice(new BigDecimal(productForm.getPrice().replace(',', '.')));
		product.setCategory(productForm.getCategory());
		product.setType(productForm.getType());
		product.setColor(productForm.getColor());
		product.setDesign(productForm.getDesign());
		product.setMaterial(productForm.getMaterial());
		product.setPhoneCompatibility(productForm.getPhoneCompatibility());
		product.setProducer(productForm.getProducer());
	
		if(fileWriter.write(Folder.PRODUCT, productForm.getFile(), product.getId())){
			if(product.getVersion()==null)product.setVersion(0);
			else product.setVersion(product.getVersion()+1);
		}
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

	public Product findByName(String name) {
		return productDao.findByName(name);
	}

	@Override
	public Page<Product> findAll(Pageable pageable, ProductFilter filter) {
		return productDao.findAll(new ProductSpec(filter), pageable);
	}

	@Override
	public ProductForm findForm(Integer id) {
		ProductForm form = new ProductForm();
		Product product = productDao.findOne(id);
		form.setName(String.valueOf(product.getName()));
		form.setPrice(String.valueOf(product.getPrice()));
		form.setCategory(product.getCategory());
		form.setColor(product.getColor());
		form.setDesign(product.getDesign());
		form.setMaterial(product.getMaterial());
		form.setPhoneCompatibility(product.getPhoneCompatibility());
		form.setProducer(product.getProducer());
		form.setType(product.getType());
		return form;
	}

	

}


