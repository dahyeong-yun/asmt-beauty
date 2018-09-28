package kr.co.beauty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.dao.AdminDAO;
import kr.co.beauty.vo.MemberVO;

@Service
public class AdminService {
	@Autowired
	private AdminDAO adminDAO;
	private ModelAndView modelAndView;
	
	//관리자 페이지에서 멤버 리스트
	public ModelAndView adminPageMember() {
		modelAndView = new ModelAndView();
		List<MemberVO> AllMembers = adminDAO.adminPageMember();
		modelAndView.addObject("AllMembers", AllMembers);
		modelAndView.setViewName("adminPageMember");
		return modelAndView;
	}

}
