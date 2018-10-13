package kr.co.beauty.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.dao.ItemDAO;
import kr.co.beauty.dao.MemberDAO;
import kr.co.beauty.vo.FollowVO;
import kr.co.beauty.vo.ItemVO;
import kr.co.beauty.vo.MemberVO;
import kr.co.beauty.vo.ReviewVO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	private MemberVO memberVO;
	private FollowVO followVO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	private ModelAndView modelAndView;
	
	@Autowired
	private HttpSession session;

	// 회원가입
	public ModelAndView memberJoin(MemberVO memberVO) {
		modelAndView = new ModelAndView();
		
		//MEMBER 테이블의 AGE_ID위한 처리과정
		if(memberVO.getMEM_AGE() >= 0 && memberVO.getMEM_AGE() < 20 ) {
			memberVO.setAGE_ID(1);
		} else if (memberVO.getMEM_AGE() >= 20 && memberVO.getMEM_AGE() < 30 ) {
			memberVO.setAGE_ID(2);
		} else if (memberVO.getMEM_AGE() >= 30 && memberVO.getMEM_AGE() < 40 ) {
			memberVO.setAGE_ID(3);
		} else if (memberVO.getMEM_AGE() >= 40 && memberVO.getMEM_AGE() < 50 ) {
			memberVO.setAGE_ID(4);
		} else {
			memberVO.setAGE_ID(5);
		}
		System.out.print(memberVO.getAGE_ID());
		
		int result = memberDAO.memberJoin(memberVO);
		
		// 가입 성공 여부에 따른 view 결정
		if (result == 0) {
			modelAndView.setViewName("joinMember"); // 가입 실패
		} else {
			modelAndView.setViewName("redirect:/main"); // 가입 성공
		}
		return modelAndView;
	}
	
	// 로그인
	public ModelAndView memberLogin(MemberVO memberVO, HttpServletResponse response) throws IOException {
		modelAndView = new ModelAndView();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String idNullCheck = memberDAO.idNullCheck(memberVO);
		MemberVO loginMember = memberDAO.memberLogin(memberVO);
		
		if(idNullCheck == null) {
			out.println("<script>");
			out.println("alert('없는 아이디!');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}else {
			if (memberVO.getMEM_PW().equals(loginMember.getMEM_PW())) {
				session.setAttribute("loginMember", loginMember);
				modelAndView.setViewName("redirect:/main");
			} else {
				// 로그인 실패 alert
				out.println("<script>");
				out.println("alert('비밀번호가 틀립니다.');");
				out.println("history.go(-1);");
				out.println("</script>");
				out.close();
			}
		}
		return modelAndView;
	}

	// 마이페이지 인증 기능
	public ModelAndView memberInfoAuth(String MEM_ID, String MEM_PW) {
		modelAndView = new ModelAndView();
		memberVO = new MemberVO();

		memberVO.setMEM_ID(MEM_ID);
		memberVO.setMEM_PW(MEM_PW);
		
		MemberVO authMember = memberDAO.memberInfoAuth(memberVO);
		
		if(authMember.getMEM_ID().equals(memberVO.getMEM_ID())) {
			modelAndView.setViewName("myPageRevision");
			session.setAttribute("loginMember", authMember);
		} else {
			modelAndView.setViewName("myPageAuth");
		}
		return modelAndView;
	}

	// 마이페이지 개인정보 수정 기능
	public ModelAndView memberRevise(MemberVO memberVO) {
		modelAndView = new ModelAndView();
		int result = memberDAO.memberRevise(memberVO);
		
		if (result == 0) {
			modelAndView.setViewName("joinMember"); // 변경 실패시
		} else {
			modelAndView.setViewName("main"); // 변경 성공 시
		}
		
		return modelAndView;
	}

	// 마이페이지 팔로우,팔로워 리스트
	public ModelAndView memberFollowList(String MEM_ID, HttpSession session) {
		modelAndView = new ModelAndView();
		memberVO = (MemberVO) session.getAttribute("loginMember");
		
		// 본인 계정의 팔로우,팔로워 리스트 접근시
		if(memberVO.getMEM_ID().equals(MEM_ID)) {
			List<MemberVO> followerList = memberDAO.memberFollowerList(memberVO);
			List<MemberVO> followingList = memberDAO.memberFollowingList(memberVO);
			session.setAttribute("followerList", followerList);
			session.setAttribute("followingList", followingList);
			modelAndView.setViewName("myPageFollow");	
		} else { // 타인 계정의 팔로우,팔로워 리스트 접근시
			modelAndView.addObject("otherMemberID", MEM_ID);
			modelAndView.setViewName("otherPageAuth");
		}
		
		return modelAndView;
	}

	
	// 아이디 중복 체크
	public void idOverlap(String MEM_ID, HttpServletResponse response) throws IOException {
		memberVO = new MemberVO();
		memberVO = memberDAO.idOverlap(MEM_ID);
		if(memberVO == null) {
			response.getWriter().print("1");
			
		} else {
			response.getWriter().print("0");
		}
	}

	//마이페이지 내가 찜한 목록
	public ModelAndView memberStoredItemList(String MEM_ID) {
		modelAndView = new ModelAndView();
		List<ItemVO> memberStoredList = itemDAO.memberStoredItemList(MEM_ID);
		modelAndView.addObject("memberStoredList", memberStoredList);
		modelAndView.setViewName("myPageItemStored");
		return modelAndView;
	}

	// 회원 탈퇴
	public void memberDrop(String MEM_ID) {
		memberDAO.memberDrop(MEM_ID);
	}

	// 팔로우
	public ModelAndView memberFollow(HttpServletResponse response, String MEM_ID, String TARGET_MEM_ID) throws IOException {
		// followVO 인스턴스 생성
		followVO = new FollowVO();
		followVO.setMEM_ID(MEM_ID);
		followVO.setTARGET_MEM_ID(TARGET_MEM_ID);
		int result = memberDAO.memberfollow(followVO);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (result == 0) { // 팔로우 성공 여부 검증
			out.println("<script>");
			out.println("alert('팔로우 실패');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close(); // 팔로우 실패시
		} else {
			modelAndView.setViewName("otherPageReviewWrote"); // 팔로우 성공 시
		}
		
		return modelAndView;
	
	}

	// 언팔로우
	public void memberUnFollow(String MEM_ID, String TARGET_MEM_ID) {
		followVO = new FollowVO();
		followVO.setMEM_ID(MEM_ID);
		followVO.setTARGET_MEM_ID(TARGET_MEM_ID);
		memberDAO.memberUnfollow(followVO);
		
		
	}

	
	//마이 페이지 내가 쓴 리뷰 페이지
	public ModelAndView myPageReviewLists(String MEM_ID) {
		modelAndView = new ModelAndView();
		List<ReviewVO> reviewLists = memberDAO.myPageReviewLists(MEM_ID);
		modelAndView.addObject("reviewLists", reviewLists);
		modelAndView.setViewName("myPageReviewWrote");
		return modelAndView;
	}

}
