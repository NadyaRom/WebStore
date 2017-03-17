package ua.com.shop.controller.admin;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static ua.com.shop.util.ParamBuilder.getParams;

import javax.validation.Valid;

import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Design;
import ua.com.shop.entity.PhoneCompatibility;
import ua.com.shop.service.PhoneCompatibilityService;
import ua.com.shop.validator.PhoneCompatibilityValidator;

@Controller
@RequestMapping("/admin/phoneCompatibility")
@SessionAttributes("ps")
public class PhoneCompatibilityController {

	@Autowired
	private PhoneCompatibilityService phoneCompatibilityService;
	
	@ModelAttribute("ps")
	public PhoneCompatibility getForm(){
		return new PhoneCompatibility();
	}

	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@InitBinder("ps")
	protected void bind (WebDataBinder binder){
		binder.setValidator(new PhoneCompatibilityValidator(phoneCompatibilityService));
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", phoneCompatibilityService.findAll(pageable,filter));
		return "admin-phoneCompatibility";	
	}
	
	@PostMapping
	public String save(@ModelAttribute("ps") @Valid PhoneCompatibility phoneCompatibility, BindingResult br,  Model model,  SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			return show(model,pageable,filter);
		}
		phoneCompatibilityService.save(phoneCompatibility);
		status.setComplete();
		return "redirect:/admin/phoneCompatibility" + getParams(pageable,filter);
		
	}
//	@RequestMapping(method=POST)
//	public String save(@RequestParam String name){
//		phoneCompatibilityService.save(name);
//		return "redirect:/admin/phoneCompatibility";
//		
//	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id,Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("ps", phoneCompatibilityService.findById(id));
		show(model,pageable,filter);
		return "admin-phoneCompatibility";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		phoneCompatibilityService.deleteById(id);
		return"redirect:/admin/phoneCompatibility" + getParams(pageable,filter);
	}

}
