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
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.service.AdminService;
import kr.co.beauty.vo.ItemVO;
import kr.co.beauty.vo.MemberVO;




@Controller
public class AdminController {
	
	private ModelAndView modelAndView;
	@Autowired
	private AdminService adminService;

	@Autowired
	HttpSession session;

	// (page link) 관리자 전용 페이지 대쉬보드
	@RequestMapping(value = "/adminPage/dashboard", method = RequestMethod.GET)
	public String adminPageDashboard() {
		return "adminPageDashboard";
	}
	
	// 관리자 전용 페이지 회원 관리
	@RequestMapping(value = "/adminPage/member", method = RequestMethod.GET)
	public ModelAndView adminPageMember() {
		modelAndView = new ModelAndView();
		modelAndView = adminService.adminPageMember();
		return modelAndView;
	}
	
	// 관리자 전용 페이지 제품 관리
	@RequestMapping(value = "/adminPage/item", method = RequestMethod.GET)
	public ModelAndView adminPageItem() {
		modelAndView = new ModelAndView();
		modelAndView = adminService.adminPageItem();
		return modelAndView;
	}
	
	// (page link) 관리자 전용 페이지 제품 작성폼으로 이동
	@RequestMapping(value = "/adminPage/itemWrite", method = RequestMethod.GET)
	public String adminPageItemWrite() {
		return "adminPageItemWrite";
	}
	
	// 관리자 페이지 제품 수정 폼으로 이동(제품 정보 DB들려서 보여줌)
	@RequestMapping(value = "/adminPage/itemModify/{ITEM_ID}", method = RequestMethod.GET)
	public ModelAndView itemModify(@PathVariable("ITEM_ID") int ITEM_ID) {
		modelAndView = new ModelAndView();
		modelAndView = adminService.itemModify(ITEM_ID);
		return modelAndView;
	}
	
	// 관리자 페이지 제품 수정
	@RequestMapping(value = "/adminPage/itemModifyForm", method = RequestMethod.POST)
	public ModelAndView itemModifyForm(@ModelAttribute ItemVO itemVO) {
		modelAndView = new ModelAndView();
		modelAndView = adminService.itemModifyForm(itemVO);
		return modelAndView;
	}
	
	// 관리자전용 페이지 제품 등록
	@RequestMapping(value = "/adminPage/itemWriteForm", method = RequestMethod.POST)
	public ModelAndView itemWriteForm(@ModelAttribute ItemVO itemVO) {
		modelAndView = new ModelAndView();
		modelAndView = adminService.itemWriteForm(itemVO);
		return modelAndView;
	}
	
	// 관리자전용 페이지 제품 삭제
	@RequestMapping(value ="/adminPage/itemDelete/{ITEM_ID}", method = RequestMethod.GET)
	public ModelAndView itemDelete(@PathVariable("ITEM_ID") int ITEM_ID, HttpServletResponse response) throws IOException {
		modelAndView = new ModelAndView();
		modelAndView = adminService.itemDelete(ITEM_ID, response);
		return modelAndView;
	}
	
	// 관리자 전용 페이지 팁 관리
	@RequestMapping(value = "/adminPage/tip", method = RequestMethod.GET)
	public ModelAndView adminPageTip() {
		modelAndView = new ModelAndView();
		modelAndView = adminService.adminPageTip();
		return modelAndView;
	}
	
	// 관리자 전용 페이지 리뷰 관리
	@RequestMapping(value = "/adminPage/review", method = RequestMethod.GET)
	public ModelAndView adminPageReview() {
		modelAndView = new ModelAndView();
		modelAndView = adminService.adminPageReview();
		return modelAndView;
	}
	

	// (page link) 관리자 전용 페이지 광고 관리
	@RequestMapping(value = "/adminPage/ads", method = RequestMethod.GET)
	public String adminPageAds() {
		return "adminPageAd";
	}
	

}
