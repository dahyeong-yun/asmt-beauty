package kr.co.beauty.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.dao.ItemDAO;
import kr.co.beauty.dao.ReviewDAO;
import kr.co.beauty.vo.BasketVO;
import kr.co.beauty.vo.ItemVO;
import kr.co.beauty.vo.MemberVO;
import kr.co.beauty.vo.PaymentVO;
import kr.co.beauty.vo.ReviewVO;
import kr.co.beauty.vo.StoreVO;

@Service
public class ItemService {
	
	@Autowired
	private ItemDAO itemDAO;

	@Autowired
	private ReviewDAO reviewDAO;
	
	private ModelAndView modelAndView;
	private ItemVO itemVO;
	private StoreVO storeVO;
	private MemberVO memberVO;
	
	// 아이템 검색 기능
	public ModelAndView itemSearch(ItemVO itemVO) {
		modelAndView = new ModelAndView();
		List<ItemVO> result;
		result = itemDAO.search(itemVO);
		modelAndView.addObject("searchResult", result);
		modelAndView.setViewName("searchPage");
		return modelAndView;
	}

	// 아이템 상세 페이지
	public ModelAndView itemDetail(int ITEM_ID) {
		itemVO = itemDAO.itemDetail(ITEM_ID);
		List<ReviewVO> reviewList = reviewDAO.reviewList(ITEM_ID);
		
		modelAndView.addObject("reviewList",reviewList);
		modelAndView.addObject("detail",itemVO);
		modelAndView.setViewName("itemDetail");
		return modelAndView;
	}

	// 아이템 찜 기능
	public void itemStore(HttpServletResponse response, int ITEM_ID, String MEM_ID) throws IOException {
		storeVO = new StoreVO();
		storeVO.setITEM_ID(ITEM_ID);
		storeVO.setMEM_ID(MEM_ID);
		int result = itemDAO.itemStore(storeVO);
		if(result == 0) {
			response.getWriter().print("0"); // 실패
		} else {
			response.getWriter().print("1"); // 성공
		}
	}

	// 메인페이지_(비로그인시) 인기제품 4가지
	public ModelAndView trendItems() {
		modelAndView = new ModelAndView();
		List<ItemVO> trendItems = itemDAO.trendItems();
		modelAndView.addObject("trendItems", trendItems);
		return modelAndView;
	}

	// 메인페이지_(로그인시) 추천 제품 4가지
	public ModelAndView personalRecommandItems(String MEM_ID) {
		modelAndView = new ModelAndView();
		List<ItemVO> personalRecommandItems = itemDAO.personalRecommandItems(MEM_ID);
		modelAndView.addObject("personalRecommandItems", personalRecommandItems);
		return modelAndView;
	}	
	
	public ModelAndView itemInfo(PaymentVO paymentVO) {
		modelAndView = new ModelAndView();
		paymentVO = itemDAO.itemInfo(paymentVO);
		modelAndView.addObject("itemInfo",paymentVO);
		modelAndView.setViewName("itemPayment");
		return modelAndView;
	}

	public ModelAndView itemPaymetComplete(PaymentVO paymentVO) {
		modelAndView = new ModelAndView();
		itemDAO.itemPaymetComplete(paymentVO);
		modelAndView.addObject("paynum",paymentVO.getPAY_NUM());
		modelAndView.setViewName("itemPaymentComplete");
		return modelAndView;
	}
 }
