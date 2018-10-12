package kr.co.beauty.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beauty.vo.LikedVO;

@Repository
public class LikedDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	// 리뷰 좋아요 테이블 삽입
	public int insertLiked(LikedVO likedVO) {
		return sqlSession.insert("Liked.insertLiked", likedVO);
	}


	// 리뷰 좋아요 내리기
	public int reviewLikeDown(String MEM_ID) {
		return sqlSession.delete("Liked.likeDown", MEM_ID);
	}
}
