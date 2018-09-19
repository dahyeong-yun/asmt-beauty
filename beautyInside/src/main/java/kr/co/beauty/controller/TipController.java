package kr.co.beauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.service.TipService;

@Controller
public class TipController {
	
	@Autowired
	private TipService TipService;
	
	private ModelAndView modelAndView;
	// 팁 리스트 처리
	@RequestMapping(value="/item/tipList", method = RequestMethod.GET)
	public ModelAndView tipList(@RequestParam("MEM_ID") String MEM_ID) {
		modelAndView = new ModelAndView();
		modelAndView = TipService.tipList(MEM_ID);
		return modelAndView;
	}
}
