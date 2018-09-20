package kr.co.beauty.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beauty.vo.ItemVO;

@Repository
public class ItemDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//
	public List<ItemVO> search(ItemVO itemVO) {
		return sqlSession.selectList("Item.search", itemVO);
	}
	
	public List<ItemVO> itemList() {
		return sqlSession.selectList("Item.itemList");
	}

	public List<ItemVO> itemSearch(ItemVO itemVO) {
		return sqlSession.selectList("Item.itemSearch", itemVO);
	}

	// 카테고리 검색
	public List<ItemVO> categorySearch(ItemVO itemVO) {
		return sqlSession.selectList("Item.categorySearch", itemVO);
	}



}
