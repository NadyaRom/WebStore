package ua.com.shop.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	
	@RequestMapping(method=POST)
	public String save(@RequestParam String name, @RequestParam double price, 
			@RequestParam int categoryId, @RequestParam int producerId,
			@RequestParam int colorId, @RequestParam int designId, @RequestParam int materialId, @RequestParam int typeId, @RequestParam int psId){
		productService.save(name, price, categoryId, producerId, colorId, designId, materialId, typeId, psId);
		return "redirect:/admin/product";
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
	
	
	
}

