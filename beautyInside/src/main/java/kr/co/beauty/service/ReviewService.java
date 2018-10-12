package kr.co.beauty.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.dao.ItemDAO;
import kr.co.beauty.dao.ReviewDAO;
import kr.co.beauty.vo.ItemVO;
import kr.co.beauty.vo.LikedVO;
import kr.co.beauty.vo.MemberVO;
import kr.co.beauty.vo.ReviewVO;

@Service
public class ReviewService {

	@Autowired
	private ReviewDAO reviewDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	@Autowired
	private HttpSession session;
	
	private ModelAndView modelAndView;
	private ItemVO itemVO;
	private MemberVO memberVO;
	
	public ModelAndView reviewDetail(int REVIEW_ID) {
		modelAndView = new ModelAndView();
		ReviewVO reviewDetail = reviewDAO.reviewDetail(REVIEW_ID);
		modelAndView.addObject("reviewDetail", reviewDetail);
		modelAndView.setViewName("reviewDetail");
		return modelAndView;
	}

	public ModelAndView infoForReviewWrite(int ITEM_ID) {
		modelAndView = new ModelAndView();
		itemVO = itemDAO.itemDetail(ITEM_ID);
		modelAndView.addObject("itemRelatedThisReview", itemVO);
		modelAndView.setViewName("reviewWrite");
		return modelAndView;
	}

	
	public void reviewWrite(int ITEM_ID, ReviewVO reviewVO) {
		
		int result = reviewDAO.reviewWrite(reviewVO);
		if(result==0) {
			System.out.println("리뷰 등록 실패");
		} else {
			System.out.println("리뷰 등록 성공");
		}
	}
 }
