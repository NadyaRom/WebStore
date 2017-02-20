package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.omg.CORBA.PUBLIC_MEMBER;

import ua.com.shop.entity.Category;
import ua.com.shop.entity.Type;
import ua.com.shop.service.TypeService;

@Controller
@RequestMapping("/admin/type")
@SessionAttributes("type")
public class TypeController {
	
	@Autowired
	private TypeService typeService;
	
	@ModelAttribute("type")
	Type getForm(){
		return new Type();
	}
	
//	@RequestMapping(method=POST)
//	public String save(@RequestParam String name){
//		typeService.save(name);
//		return "redirect:/admin/type";
//	}
	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("type") Type type,SessionStatus status){
		typeService.save(type);
		status.setComplete();
		return "redirect:/admin/type";
	}
	
	@GetMapping
	public String  show(Model model){
		model.addAttribute("types", typeService.getAll());
		return "admin-type";
		
	}
	

}
