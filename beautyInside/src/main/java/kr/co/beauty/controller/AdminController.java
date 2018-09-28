package kr.co.beauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.service.AdminService;
import kr.co.beauty.vo.ItemVO;




@Controller
public class AdminController {
	
	private ModelAndView modelAndView;
	@Autowired
	private AdminService adminService;


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
	
	// 관리자전용 페이지 제품 등록
	@RequestMapping(value = "/adminPage/itemWriteForm", method = RequestMethod.POST)
	public ModelAndView itemWriteForm(@ModelAttribute ItemVO itemVO) {
		modelAndView = new ModelAndView();
		modelAndView = adminService.itemWriteForm(itemVO);
		return modelAndView;
	}
	
	// (page link) 관리자 전용 페이지 팁 관리
	@RequestMapping(value = "/adminPage/tip", method = RequestMethod.GET)
	public String adminPageTip() {
		return "adminPageTip";
	}
	
	// (page link) 관리자 전용 페이지 리뷰 관리
	@RequestMapping(value = "/adminPage/review", method = RequestMethod.GET)
	public String adminPageReview() {
		return "adminPageReview";
	}
	
	// (page link) 관리자 전용 페이지 제품 작성폼
}
