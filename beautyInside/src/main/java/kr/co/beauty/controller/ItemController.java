package kr.co.beauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.service.ItemService;
import kr.co.beauty.vo.ItemVO;

@Controller
public class ItemController {
	
	private ModelAndView modelAndView;
	@Autowired
	private ItemService itemService;
	
	// 아이템 검색 기능
	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public ModelAndView itemSearch(@ModelAttribute ItemVO itemVO) {
		modelAndView = new ModelAndView();
		modelAndView = itemService.itemSearch(itemVO);		
		return modelAndView;
	}
}
