package kr.co.beauty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.dao.ItemDAO;
import kr.co.beauty.dao.ReviewDAO;
import kr.co.beauty.vo.ItemVO;
import kr.co.beauty.vo.ReviewVO;

@Service
public class ReviewService {

	@Autowired
	private ReviewDAO reviewDAO;
	private ModelAndView modelAndView;
	private ReviewVO reviewVO;
	
	public ModelAndView reviewDetail(String REVIEW_ID) {
		modelAndView = new ModelAndView();
		ReviewVO reviewDetail = reviewDAO.reviewDetail(REVIEW_ID);
		modelAndView.addObject("reviewDetail", reviewDetail);
		modelAndView.setViewName("reviewDetail");
		return modelAndView;
	}

 }
