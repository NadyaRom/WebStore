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
import ua.com.shop.entity.Color;
import ua.com.shop.service.ColorService;

@Controller
@RequestMapping("/admin/color")
@SessionAttributes("color")
public class ColorController {

	@Autowired
	private ColorService colorService;
	

	@ModelAttribute("color")
	Color getForm(){
		return new Color();
	}
	
	@RequestMapping
	public String show(Model model){
		model.addAttribute("colors", colorService.getAll());
		return "admin-color";
	}
	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("color") Color color, SessionStatus status){
		colorService.save(color);
		status.setComplete();
		return "redirect:/admin/color";
		
	}
//	@RequestMapping(method=POST)
//	public String save(@RequestParam String name){
//		colorService.save(name);
//		return "redirect:/admin/color";
//		
//	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id,Model model) {
		model.addAttribute("color", colorService.findById(id));
		show(model);
		return "admin-color";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		colorService.deleteById(id);
		return"redirect:/admin/color";
	}
}

