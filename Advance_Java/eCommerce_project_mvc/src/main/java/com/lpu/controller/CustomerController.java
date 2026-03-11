package com.lpu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lpu.entity.Customer;
import com.lpu.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/reg")
	public String registerCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "register";
	}
	
	@RequestMapping("saveCus")
	public String saveCustomer(@ModelAttribute Customer customer) {
		customerService.addCustomer(customer);
		return "redirect:/log";
	}
	
	@GetMapping("/log")
	public String showLoginPage() {
	    return "login";
	}

	@PostMapping("/log")
    public String loginCustomer(
            @RequestParam("email") String email,
            @RequestParam("phone") long phone,
            Model model) {

        Customer c = customerService.checkLogin(email, phone);

        if(c != null) {
            model.addAttribute("name", c.getName());
            return "redirect:/home";
        }
        else {
            model.addAttribute("msg", "Invalid Credentials");
            return "login";
        }
    }
	
	@RequestMapping("/home")
	public String homePageView() {
		return "homePage";
	}
}
