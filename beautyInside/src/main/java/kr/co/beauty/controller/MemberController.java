package kr.co.beauty.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.service.MemberService;
import kr.co.beauty.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	private ModelAndView modelAndView;
	
	@Autowired
	HttpSession session;
	
	//회원가입 페이지
	@RequestMapping(value = "/member/signUp", method = RequestMethod.GET)
	public String signUp() {
		return "joinMember";
	}
	
	//로그인
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute MemberVO memberVO, HttpServletResponse response) throws IOException {
		modelAndView = new ModelAndView();
		modelAndView = memberService.memberLogin(memberVO, response);
		return modelAndView;
	}
	
	//로그아웃
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout() {
		session.invalidate();
		return "main";
	}
	
}
