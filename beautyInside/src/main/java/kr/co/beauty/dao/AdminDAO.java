package kr.co.beauty.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beauty.vo.ItemVO;
import kr.co.beauty.vo.MemberVO;
import kr.co.beauty.vo.ReviewVO;
import kr.co.beauty.vo.TipVO;

@Repository
public class AdminDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//관리자 페이지에서 모든 회원리스트 보기
	public List<MemberVO> adminPageMember() {
		return sqlSession.selectList("Member.adminPageMember");
	}

	//관리자 페이지에서 모든 제품리스트 보기
	public List<ItemVO> adminPageItem() {
		return sqlSession.selectList("Item.adminPageItem");
	}

	//관리자 페이지에서 제품 등록
	public int itemWriteForm(ItemVO itemVO) {
		return sqlSession.insert("Item.itemInsert", itemVO);
	}

	//관리자 페이지에서 모든 리뷰리스트 보기
	public List<ReviewVO> adminPageReview() {
		return sqlSession.selectList("Review.adminPageReview");
	}

	//관리자 페이지에서 모든 팁리스트 보기
	public List<TipVO> adminPageTip() {
		return sqlSession.selectList("Tip.adminPageTip");
	}
}
