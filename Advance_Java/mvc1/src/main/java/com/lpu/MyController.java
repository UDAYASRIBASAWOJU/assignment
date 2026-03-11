package com.lpu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Controller //take request and send response from Client(Browser)
public class MyController {
	
	@RequestMapping("/hi")
	public String takeRequestHi() {
		return "page.jsp";
	}
	
	@RequestMapping("/login")
	public String takeRequestLogin() {
		return "login.jsp";
	}
	
	@RequestMapping("/logout")
	public String takeRequestLogout() {
		return "logout.jsp";
	}
	
	@RequestMapping("/data")
	public String sendData(Model model) {
		model.addAttribute("name", "Udayaaa");
		model.addAttribute("phone", 9876543);
		return "display.jsp";
	}
	
	@RequestMapping("/mv")
	public ModelAndView sendData2(ModelAndView mv) {
		mv.addObject("name", "Veduu");
		mv.addObject("phone", 456789876);
		mv.setViewName("display.jsp");
		return mv;
	}
	
	@RequestMapping("/reg")
	public ModelAndView register(
			@RequestParam(value = "n") String name,
			@RequestParam(value = "p") String phone,
			@RequestParam(value = "e") String email) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("phone", phone);
		mv.addObject("email", email);
		mv.setViewName("display.jsp");
		return mv;
	}
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	
	@RequestMapping("/reg2")
	public ModelAndView register2(@ModelAttribute  Student s) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(s);
		et.commit();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", s.getId());
		mv.addObject("name", s.getName());
		mv.addObject("phone", s.getPhone());
		mv.addObject("email", s.getEmail());
		mv.setViewName("display.jsp");
		return mv;
	}
	
	@RequestMapping("/fetch")
	public ModelAndView fetchData(@RequestParam("id") int id) {
		EntityManager em = emf.createEntityManager();
		
		Student s = em.find(Student.class, id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", s.getId());
		mv.addObject("name", s.getName());
		mv.addObject("phone", s.getPhone());
		mv.addObject("email", s.getEmail());
		mv.setViewName("display.jsp");
		
		return mv;
	}
	
	@RequestMapping("/vr")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("s", new Student());
		return "register2";
	}
	
	@RequestMapping("/save")
	public String saveEmployee(@ModelAttribute Student s) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		return "displyAll";
	}
}
