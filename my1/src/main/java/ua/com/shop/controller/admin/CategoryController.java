package ua.com.shop.controller.admin;

import javax.validation.Valid;
import static ua.com.shop.util.ParamBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.service.CategoryService;
import ua.com.shop.validator.CategoryValidator;

@Controller
@RequestMapping("/admin/category")
@SessionAttributes("category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@ModelAttribute("category")
	public Category getForm(){
		return new Category();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@InitBinder("category")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new CategoryValidator(categoryService));
	}
	
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", categoryService.findAll(pageable,filter));
		return "admin-category";
	}
	
	@PostMapping
	public String save(@ModelAttribute("category") @Valid Category category, BindingResult br, Model model,  
			SessionStatus status,@PageableDefault Pageable pageable, 
			@ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			return show(model,pageable, filter);
		}
		categoryService.save(category);
		status.setComplete();
		return "redirect:/admin/category" + getParams(pageable,filter);
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
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id,Model model,@PageableDefault Pageable pageable, 
			@ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("category", categoryService.findById(id));
		show(model,pageable, filter);
		return "admin-category";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id ,@PageableDefault Pageable pageable, 
			@ModelAttribute("filter") BasicFilter filter) {
		categoryService.deleteById(id);
		return"redirect:/admin/category" + getParams(pageable,filter);
	}
}
