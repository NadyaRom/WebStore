package ua.com.shop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.shop.service.CategoryService;
import ua.com.shop.service.ProductService;

@Controller
@RequestMapping("/categories/{id}")
public class CategoriesController {
	
	@Autowired
	private CategoryService  categoryService;
	
	@Autowired
	private ProductService productService;

	@GetMapping
	public String showProductsbyCategory(@PathVariable int id, Model model){
		model.addAttribute("category", categoryService.findById(id));
		model.addAttribute("products", productService.findByCategoryId(id));
		model.addAttribute("products", productService.findAllbyCategoryId(id));
		return "user-categories";
	}
	
	
	
}
