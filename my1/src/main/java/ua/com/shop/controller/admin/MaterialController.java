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
import ua.com.shop.entity.Material;
import ua.com.shop.service.MaterialService;

@Controller
@RequestMapping("/admin/material")
@SessionAttributes("material")
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	@ModelAttribute("material")
	Material getForm(){
		return new Material();
	}
	
	@RequestMapping
	public String show(Model model){
		model.addAttribute("materials", materialService.getAll());
		return "admin-material";
	}

	@RequestMapping(method=POST)
	public String save(@ModelAttribute("material") Material material, SessionStatus status ){
		materialService.save(material);
		status.setComplete();
		return "redirect:/admin/material";
		
	}
//	@RequestMapping(method=POST)
//	public String save(@RequestParam String name){
//		materialService.save(name);
//		return "redirect:/admin/material";
//		
//	}
	
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id,Model model) {
		model.addAttribute("material", materialService.findById(id));
		show(model);
		return "admin-material";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		materialService.deleteById(id);
		return"redirect:/admin/material";
	}

}
