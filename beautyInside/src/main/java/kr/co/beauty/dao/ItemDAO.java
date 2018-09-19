package kr.co.beauty.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beauty.vo.MemberVO;
import kr.co.beauty.vo.TipVO;

@Repository
public class ItemDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	//팁목록 필터링 처리 위한 멤버 개인정보 가져오기
	public MemberVO getMemberInformation(String MEM_ID) {
		return sqlSession.selectOne("Item.getMemberInformation", MEM_ID);
	}
	
	//팁목록 처리
	public List<TipVO> tipList(MemberVO memberVO) {
		return sqlSession.selectList("Item.tipList", memberVO);
	}

}
