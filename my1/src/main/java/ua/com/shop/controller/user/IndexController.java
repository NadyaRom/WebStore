package ua.com.shop.controller.user;
import javax.persistence.Index;
import javax.servlet.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.ui.Model;

import ua.com.shop.entity.User;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.ProducerService;
import ua.com.shop.service.ProductService;
import ua.com.shop.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	CategoryService  categoryService;
	
	@Autowired
	ProducerService producerService;
	
	@Autowired
	private ProductService productService;

	
	@RequestMapping("/admin")
	public String admin(){
		return "admin-admin";
	}
	
	@RequestMapping("/aboutUs")
	public String about(){
		return "user-aboutUs";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "user-login";
	}
	
	@RequestMapping("/registration")
	public String registration(Model model){
		User user = new User();
		model.addAttribute("userForm",user);
		return "user-registration";
	}
	
	@RequestMapping(name = "/registration", method=POST)
	public String registrationSave(@ModelAttribute User user){
		userService.save(user);
		return "redirect:/admin/login";	
	}
	
	@RequestMapping("/contactUs")
	public String contactUs(){
		return "user-contactUs";
	}
	
	@RequestMapping("/")
	public String shop(Model model){
		model.addAttribute("categories", categoryService.getAll());
		return "user-index";
	}
	


	
	
	
	
}
