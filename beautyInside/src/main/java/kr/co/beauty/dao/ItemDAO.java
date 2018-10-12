package kr.co.beauty.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beauty.vo.ItemVO;
import kr.co.beauty.vo.PaymentVO;
import kr.co.beauty.vo.StoreVO;

@Repository
public class ItemDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 카테고리, 제품명/브랜드 검색
	public List<ItemVO> search(ItemVO itemVO) {
		return sqlSession.selectList("Item.search", itemVO);
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

	//구매시 제품 정보
	public PaymentVO itemInfo(PaymentVO paymentVO) {
		return sqlSession.selectOne("Item.itemInfo", paymentVO);
	}

	public List<ItemVO> memberStoredItemList(String MEM_ID) {
		return sqlSession.selectList("Item.memberStoredItemList", MEM_ID);
	}

	public int itemPaymetComplete(PaymentVO paymentVO) {
		return sqlSession.insert("Item.itemPaymetComplete",paymentVO);
		
	}


}
