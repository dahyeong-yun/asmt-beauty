package kr.co.beauty.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.service.LikedService;

@Controller
@RequestMapping(value = "/liked")
public class LikedController {

	private ModelAndView modelAndView;
	
	@Autowired
	private LikedService likedService;
	
	@Autowired
	HttpSession session;
	
	// 리뷰 좋아요
	@GetMapping(value = "/{REVIEW_ID}")
	public ModelAndView reviewLikeUp(@PathVariable("REVIEW_ID") int REVIEW_ID, HttpSession session) {
		modelAndView = new ModelAndView();
		modelAndView = likedService.reviewLikeUp(REVIEW_ID, session);
		return modelAndView;
	}
	
	// 리뷰 좋아요 취소
	@DeleteMapping(value = "/{REVIEW_ID}")
	public ModelAndView reviewLikeDown(@PathVariable("REVIEW_ID") int REVIEW_ID, HttpSession session) {
		modelAndView = new ModelAndView();
		modelAndView = likedService.reviewLikeDown(REVIEW_ID, session);
		return modelAndView;
	}
}
