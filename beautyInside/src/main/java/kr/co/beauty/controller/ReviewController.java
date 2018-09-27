package kr.co.beauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.service.ItemService;
import kr.co.beauty.service.ReviewService;
import kr.co.beauty.vo.ItemVO;
import kr.co.beauty.vo.ReviewVO;

@Controller
@RequestMapping(value = "/review")
public class ReviewController {
	
	private ModelAndView modelAndView;
	
	@Autowired
	private ReviewService reviewService;
	
	// 리뷰 상세 보기
	@RequestMapping(value = "/{REVIEW_ID}", method = RequestMethod.GET)
	public ModelAndView itemSearch(@PathVariable("REVIEW_ID") String REVIEW_ID) {
		modelAndView = new ModelAndView();
		modelAndView = reviewService.reviewDetail(REVIEW_ID);
		return modelAndView;
	}
	
	// 리뷰 작성 페이지
}
