package kr.co.beauty.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beauty.vo.ItemVO;
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
	public ReviewVO reviewDetail(String REVIEW_ID) {
		return sqlSession.selectOne("Review.reviewDetail", REVIEW_ID);
	}

	// 리뷰 작성 기능
	public int reviewWrite(ReviewVO reviewVO) {
		return sqlSession.insert("Review.reviewWrite", reviewVO);
	}

}
