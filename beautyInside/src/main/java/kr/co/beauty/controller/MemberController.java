package kr.co.beauty.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	// (page link) 회원가입 페이지
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
	
	// 아이디 중복 체크(ajax)
	@RequestMapping(value = "/member/idck", method=RequestMethod.POST)
	public void idck(HttpServletResponse response, @RequestParam("id") String MEM_ID) throws IOException {
		memberService.idOverlap(MEM_ID, response);
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
	
	// (page link) 마이페이지_인증 페이지
	@RequestMapping(value = "/member/info/*", method = RequestMethod.GET)
	public String myPageAuth() {
		return "myPageAuth";
	}
	
	// 마이페이지_인증 페이지 : 인증 기능
	@RequestMapping(value = "/member/info/auth/*", method = RequestMethod.POST)
	public ModelAndView myPageRevision(HttpServletRequest request, HttpSession session) {
		modelAndView = new ModelAndView();
		
		String password = request.getParameter("MEM_PW");
		
		modelAndView = memberService.memberInfoAuth(password, session);
		return modelAndView;
	}
	
	// 마이페이지_개인정보 수정  기능 
		@RequestMapping(value = "/member/revision/*", method = RequestMethod.POST)
		public ModelAndView myInfoRivesion(@ModelAttribute MemberVO memberVO) {
			modelAndView = new ModelAndView();
			modelAndView = memberService.memberRevise(memberVO);
			
			return modelAndView;
		}
	
	// (page link) 마이페이지_주문목록/배송조회 페이지
	@RequestMapping(value = "/member/orders/*", method = RequestMethod.GET)
	public String myPageItemOrder() {
		return "myPageItemOrder";
	}

	// (page link) 마이페이지_내가 쓴 리뷰 페이지
	@RequestMapping(value = "/member/reviews/*", method = RequestMethod.GET)
	public String myPageReviewWrote() {
		return "myPageReviewWrote";
	}
	
	// (page link) 마이페이지_좋아요 한 리뷰
	@RequestMapping(value = "/member/liked/*", method = RequestMethod.GET)
	public String myPageReviewLiked() {
		return "myPageReviewLiked";
	}
	
	// (page link) 마이페이지_제품 찜 목록
	@RequestMapping(value = "/member/stored/*", method = RequestMethod.GET)
	public String myPageItemStored() {
		return "myPageItemStored";
	}
	
	// (page link) 마이페이지_팔로워/팔로잉 페이지
	@RequestMapping(value = "/member/follow/*", method = RequestMethod.GET)
	public ModelAndView myPageFollow(HttpSession session) {
		modelAndView = new ModelAndView();
		modelAndView = memberService.memberFollowList(session);
		return modelAndView;
	}
}
