package kr.co.beauty.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
@RequestMapping(value = "/api")
public class ApiController {
	
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
}
