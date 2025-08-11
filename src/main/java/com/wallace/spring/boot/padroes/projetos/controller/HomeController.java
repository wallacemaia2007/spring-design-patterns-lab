package com.wallace.spring.boot.padroes.projetos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
	    return "home"; 
	}
}
