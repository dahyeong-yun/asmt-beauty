package kr.co.beauty.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beauty.vo.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public MemberVO memberLogin(MemberVO memberVO) {
		return sqlSession.selectOne("Member.memberLogin", memberVO);
	}

	public int memberJoin(MemberVO memberVO) {
		return sqlSession.insert("Member.memberJoin", memberVO);
	}

	public MemberVO memberInfoAuth(MemberVO memberVO) {
		return sqlSession.selectOne("Member.memberInfoAuth", memberVO);
	}
}
