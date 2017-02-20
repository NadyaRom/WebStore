package ua.com.shop.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.hibernate.dialect.Cache71Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.context.SaveContextOnUpdateOrErrorResponseWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import ua.com.shop.entity.Category;
import ua.com.shop.service.CategoryService;


@Controller
@RequestMapping("/admin/category")
@SessionAttributes("category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@ModelAttribute("category")
	Category getForm(){
		return new Category();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("categories", categoryService.getAll());
		return "admin-category";
	}
	
	@PostMapping
	public String save(@ModelAttribute("category") Category category, SessionStatus status){
		categoryService.save(category);
		status.setComplete();
		return "redirect:/admin/category";
	}
	
//	@RequestMapping(method=POST)
//	public String save(@RequestParam String name){
//		categoryService.save(name);
//		return "redirect:/admin/category";
//	}
	
	@RequestMapping("/categories/{id}")
	public String category(Model model){
			return "user-categories";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		categoryService.deleteById(id);
		return"redirect:/admin/category";
	}
}
