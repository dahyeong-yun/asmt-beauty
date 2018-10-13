package kr.co.beauty.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beauty.vo.FollowVO;
import kr.co.beauty.vo.MemberVO;
import kr.co.beauty.vo.ReviewVO;

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

	public int memberfollow(FollowVO followVO) {
		return sqlSession.insert("Member.memberFollow", followVO);
	}

	// 마이페이지 내가 작성한 리뷰 리스트
	public List<ReviewVO> myPageReviewLists(String MEM_ID) {
		return sqlSession.selectList("Review.myPageReviewLists", MEM_ID);
	}

	// 마이페이지 내가 좋아요한 리뷰 위한 리뷰 아이디값 얻기
	public int getReviewIdFromLiked(String MEM_ID) {
		return sqlSession.selectOne("Liked.getReviewId", MEM_ID);
	}

	// 마이 페이지 내가 좋아요한 리뷰 리스트
	public List<ReviewVO> myPageReviewLiked(int REVIEW_ID) {
		return sqlSession.selectList("Review.myPageReviewLiked", REVIEW_ID);
	}

}
