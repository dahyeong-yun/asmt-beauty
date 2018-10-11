package kr.co.beauty.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "redirect:/main";
	}
	
	// (page link) 마이페이지_인증 페이지
	@RequestMapping(value = "/member/info/{MEM_ID}", method = RequestMethod.GET)
	public String myPageAuth() {
		return "myPageAuth";
	}
	
	// 마이페이지_인증 페이지 : 인증 기능
	@RequestMapping(value = "/member/info/auth/{MEM_ID}", method = RequestMethod.POST)
	public ModelAndView myPageRevision(@RequestParam("AUTH_MEM_PW") String MEM_PW, @PathVariable("MEM_ID") String MEM_ID) {
		modelAndView = new ModelAndView();
		modelAndView = memberService.memberInfoAuth(MEM_ID, MEM_PW);
		return modelAndView;
	}
	
	// 마이페이지_개인정보 수정  기능 
	@RequestMapping(value = "/member/revision/*", method = RequestMethod.POST)
	public ModelAndView myInfoRivesion(@ModelAttribute MemberVO memberVO) {
		modelAndView = new ModelAndView();
		modelAndView = memberService.memberRevise(memberVO);
		
		return modelAndView;
	}
	
	// 마이페이지_회원 탈퇴 
	@RequestMapping(value = "/member/{MEM_ID}", method = RequestMethod.DELETE)
	public String myPageMemberDrop(@PathVariable String MEM_ID) {
		memberService.memberDrop(MEM_ID);
		session.invalidate();
		return "main";
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
	
	// 마이페이지_제품 찜 목록
	@RequestMapping(value = "/member/stored/{MEM_ID}", method = RequestMethod.GET)
	public ModelAndView myPageItemStored(@PathVariable("MEM_ID") String MEM_ID) {
		modelAndView = new ModelAndView();
		modelAndView = memberService.memberStoredItemList(MEM_ID);
		return modelAndView;
	}
	
	// 마이페이지/Other페이지_팔로워/팔로잉 페이지
	@RequestMapping(value = "/member/follow/{MEM_ID}", method = RequestMethod.GET)
	public ModelAndView followPage(@PathVariable("MEM_ID") String MEM_ID, HttpSession session) {
		modelAndView = new ModelAndView();
		modelAndView = memberService.memberFollowList(MEM_ID, session);
		return modelAndView;
	}
	
	// 팔로우 하기 기능
	@RequestMapping(value = "/member/follow/doFollow/{MEM_ID}", method = RequestMethod.GET)
	public ModelAndView follow(@PathVariable("MEM_ID") String MEM_ID, HttpSession session) {
		modelAndView = new ModelAndView();
		return modelAndView; // 팔로우 시 팔로우 여부 검증 후, 팔로우 성공-> 리뷰 리스트로 이동 혹은 alert메세지 -> 
	}
	
}
