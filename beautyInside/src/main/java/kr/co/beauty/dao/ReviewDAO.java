package kr.co.beauty.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.vo.LikedVO;
import kr.co.beauty.vo.ReviewVO;

@Repository
public class ReviewDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 리뷰 리스트 검색
	public List<ReviewVO> reviewList(int ITEM_ID) {
		return sqlSession.selectList("Review.reviewList", ITEM_ID);
	}

	// 리뷰 상세 보기
	public ReviewVO reviewDetail(int REVIEW_ID) {
		return sqlSession.selectOne("Review.reviewDetail", REVIEW_ID);
	}

	// 리뷰 작성 기능
	public int reviewWrite(ReviewVO reviewVO) {
		return sqlSession.insert("Review.reviewWrite", reviewVO);
	}
	// 리뷰 좋아요 리뷰테이블 좋아요수 올리기
	public int reviewLikeUp(int REVIEW_ID) {
		return sqlSession.update("Review.reviewLikeUp", REVIEW_ID);
	}

	// 라이크 테이블 타겟 아이디 얻기
	public String getTargetId(int REVIEW_ID) {
		return sqlSession.selectOne("Liked.getTargetId", REVIEW_ID);
	}

	
	// 리뷰 좋아요 리뷰테이블 좋아요수 내리기
	public int reviewLikeDown(int REVIEW_ID) {
		return sqlSession.update("Review.reviewLikeDown", REVIEW_ID);
	}

}
