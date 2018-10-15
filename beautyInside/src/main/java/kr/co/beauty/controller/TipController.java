package kr.co.beauty.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.service.TipService;

@Controller
public class TipController {
	
	@Autowired
	private TipService TipService;
	
	@Autowired
	HttpSession session;
	
	private ModelAndView modelAndView;
	// 팁 리스트 처리
	@RequestMapping(value="/tip", method = RequestMethod.GET)
	public ModelAndView tipList(HttpSession session) {
		modelAndView = new ModelAndView();
		modelAndView = TipService.tipList(session);
		return modelAndView;
	}
}
