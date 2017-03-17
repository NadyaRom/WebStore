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
import ua.com.shop.entity.Material;
import ua.com.shop.service.MaterialService;
import ua.com.shop.validator.MaterialValidator;

@Controller
@RequestMapping("/admin/material")
@SessionAttributes("material")
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	@ModelAttribute("material")
	public Material getForm(){
		return new Material();
	}

	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@InitBinder("material")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new MaterialValidator(materialService));
	}
	
	@RequestMapping
	public String show(Model model,@PageableDefault Pageable pageable, 
			@ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", materialService.findAll(pageable, filter));
		return "admin-material";
	}

	@PostMapping
	public String save(@ModelAttribute("material") @Valid Material material, BindingResult br,  Model model,  SessionStatus status,@PageableDefault Pageable pageable, 
			@ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			return show(model,pageable, filter);
		}
		materialService.save(material);
		status.setComplete();
		return "redirect:/admin/material" + getParams(pageable,filter);
		
	}
//	@RequestMapping(method=POST)
//	public String save(@RequestParam String name){
//		materialService.save(name);
//		return "redirect:/admin/material";
//		
//	}
	
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id,Model model,@PageableDefault Pageable pageable, 
			@ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("material", materialService.findById(id));
		show(model,pageable, filter);
		return "admin-material";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable, 
			@ModelAttribute("filter") BasicFilter filter) {
		materialService.deleteById(id);
		return"redirect:/admin/material" + getParams(pageable,filter);
	}

}
