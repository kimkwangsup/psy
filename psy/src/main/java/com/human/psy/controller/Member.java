package com.human.psy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.human.psy.dao.MemberDao;
import com.human.psy.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class Member {
	@Autowired
	MemberDao mDao;
	@RequestMapping("/login.psy")
	public ModelAndView login(HttpSession session, ModelAndView mv, RedirectView rv) {
		String view = "member/login";
		if(session.getAttribute("SID") != null) {
			view = "main";
			rv.setUrl(view);
			mv.setView(rv);
		}else {
			mv.setViewName(view);
		}
		return mv;
	}
	@RequestMapping("/join.psy")
	public ModelAndView join(HttpSession session, ModelAndView mv, RedirectView rv) {
		String view = "member/join";
		if(session.getAttribute("SID") != null) {
			view = "main";
			rv.setUrl(view);
			mv.setView(rv);
		}else {
			mv.setViewName(view);
		}
		return mv;
	}
	@RequestMapping("/loginProc.psy")
	public ModelAndView loginProc(MemberVO mVO, HttpSession session, RedirectView rv, ModelAndView mv) {
		String view = "/main.psy";
		if(session.getAttribute("SID") != null) {
			rv.setUrl(view);
			mv.setView(rv);
			return mv;
		}
		int cnt = mDao.getLogin(mVO);
		if(cnt != 1) {
			view = "/member/login.psy";
		}else {
			session.setAttribute("SID", mVO.getId());
		}
		rv.setUrl(view);
		mv.setView(rv);
		return mv;
	}
	@RequestMapping("/logoutProc.psy")
	public ModelAndView logoutProc(HttpSession session, RedirectView rv, ModelAndView mv) {
		String view = "/main.psy";
		if(session.getAttribute("SID") != null) {
			session.removeAttribute("SID");
			rv.setUrl(view);
			mv.setView(rv);
			return mv;
		}
		return mv;
	}
	
	@RequestMapping("/joinProc.psy")
	public ModelAndView joinProc(HttpSession session, RedirectView rv, ModelAndView mv, MemberVO mVO) {
		String view = "/main.psy";
		if(session.getAttribute("SID") != null) {
			rv.setUrl(view);
			mv.setView(rv);
		}
		int cnt = mDao.joinProc(mVO);
		if(cnt == 1) {
			session.setAttribute("SID", mVO.getId());
		}else {
			rv.setUrl("/member/join.psy");
		}
		mv.setView(rv);
		return mv;
	}
}
