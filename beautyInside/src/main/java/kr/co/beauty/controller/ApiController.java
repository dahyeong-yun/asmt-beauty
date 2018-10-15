package kr.co.beauty.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.beauty.service.ApiService;
import kr.co.beauty.service.ItemService;




@Controller
@RequestMapping(value = "/api")
public class ApiController {

	@Autowired
	private ApiService apiService;
	
	// API 소개 페이지 이동
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String apiPage() {
		return "apiIntro";
	}

	@RequestMapping("/test")
	public @ResponseBody Map<String , Object> getJsonByMap() {
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		Map<String, Object> jsonSubObject = null;
		ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();

		//1번째 데이터
		jsonSubObject = new HashMap<String, Object>();
		jsonSubObject.put("idx", 1);
		jsonSubObject.put("title", "제목입니다");
		jsonSubObject.put("create_date", new Date());
		jsonList.add(jsonSubObject);
		//2번째 데이터
		jsonSubObject = new HashMap<String, Object>();
		jsonSubObject.put("idx", 2);
		jsonSubObject.put("title", "두번째제목입니다");
		jsonSubObject.put("create_date", new Date());
		jsonList.add(jsonSubObject);
		
		jsonObject.put("success", true);
		jsonObject.put("total_count", 10);
		jsonObject.put("result_list", jsonList);

		return jsonObject;
	}
	
	// 아이템 정보
	@RequestMapping("/item/{ITEM_ID}")
	public @ResponseBody Map<String , String> getJsonByItem(@PathVariable("ITEM_ID") int ITEM_ID) {
		Map<String, String> jsonObject = apiService.itemInfoApi(ITEM_ID);
		return jsonObject;
	}
	
	// 팁 정보
	@RequestMapping("/tip")
	public @ResponseBody Map<String , Object> getJsonByTip() {
		Map<String, Object> jsonObject = apiService.tipInfoApi();
		return jsonObject;
	}
}
