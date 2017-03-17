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

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.mysql.jdbc.Buffer;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static ua.com.shop.util.ParamBuilder.getParams;

import javax.validation.Valid;

import org.omg.CORBA.PUBLIC_MEMBER;

import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Type;
import ua.com.shop.service.TypeService;
import ua.com.shop.validator.TypeValidator;

@Controller
@RequestMapping("/admin/type")
@SessionAttributes("type")
public class TypeController {
	
	@Autowired
	private TypeService typeService;
	
	@ModelAttribute("type")
	public Type getForm(){
		return new Type();
	}

	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
//	@RequestMapping(method=POST)
//	public String save(@RequestParam String name){
//		typeService.save(name);
//		return "redirect:/admin/type";
//	}
	
	@InitBinder("type")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new TypeValidator(typeService));
	}
	
	@PostMapping
	public String save(@ModelAttribute("type") @Valid Type type, BindingResult br, Model model,  
			SessionStatus status,@PageableDefault Pageable pageable, 
			@ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			return show(model,pageable, filter);
		}
		typeService.save(type);
		status.setComplete();
		return "redirect:/admin/type"+ getParams(pageable,filter);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id,Model model,@PageableDefault Pageable pageable, 
			@ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("type", typeService.findById(id));
		show(model,pageable, filter);
		return "admin-type";
	}
	
	@GetMapping
	public String  show(Model model,@PageableDefault Pageable pageable, 
			@ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", typeService.findAll(pageable, filter));
		return "admin-type";
		
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id ,@PageableDefault Pageable pageable, 
			@ModelAttribute("filter") BasicFilter filter) {
		typeService.deleteById(id);
		return"redirect:/admin/type" + getParams(pageable,filter);
	}
	

}
