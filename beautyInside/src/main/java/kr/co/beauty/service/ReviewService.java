package kr.co.beauty.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.dao.ItemDAO;
import kr.co.beauty.dao.ReviewDAO;
import kr.co.beauty.vo.ItemVO;
import kr.co.beauty.vo.MemberVO;
import kr.co.beauty.vo.ReviewVO;

@Service
public class ReviewService {

	@Autowired
	private ReviewDAO reviewDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	private ModelAndView modelAndView;
	private ItemVO itemVO;
	private MemberVO memberVO;
	private ReviewVO reviewVO;
	
	
	//리뷰 상세 페이지
	public ModelAndView reviewDetail(int REVIEW_ID, HttpSession session) {
		modelAndView = new ModelAndView();
		memberVO = (MemberVO) session.getAttribute("loginMember");
		//target_mem_id 값 얻기
		String TARGET_MEM_ID = reviewDAO.getTargetId(REVIEW_ID);
		String check = null;
		if(TARGET_MEM_ID == null) {
			check = "A";
		} else if(TARGET_MEM_ID.equals(memberVO.getMEM_ID())) {
			check = "B";		
			} 
		ReviewVO reviewDetail = reviewDAO.reviewDetail(REVIEW_ID);
		modelAndView.addObject("reviewDetail", reviewDetail);
		modelAndView.addObject("check", check);
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

	public ModelAndView reviewModifyPage(int REVIEW_ID) {
		modelAndView = new ModelAndView();
		reviewVO = reviewDAO.reviewDetail(REVIEW_ID);
		modelAndView.addObject("modify", reviewVO);
		modelAndView.setViewName("reviewModify");
		return modelAndView;
	}

	public void reviewModify(ReviewVO reviewVO) {
		int result = reviewDAO.reviewModify(reviewVO);
		if(result==0) {
			System.out.println("리뷰 수정 실패");
		} else {
			System.out.println("리뷰 수정 성공");
		}
	}

	public ModelAndView reviewDelete(int REVIEW_ID) {
		modelAndView = new ModelAndView();
		reviewVO = new ReviewVO();
		reviewVO = reviewDAO.reviewDetail(REVIEW_ID);
		int result = reviewDAO.reviewDelete(REVIEW_ID);
		if(result==0) {
			System.out.println("리뷰 삭제 실패");
		} else {
			modelAndView.setViewName("redirect:/item/"+reviewVO.getITEM_ID());
			System.out.println("리뷰 삭제 성공");
		}
		return modelAndView;
	}
 }
