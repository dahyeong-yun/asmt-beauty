package kr.co.beauty.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.dao.AdminDAO;
import kr.co.beauty.vo.ItemVO;
import kr.co.beauty.vo.MemberVO;
import kr.co.beauty.vo.ReviewVO;
import kr.co.beauty.vo.TipVO;

@Service
public class AdminService {
	@Autowired
	private AdminDAO adminDAO;
	private ModelAndView modelAndView;
	
	private ItemVO itemVO;
	//관리자 페이지에서 멤버 리스트
	public ModelAndView adminPageMember() {
		modelAndView = new ModelAndView();
		List<MemberVO> allMembers = adminDAO.adminPageMember();
		modelAndView.addObject("allMembers", allMembers);
		modelAndView.setViewName("adminPageMember");
		return modelAndView;
	}

	//관리자페이지 제품 리스트
	public ModelAndView adminPageItem() {
		modelAndView = new ModelAndView();
		List<ItemVO> allItems = adminDAO.adminPageItem();
		modelAndView.addObject("allItems", allItems);
		modelAndView.setViewName("adminPageItem");
		return modelAndView;
	}
	
	//관리자 페이지 제품 등록
	public ModelAndView itemWriteForm(ItemVO itemVO) {
		modelAndView = new ModelAndView();
		int result = adminDAO.itemWriteForm(itemVO);
		
		//제품 등록 성공 여부에 따른 view 설정
		if (result == 0) {
			modelAndView.setViewName("main");
		} else {
			modelAndView.setViewName("redirect:/adminPage/item");
		}
		return modelAndView;
	}

	//관리자 페이지 리뷰 리스트
	public ModelAndView adminPageReview() {
		modelAndView = new ModelAndView();
		List<ReviewVO> allReviews = adminDAO.adminPageReview();
		modelAndView.addObject("allReviews", allReviews);
		modelAndView.setViewName("adminPageReview");
		return modelAndView;
	}

	//관리자 페이지 팁 리스트
	public ModelAndView adminPageTip() {
		modelAndView = new ModelAndView();
		List<TipVO> allTips = adminDAO.adminPageTip();
		modelAndView.addObject("allTips", allTips);
		modelAndView.setViewName("adminPageTip");
		return modelAndView;
	}

	//관리자 페이지 제품 삭제
	public ModelAndView itemDelete(int ITEM_ID, HttpServletResponse response) throws IOException {
		modelAndView = new ModelAndView();
		PrintWriter out = response.getWriter();
		int result = adminDAO.itemDelete(ITEM_ID);
		
		if (result == 0) {
			//삭제 실패시
			out.println("<script>");
			out.println("alert('삭제실패!');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close(); 
		} else {
			//삭제 성공시
			modelAndView.setViewName("redirect:/adminPage/item"); 
		}
		return modelAndView;
	}
	
	//관리자 페이지 제품 수정폼으로 제품정보 띄우기
	public ModelAndView itemModify(int ITEM_ID) {
		modelAndView = new ModelAndView();
		ItemVO itemInfoModify = adminDAO.itemModify(ITEM_ID);
		if(itemInfoModify != null) {
			modelAndView.addObject("itemInfoModify",itemInfoModify);
			modelAndView.setViewName("adminPageModification");
		}
		return modelAndView;
	}

	//관리자 페이지 제품 수정
	public ModelAndView itemModifyForm(ItemVO itemVO) {
		modelAndView = new ModelAndView();
		int result = adminDAO.itemModifyForm(itemVO);
		if (result != 0) {
			modelAndView.setViewName("main"); // 변경 성공 시
		} 
		return modelAndView;
	}
}
