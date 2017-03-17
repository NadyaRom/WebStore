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

import javax.validation.Valid;

import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Design;
import ua.com.shop.service.DesignService;
import ua.com.shop.validator.DesignValidator;
import static ua.com.shop.util.ParamBuilder.*;

@Controller
@RequestMapping("/admin/design")
@SessionAttributes("design")
public class DesignController {
	
	@Autowired
	private DesignService designService;
	
	@ModelAttribute("design")
	public Design getForm(){
		return new Design();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	@InitBinder("design")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new DesignValidator(designService));
	}

	@RequestMapping
	public String show(Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page",designService.findAll(pageable, filter));
		return "admin-design";
	}
	
	
	@PostMapping
	public String save(@ModelAttribute("design") @Valid Design design, BindingResult br,  Model model,  SessionStatus status,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			return show(model,pageable, filter);
		}
		designService.save(design);
		status.setComplete();
		return "redirect:/admin/design"+ getParams(pageable, filter);
		
	}
//	@RequestMapping(method=POST)
//	public String save(@RequestParam String name){
//		designService.save(name);
//		return "redirect:/admin/design";
//		
//	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id,Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("design", designService.findById(id));
		show(model,pageable, filter);
		return "admin-design";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		designService.deleteById(id);
		return"redirect:/admin/design"+ getParams(pageable, filter);
	}
}