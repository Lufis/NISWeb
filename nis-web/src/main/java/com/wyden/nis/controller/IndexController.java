package com.wyden.nis.controller;

import org.springframework.stereotype.Controller;	
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/nis")
public class IndexController {

	@GetMapping
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("/index");
		return mv;
	}

}