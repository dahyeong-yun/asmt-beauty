package kr.co.beauty.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.dao.TipDAO;
import kr.co.beauty.vo.MemberVO;
import kr.co.beauty.vo.TipVO;

@Service
public class TipService {
	
	@Autowired
	private TipDAO tipDAO;
	private MemberVO memberVO;
	
	private ModelAndView modelAndView;
	
	//팁 리스트 가져오기
	public ModelAndView tipList(HttpSession session) {
		modelAndView = new ModelAndView();
		memberVO = (MemberVO) session.getAttribute("loginMember");
		List<TipVO> list = null;
		if(!memberVO.getMEM_ID().equals("")) {
			//리스트 필터링위한 해당회원 개인정보 가져와 memberVO로 리턴
			memberVO = tipDAO.getMemberInformation(memberVO.getMEM_ID());
			//해당 회원정보 가지고 필터링 거친후 팁 리스트 가져오기
			list = tipDAO.tipList(memberVO);
		} else {
			//로그인 안하면 팁 리스트 모두 보여주기 
			list = tipDAO.tipListAll();
		}
		modelAndView.addObject("tipList", list);
		modelAndView.setViewName("tipList");
		return modelAndView;
	}
 }
