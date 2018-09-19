package kr.co.beauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	private ModelAndView modelAndView;
	//팁 리스트 처리
	@RequestMapping(value="/item/tipList", method = RequestMethod.GET)
	public ModelAndView tipList(@RequestParam("MEM_ID") String MEM_ID) {
		modelAndView = new ModelAndView();
		modelAndView = itemService.tipList(MEM_ID);
		return modelAndView;
	}
	
}
