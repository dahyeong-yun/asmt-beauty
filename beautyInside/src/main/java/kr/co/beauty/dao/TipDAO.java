package kr.co.beauty.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beauty.vo.MemberVO;
import kr.co.beauty.vo.TipVO;

@Repository
public class TipDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
 	//팁목록 필터링 처리 위한 멤버 개인정보 가져오기
	public MemberVO getMemberInformation(String MEM_ID) {
		return sqlSession.selectOne("Tip.getMemberInformation", MEM_ID);
	}
	
	//팁목록 처리
	public List<TipVO> tipList(MemberVO memberVO) {
		return sqlSession.selectList("Tip.tipList", memberVO);
	}

	//로그인 안하고 팁리스트 클릭스 모든 팁리스트 띄우기
	public List<TipVO> tipListAll() {
		return sqlSession.selectList("Tip.tipListAll");
	}
	
	// 전테 팁 갯수 세기
	public int tipCountAll() {
		return sqlSession.selectOne("Tip.tipCountAll");
	}
}
