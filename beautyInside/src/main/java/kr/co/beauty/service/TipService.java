package kr.co.beauty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.dao.ItemDAO;
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
	public ModelAndView tipList(String MEM_ID) {
		modelAndView = new ModelAndView();
		memberVO = new MemberVO();
		
		//리스트 필터링위한 해당회원 개인정보 가져와 memberVO로 리턴
		memberVO = tipDAO.getMemberInformation(MEM_ID);
		
		//해당 회원정보 가지고 필터링 거친후 팁 리스트 가져오기
		List<TipVO> list = tipDAO.tipList(memberVO);
		modelAndView.addObject("tipList", list);
		modelAndView.setViewName("tipList");
		return modelAndView;
	}
 }
