package com.lpu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/udaya")
	public String takeRequestUdaya() {
		return "udaya.jsp";
	}
}
