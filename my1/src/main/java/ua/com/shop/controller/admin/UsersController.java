package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.shop.service.UserService;

@Controller
@RequestMapping("/admin/users")
public class UsersController {
	
	@Autowired
	private UserService userService;

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("users",userService.getAll());
		return "admin-users";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		userService.deleteById(id);
		return"redirect:/admin/users";
	}

}
