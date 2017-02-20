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
import ua.com.shop.entity.PhoneCompatibility;
import ua.com.shop.service.PhoneCompatibilityService;

@Controller
@RequestMapping("/admin/phoneCompatibility")
@SessionAttributes("ps")
public class PhoneCompatibilityController {

	@Autowired
	private PhoneCompatibilityService phoneCompatibilityService;
	
	@ModelAttribute("ps")
	PhoneCompatibility getForm(){
		return new PhoneCompatibility();
	}
	
	@RequestMapping
	public String show(Model model){
		model.addAttribute("pss", phoneCompatibilityService.getAll());
		return "admin-phoneCompatibility";	
	}
	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("ps") PhoneCompatibility phoneCompatibility,SessionStatus status ){
		phoneCompatibilityService.save(phoneCompatibility);
		status.setComplete();
		return "redirect:/admin/phoneCompatibility";
		
	}
//	@RequestMapping(method=POST)
//	public String save(@RequestParam String name){
//		phoneCompatibilityService.save(name);
//		return "redirect:/admin/phoneCompatibility";
//		
//	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		phoneCompatibilityService.deleteById(id);
		return"redirect:/admin/phoneCompatibility";
	}

}
