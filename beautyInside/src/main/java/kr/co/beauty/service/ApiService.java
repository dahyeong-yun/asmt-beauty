package kr.co.beauty.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.beauty.dao.ApiDAO;
import kr.co.beauty.dao.ItemDAO;
import kr.co.beauty.dao.TipDAO;
import kr.co.beauty.vo.ItemVO;
import kr.co.beauty.vo.TipVO;

@Service
public class ApiService {

	@Autowired
	private ApiDAO apiDAO;
	@Autowired
	private ItemDAO itemDAO;
	@Autowired
	private TipDAO tipDAO;
	
	private ItemVO itemVO;
	private TipVO tipVO;
	
	// 아이템 정보
	public Map<String, String> itemInfoApi(int ITEM_ID) {
		itemVO = new ItemVO();
		itemVO = itemDAO.itemDetail(ITEM_ID);
		
		Map<String, String> itemJson = new HashMap<String, String>();
		itemJson.put("name", itemVO.getITEM_NAME());
		itemJson.put("brand", itemVO.getITEM_BRAND());
		itemJson.put("category", itemVO.getITEM_CATEGORY());
		itemJson.put("capacity", itemVO.getITEM_CAPA());
		return itemJson;
	}

	// 팁 정보
	public Map<String, Object> tipInfoApi() {
		tipVO = new TipVO();
		List<TipVO> tipList = tipDAO.tipListAll();
		Map<String, Object> tipJson = new HashMap<String, Object>();
		tipJson.put("result", tipList);
		return tipJson;
	}
}
