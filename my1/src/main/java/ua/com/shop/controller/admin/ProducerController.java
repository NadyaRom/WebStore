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
import ua.com.shop.entity.Producer;
import ua.com.shop.service.ProducerService;
import ua.com.shop.validator.ProducerValidator;

@Controller
@RequestMapping("/admin/producer")
@SessionAttributes("producer")
public class ProducerController {
	
	@Autowired
	private ProducerService producerService;
	
	@ModelAttribute("producer")
	public Producer getForm(){
		return new Producer();
	}

	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@InitBinder("producer")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new ProducerValidator(producerService));
	}
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page",producerService.findAll(pageable, filter));
		return "admin-producer";
	}
	
	
	@PostMapping
	public String save(@ModelAttribute("producer") @Valid Producer producer, BindingResult br,  Model model,  SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			return show(model,pageable, filter);
		}
		producerService.save(producer);
		status.setComplete();
		return "redirect:/admin/design" + getParams(pageable,filter);
		
	}
//	@RequestMapping(method=POST)
//	public String save(@RequestParam String name){
//		producerService.save(name);
//		return "redirect:/admin/producer";
		
//	}
	
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id,Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("producer", producerService.findById(id));
		show(model,pageable, filter);
		return "admin-producer";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		producerService.deleteById(id);
		return"redirect:/admin/producer" + getParams(pageable,filter);
	}
}
