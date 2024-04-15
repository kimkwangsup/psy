package com.human.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {
	@RequestMapping("/")
	public ModelAndView getMain(ModelAndView mv, RedirectView rv) {
		/*
		rv.setUrl("/main.psy");
		mv.setView(rv);
		*/
		mv.setViewName("main");
		return mv;
	}
}
