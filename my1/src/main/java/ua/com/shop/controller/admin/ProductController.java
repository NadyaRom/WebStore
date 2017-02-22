package ua.com.shop.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.enterprise.inject.New;
import javax.validation.spi.ValidationProvider;

import org.hibernate.boot.jaxb.spi.Binder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.editor.CategoryEditor;
import ua.com.shop.editor.ColorEditor;
import ua.com.shop.editor.DesignEditor;
import ua.com.shop.editor.MaterialEditor;
import ua.com.shop.editor.PhoneCompatibilityEditor;
import ua.com.shop.editor.ProducerEditor;
import ua.com.shop.editor.TypeEditor;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.Design;
import ua.com.shop.entity.Material;
import ua.com.shop.entity.PhoneCompatibility;
import ua.com.shop.entity.Producer;
import ua.com.shop.entity.Product;
import ua.com.shop.entity.Type;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.ColorService;
import ua.com.shop.service.DesignService;
import ua.com.shop.service.MaterialService;
import ua.com.shop.service.PhoneCompatibilityService;
import ua.com.shop.service.ProducerService;
import ua.com.shop.service.ProductService;
import ua.com.shop.service.TypeService;

@Controller
@RequestMapping("/admin/product")
@SessionAttributes("product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService  categoryService ;
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private ColorService colorService;
	
	@Autowired
	private DesignService designService;
	
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private TypeService typeService;
	
	@Autowired
	private PhoneCompatibilityService phoneCompatibilityService;
	
	@ModelAttribute("product")
	Product getForm(){
		return new Product();
	}
	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("product") Product product, SessionStatus sessionStatus){
		productService.save(product);
		sessionStatus.setComplete();
		return "redirect:/admin/product";
	}
	
//	@RequestMapping(method=POST)
//	public String save(@RequestParam String name, @RequestParam double price, 
//			@RequestParam int categoryId, @RequestParam int producerId,
//			@RequestParam int colorId, @RequestParam int designId, @RequestParam int materialId, @RequestParam int typeId, @RequestParam int psId){
//		productService.save(name, price, categoryId, producerId, colorId, designId, materialId, typeId, psId);
//		return "redirect:/admin/product";
//	}
	
	@InitBinder("product")
	protected void binder(WebDataBinder binder){
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
		binder.registerCustomEditor(Design.class, new DesignEditor(designService));
		binder.registerCustomEditor(Material.class, new MaterialEditor(materialService));
		binder.registerCustomEditor(PhoneCompatibility.class, new PhoneCompatibilityEditor(phoneCompatibilityService));	
		binder.registerCustomEditor(Producer.class, new ProducerEditor(producerService));
		binder.registerCustomEditor(Type.class, new TypeEditor(typeService));
		
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) { 
		productService.deleteById(id);
		return"redirect:/admin/product";
	}
	
	@RequestMapping
	private String show(Model model){
		model.addAttribute("products", productService.getAll());
		model.addAttribute("categories", categoryService.getAll());
		model.addAttribute("producers",producerService.getAll());
		model.addAttribute("colors", colorService.getAll());
		model.addAttribute("designs", designService.getAll());
		model.addAttribute("materials", materialService.getAll());	
		model.addAttribute("types",typeService.getAll());
		model.addAttribute("pss",phoneCompatibilityService.getAll());
		return "admin-product";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id,Model model) {
		model.addAttribute("product", productService.findAllbyId(id));
		return show(model);
	}
	
	
}

