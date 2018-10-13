package kr.co.beauty.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.service.ReviewService;
import kr.co.beauty.vo.ReviewVO;

@Controller
@RequestMapping(value = "/review")
public class ReviewController {
	
	private ModelAndView modelAndView;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	HttpSession session;
	
	// 리뷰 상세 보기
	@RequestMapping(value = "/{REVIEW_ID}", method = RequestMethod.GET)
	public ModelAndView reviewDetail(@PathVariable("REVIEW_ID") int REVIEW_ID, HttpSession session) {
		modelAndView = new ModelAndView();
		modelAndView = reviewService.reviewDetail(REVIEW_ID ,session);
		return modelAndView;
	}
	
	// (page link) 리뷰 작성 페이지
	@GetMapping(value = "/write/{ITEM_ID}")
	public ModelAndView reviewWritePage(@PathVariable("ITEM_ID") int ITEM_ID) {
		modelAndView = new ModelAndView();
		modelAndView = reviewService.infoForReviewWrite(ITEM_ID);
		return modelAndView;
	}
	
	// 리뷰 작성 기능
	@PostMapping(value = "/write/{ITEM_ID}")
	public String reviewWrite(@PathVariable("ITEM_ID") int ITEM_ID, @ModelAttribute ReviewVO reviewVO) {
		reviewVO.setITEM_ID(ITEM_ID);
		reviewService.reviewWrite(ITEM_ID, reviewVO);
		return "redirect:/item/"+ITEM_ID; // 리뷰 등록 후 리다이렉트 -> 아이템 상세페이지로
	}
	
	// (page link) 리뷰 수정 페이지
	@GetMapping(value = "/modify/{REVIEW_ID}")
	public ModelAndView reviewModifyPage(@PathVariable("REVIEW_ID") int REVIEW_ID) {
		modelAndView = new ModelAndView();
		reviewService.reviewModifyPage(REVIEW_ID);
		return modelAndView;
	}
	
	// 리뷰 수정 기능
	@PutMapping(value = "/{REVIEW_ID}")
	public String reviewModify(@PathVariable("REVIEW_ID")int REVIEW_ID, @ModelAttribute ReviewVO reviewVO) {
		reviewVO.setREVIEW_ID(REVIEW_ID);
		reviewService.reviewModify(reviewVO);
		return "redirect:/item/"+reviewVO.getITEM_ID(); // 리뷰 수정 후 리다이렉트 -> 아이템 상세페이지로
	}
	
	//리뷰 삭제 기능
	@DeleteMapping(value = "/{REVIEW_ID}")
	public ModelAndView reviewDelete(@PathVariable("REVIEW_ID") int REVIEW_ID) {
		modelAndView = new ModelAndView();
		modelAndView = reviewService.reviewDelete(REVIEW_ID);
		return modelAndView;
	}
}
