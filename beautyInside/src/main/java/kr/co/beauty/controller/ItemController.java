package kr.co.beauty.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.service.ItemService;
import kr.co.beauty.vo.ItemVO;
import kr.co.beauty.vo.PaymentVO;

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
	
	// 아이템 상세 페이지
	@RequestMapping(value = "/item/{ITEM_ID}", method = RequestMethod.GET)
	public ModelAndView itemDetail(@PathVariable("ITEM_ID") int ITEM_ID) {
		modelAndView = new ModelAndView();
		modelAndView = itemService.itemDetail(ITEM_ID);		
		return modelAndView;
	}
	
	// 아이템 찜하기(아이템 상세 페이지 내)
	@RequestMapping(value = "/item/stored/{ITEM_ID}", method = RequestMethod.POST)
	public void itemStore(@PathVariable("ITEM_ID") int ITEM_ID, @RequestParam("MEM_ID") String MEM_ID,  HttpServletResponse response) throws IOException {
		System.out.println("::::::::::::::::"+ITEM_ID);
		itemService.itemStore(response, ITEM_ID, MEM_ID);		
	}
	
	//구매하기(결제 폼으로 이동)
	@RequestMapping(value = "/item/payment", method = RequestMethod.POST)
	public ModelAndView itemPayment(@ModelAttribute PaymentVO paymentVO){
		modelAndView = new ModelAndView();
		modelAndView = itemService.itemInfo(paymentVO);
		return modelAndView;
	}
	
	@RequestMapping(value = "/item/basketPage", method = RequestMethod.GET)
	public String basketPage() {
		return "basketPage";
	}
	
	//결제완료
	@RequestMapping(value = "/item/payment/complete", method = RequestMethod.POST)
	public ModelAndView itemPaymentComplete(@ModelAttribute PaymentVO paymentVO){
		modelAndView = new ModelAndView();
		modelAndView = itemService.itemPaymetComplete(paymentVO);
		return modelAndView;
	}
	

}

