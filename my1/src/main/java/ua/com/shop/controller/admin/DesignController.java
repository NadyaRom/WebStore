package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import ua.com.shop.entity.Category;
import ua.com.shop.entity.Design;
import ua.com.shop.service.DesignService;

@Controller
@RequestMapping("/admin/design")
@SessionAttributes("design")
public class DesignController {
	
	@Autowired
	private DesignService designService;
	
	@ModelAttribute("design")
	Design getForm(){
		return new Design();
	}

	
	@RequestMapping
	public String show(Model model){
		model.addAttribute("designs",designService.getAll());
		return "admin-design";
	}
	
	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("design") Design design, SessionStatus status){
		designService.save(design);
		status.setComplete();
		return "redirect:/admin/design";
		
	}
//	@RequestMapping(method=POST)
//	public String save(@RequestParam String name){
//		designService.save(name);
//		return "redirect:/admin/design";
//		
//	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id,Model model) {
		model.addAttribute("design", designService.findById(id));
		show(model);
		return "admin-design";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		designService.deleteById(id);
		return"redirect:/admin/category";
	}
}