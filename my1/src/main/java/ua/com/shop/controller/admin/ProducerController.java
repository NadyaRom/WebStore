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
import ua.com.shop.entity.Producer;
import ua.com.shop.service.ProducerService;

@Controller
@RequestMapping("/admin/producer")
@SessionAttributes("producer")
public class ProducerController {
	
	@Autowired
	private ProducerService producerService;
	
	@ModelAttribute("producer")
	Producer getForm(){
		return new Producer();
	}
	
	@RequestMapping
	public String show(Model model){
		model.addAttribute("producers",producerService.getAll());
		return "admin-producer";
	}
	
	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("producer") Producer producer,SessionStatus status ){
		producerService.save(producer);
		status.setComplete();
		
		return "redirect:/admin/producer";
		
	}
//	@RequestMapping(method=POST)
//	public String save(@RequestParam String name){
//		producerService.save(name);
//		return "redirect:/admin/producer";
		
//	}
	
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id,Model model) {
		model.addAttribute("producer", producerService.findById(id));
		show(model);
		return "admin-producer";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		producerService.deleteById(id);
		return"redirect:/admin/producer";
	}
}
