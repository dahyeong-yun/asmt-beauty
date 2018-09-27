package kr.co.beauty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.beauty.dao.ItemDAO;
import kr.co.beauty.vo.ItemVO;

@Service
public class ItemService {
	
	@Autowired
	private ItemDAO itemDAO;
	private ModelAndView modelAndView;
	
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


 }
