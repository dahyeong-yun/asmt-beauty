package kr.co.beauty.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.beauty.dao.ApiDAO;
import kr.co.beauty.dao.ItemDAO;
import kr.co.beauty.vo.ItemVO;

@Service
public class ApiService {

	@Autowired
	private ApiDAO apiDAO;
	@Autowired
	private ItemDAO itemDAO;
	private ItemVO itemVO;
	
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

	public Map<String, String> tipInfoApi(int tIP_ID) {
		return null;
	}
}
