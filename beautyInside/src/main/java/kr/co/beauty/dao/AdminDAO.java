package kr.co.beauty.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beauty.vo.MemberVO;
@Repository
public class AdminDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//관리자 페이지에서 모든 회원리스트 보기
	public List<MemberVO> adminPageMember() {
		return sqlSession.selectList("Member.adminPageMember");
	}

}
