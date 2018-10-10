package kr.co.beauty.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beauty.vo.ItemVO;
import kr.co.beauty.vo.MemberVO;
import kr.co.beauty.vo.StoreVO;

@Repository
public class ItemDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 카테고리, 제품명/브랜드 검색
	public List<ItemVO> search(ItemVO itemVO) {
		return sqlSession.selectList("Item.search", itemVO);
	}
	
	// 아이템 메뉴 클릭
	public List<ItemVO> itemList() {
		return sqlSession.selectList("Item.itemList");
	}
	
	// 제품명/브랜드 검색
	public List<ItemVO> itemSearch(ItemVO itemVO) {
		return sqlSession.selectList("Item.itemSearch", itemVO);
	}

	// 카테고리 검색
	public List<ItemVO> categorySearch(ItemVO itemVO) {
		return sqlSession.selectList("Item.categorySearch", itemVO);
	}

	// 아이템 상세 페이지
	public ItemVO itemDetail(int ITEM_ID) {
		return sqlSession.selectOne("Item.itemDetail",ITEM_ID);
	}

	public int itemStore(StoreVO storeVO) {
		return sqlSession.insert("Item.itemStore", storeVO);
	}

	public List<ItemVO> trendItems() {
		return sqlSession.selectList("Item.trendItems");
	}

	public List<ItemVO> personalRecommandItems(String MEM_ID) {
		return sqlSession.selectList("Item.personalRecommandItems", MEM_ID);
	}

	public MemberVO itemPayment(String MEM_ID) {
		return sqlSession.selectOne("Item.itemPayment", MEM_ID);
	}


}
