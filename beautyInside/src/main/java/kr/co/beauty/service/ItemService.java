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
	
	public ModelAndView itemSearch(ItemVO itemVO) {
		modelAndView = new ModelAndView();
		List<ItemVO> result;
		if(itemVO.getITEM_CATEGORY()=="") {
			if(itemVO.getITEM_NAME()=="") {
				result = itemDAO.itemList();
			}else {
				result = itemDAO.itemSearch(itemVO);
			}
		}else {
			if(itemVO.getITEM_NAME()==null) {
				result = itemDAO.categorySearch(itemVO);
			}else {
				result = itemDAO.search(itemVO);
			}
		}
		modelAndView.addObject("searchResult", result);
		modelAndView.setViewName("searchPage");
		return modelAndView;
	}
	
	
}
