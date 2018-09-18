package kr.co.beauty.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	// 회원가입 페이지
	@RequestMapping(value = "/member/signUp", method = RequestMethod.GET)
	public String signUp() {
		return "joinMember";
	}
	
	// 회원가입
	@RequestMapping(value = "/member/join", method = RequestMethod.POST)
	public ModelAndView join(@ModelAttribute MemberVO memberVO) {
		
		//MEMBER 테이블의 AGE_ID위한 처리과정
		if(memberVO.getMEM_AGE() >= 0 && memberVO.getMEM_AGE() < 20 ) {
			memberVO.setAGE_ID(1);
		} else if (memberVO.getMEM_AGE() >= 20 && memberVO.getMEM_AGE() < 30 ) {
			memberVO.setAGE_ID(2);
		} else if (memberVO.getMEM_AGE() >= 30 && memberVO.getMEM_AGE() < 40 ) {
			memberVO.setAGE_ID(3);
		} else if (memberVO.getMEM_AGE() >= 40 && memberVO.getMEM_AGE() < 50 ) {
			memberVO.setAGE_ID(4);
		} else {
			memberVO.setAGE_ID(5);
		}
		
		modelAndView = new ModelAndView();
		modelAndView = memberService.memberJoin(memberVO);
		
		return modelAndView;
	}
	// 로그인
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute MemberVO memberVO, HttpServletResponse response) throws IOException {
		modelAndView = new ModelAndView();
		modelAndView = memberService.memberLogin(memberVO, response);
		return modelAndView;
	}
	
	// 로그아웃
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout() {
		session.invalidate();
		return "main";
	}
	
	// 마이페이지_인증 페이지
	@RequestMapping(value = "/member/info/*", method = RequestMethod.GET)
	public String myPage() {
		return "myPageAuth";
	}
	
	// 마이페이지_정보 수정 페이지
	@RequestMapping(value = "/member/info/*", method = RequestMethod.POST)
	public ModelAndView myPageRivision(HttpServletRequest request, HttpSession session) {
		modelAndView = new ModelAndView();
		
		String password = request.getParameter("MEM_PW");
		
		modelAndView = memberService.memberInfoAuth(password, session);
		return modelAndView;
	}
}
