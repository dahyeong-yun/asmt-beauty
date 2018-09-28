package kr.co.beauty.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.dao.MemberDAO;
import kr.co.beauty.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	private ModelAndView modelAndView;
	private MemberVO memberVO;
	
	@Autowired
	private HttpSession session;

	// 회원가입
	public ModelAndView memberJoin(MemberVO memberVO) {
		modelAndView = new ModelAndView();
		int result = memberDAO.memberJoin(memberVO);
		
		// 가입 성공 여부에 따른 view 결정
		if (result == 0) {
			modelAndView.setViewName("joinMember");

		} else {
			modelAndView.setViewName("main");
		}
		return modelAndView;
	}
	
	// 로그인
	public ModelAndView memberLogin(MemberVO memberVO, HttpServletResponse response) throws IOException {
		modelAndView = new ModelAndView();
		response.setContentType("text/html; charset=UTF-8");
		
		MemberVO loginMember = memberDAO.memberLogin(memberVO);
		PrintWriter out = response.getWriter();
		
		if (memberVO.getMEM_PW().equals(loginMember.getMEM_PW())) {
			session.setAttribute("loginMember", loginMember);
			modelAndView.setViewName("main");
		} else {
			// 로그인 실패 alert
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		}
		return modelAndView;
	}

	// 마이페이지 인증 기능
	public ModelAndView memberInfoAuth(String password, HttpSession session) {
		modelAndView = new ModelAndView();
		
		memberVO = new MemberVO();
		
		//this.session = session;
		String mEM_ID = (String) session.getAttribute("session_id");
		memberVO.setMEM_ID(mEM_ID);
		memberVO.setMEM_PW(password);
		
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

	public ModelAndView memberFollowList(HttpSession session) {
		modelAndView = new ModelAndView();
		memberVO = (MemberVO) session.getAttribute("loginMember");
		
		List<MemberVO> followerList = memberDAO.memberFollowerList(memberVO);
		List<MemberVO> followingList = memberDAO.memberFollowingList(memberVO);
		
		session.setAttribute("followerList", followerList);
		session.setAttribute("followingList", followingList);
		
		modelAndView.setViewName("myPageFollow");
		
		return modelAndView;
	}

	public void idOverlap(String MEM_ID, HttpServletResponse response) throws IOException {
		memberVO = new MemberVO();
		memberVO = memberDAO.idOverlap(MEM_ID);
		if(memberVO == null) {
			response.getWriter().print("1");
			
		} else {
			response.getWriter().print("0");
		}
	}

}
