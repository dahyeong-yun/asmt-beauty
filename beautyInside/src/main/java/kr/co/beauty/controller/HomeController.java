package kr.co.beauty.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.service.ItemService;
import kr.co.beauty.vo.MemberVO;

@Controller
public class HomeController {
	
	private ModelAndView modelAndView;
	private MemberVO memberVO;
	
	@Autowired
	private ItemService itemService;
	
	
	// 시작 페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String first() {
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(HttpSession session) {
		modelAndView = new ModelAndView();
		
		memberVO = (MemberVO) session.getAttribute("loginMember");

		/** 광고리스트*/
		
		
		/** 메인 제품 리스트 */
		// 로그인 안했을 경우
		if(memberVO == null) {
			// 인기 제품 4가지
			modelAndView = itemService.trendItems();
		} // 로그인 했을 경우 
		else {
			// 추천 제품 4가지
			modelAndView = itemService.personalRecommandItems(memberVO.getMEM_ID());
		}
		
		modelAndView.setViewName("main");
		
		return modelAndView;
	}
	
}
 