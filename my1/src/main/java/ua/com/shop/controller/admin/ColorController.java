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

import javax.persistence.metamodel.Bindable;
import javax.validation.Valid;

import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Color;
import ua.com.shop.service.ColorService;
import ua.com.shop.validator.ColorValidator;
import static ua.com.shop.util.ParamBuilder.*;

@Controller
@RequestMapping("/admin/color")
@SessionAttributes("color")
public class ColorController {

	@Autowired
	private ColorService colorService;
	
	@InitBinder("color")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new ColorValidator(colorService));
	}
	

	@ModelAttribute("color")
	public Color getForm(){
		return new Color();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@RequestMapping
	public String show(Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", colorService.findAll(pageable, filter));
		return "admin-color";
	}
	
	@PostMapping
	public String save(@ModelAttribute("color") @Valid Color color, BindingResult br,  Model model, SessionStatus status,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter ){
		if(br.hasErrors()){
			return show(model,pageable, filter);
		}
		colorService.save(color);
		status.setComplete();
		return "redirect:/admin/color"+getParams(pageable, filter);
		
	}
//	@RequestMapping(method=POST)
//	public String save(@RequestParam String name){
//		colorService.save(name);
//		return "redirect:/admin/color";
//		
//	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id,Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("color", colorService.findById(id));
		show(model,pageable, filter);
		return "admin-color";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		colorService.deleteById(id);
		return"redirect:/admin/color"+getParams(pageable, filter);
	}
}

