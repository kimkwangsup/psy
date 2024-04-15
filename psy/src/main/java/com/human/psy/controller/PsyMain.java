package com.human.psy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PsyMain {
	@RequestMapping("/main.psy")
	public ModelAndView psyMain(ModelAndView mv, RedirectView rv) {
		mv.setViewName("main");
		return mv;
	}
}