package kr.co.beauty.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.dao.LikedDAO;
import kr.co.beauty.dao.ReviewDAO;
import kr.co.beauty.vo.LikedVO;
import kr.co.beauty.vo.MemberVO;
import kr.co.beauty.vo.ReviewVO;

@Service
public class LikedService {

	@Autowired
	private ReviewDAO reviewDAO;
	
	@Autowired 
	private LikedDAO likedDAO;
	
	private ModelAndView modelAndView;
	private MemberVO memberVO;
	
	//리뷰 좋아요
		public ModelAndView reviewLikeUp(int REVIEW_ID, HttpSession session) {
			modelAndView = new ModelAndView();
			LikedVO likedVO = new LikedVO();
			memberVO = (MemberVO) session.getAttribute("loginMember");
			ReviewVO reviewVO = reviewDAO.reviewDetail(REVIEW_ID);
			likedVO.setREVIEW_ID(reviewVO.getREVIEW_ID());
			likedVO.setMEM_ID(reviewVO.getMEM_ID());
			likedVO.setTARGET_MEM_ID(memberVO.getMEM_ID());
			int result = likedDAO.insertLiked(likedVO);
			if(result==0) {
				System.out.println("좋아요 올리기 실패");
			} else {
				System.out.println("좋아요 올리기 성공");
				int LikeUp = reviewDAO.reviewLIkeUp(REVIEW_ID);
				if(LikeUp != 0) {
				modelAndView.setViewName("redirect:/item/"+reviewVO.getITEM_ID());
				}
			}
			return modelAndView;
		}
}
