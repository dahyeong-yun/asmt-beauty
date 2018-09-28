package kr.co.beauty.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.dao.ItemDAO;
import kr.co.beauty.dao.ReviewDAO;
import kr.co.beauty.vo.ItemVO;
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
	
	// 아이템 검색 기능
	public ModelAndView itemSearch(ItemVO itemVO) {
		modelAndView = new ModelAndView();
		List<ItemVO> result;
		
		
		if(itemVO.getITEM_CATEGORY().equals("")) {// 카테고리 미지정 시,
			if(itemVO.getITEM_NAME().equals("")) { // 검색 값이 없을 경우
				System.out.println("카테고리 X, 검색 값 X");
				result = itemDAO.itemList();
			} else {
				System.out.println("카테고리 X, 검색 값 O");
				result = itemDAO.itemSearch(itemVO); // 검색 값이 있을 경우
			}
		} else {
			if(itemVO.getITEM_NAME().equals("")) {// 카테고리 지정 시,
				System.out.println("카테고리 O, 검색 값 X");
				result = itemDAO.categorySearch(itemVO);
			} else {
				System.out.println("카테고리 O, 검색 값 O");
				result = itemDAO.search(itemVO);
			}
		}
		modelAndView.addObject("searchResult", result);
		modelAndView.setViewName("searchPage");
		return modelAndView;

	}

	// 아이템 상세 페이지
	public ModelAndView itemDetail(int ITEM_ID) {
		modelAndView = new ModelAndView();
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
 }
