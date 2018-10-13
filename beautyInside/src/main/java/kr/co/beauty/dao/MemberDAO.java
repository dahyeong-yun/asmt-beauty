package kr.co.beauty.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beauty.vo.FollowVO;
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

	public int memberRevise(MemberVO memberVO) {
		return sqlSession.update("Member.memberInfoRevise", memberVO);
	}

	// 팔로워 목록 (나를 팔로우 하는 사람)
	public List<MemberVO> memberFollowerList(MemberVO memberVO) {
		return sqlSession.selectList("Member.memberFollowerList", memberVO);
	}
	
	// 팔로잉 목록(내가 팔로우 하고 있는 사람) 
	public List<MemberVO> memberFollowingList(MemberVO memberVO) {
		return sqlSession.selectList("Member.memberFollowingList", memberVO);
	}

	// 아이디 중복체크
	public MemberVO idOverlap(String MEM_ID) {
		return sqlSession.selectOne("Member.idOverlap", MEM_ID);
	}

	// 로그인시 없는 아이디 체크
	public String idNullCheck(MemberVO memberVO) {
		return sqlSession.selectOne("Member.idNullCheck", memberVO);
	}

	// 회원 탈퇴
	public void memberDrop(String MEM_ID) {
		sqlSession.delete("Member.memberDrop", MEM_ID);
	}

	// 언팔로우
	public void memberUnfollow(FollowVO followVO) {
		sqlSession.delete("Member.memberUnfollow", followVO);
		
	}

	// 팔로우
	public int memberfollow(FollowVO followVO) {
		return sqlSession.insert("Member.memberFollow", followVO);
	}
	
	// 포인트 증가
	public void memberPlusPoint(MemberVO memberVO) {
		sqlSession.update("Member.memberPlusPoint", memberVO);
	}
	
	// 회원 등급 상승
	public void memberUpgrade(MemberVO memberVO) {
		sqlSession.update("Member.memberUpgrade", memberVO);
		
	}
	

}
