package kr.co.beauty.vo;

import java.util.List;

public class BasketVO {

	private int BASKET_ID;
	private String MEM_ID;
	private int ITEM_ID;
	private int BASKET_AMOUNT;
	private List<BasketVO> list;
	
	public List<BasketVO> getList() {
		return list;
	}

	public void setList(List<BasketVO> list) {
		this.list = list;
	}

	public BasketVO() {
		
	}
	
	public BasketVO(int bASKET_ID, String mEM_ID, int iTEM_ID, int bASKET_AMOUNT, List<BasketVO> list) {
		super();
		BASKET_ID = bASKET_ID;
		MEM_ID = mEM_ID;
		ITEM_ID = iTEM_ID;
		BASKET_AMOUNT = bASKET_AMOUNT;
		this.list = list;
	}

	public int getBASKET_ID() {
		return BASKET_ID;
	}
	public void setBASKET_ID(int bASKET_ID) {
		BASKET_ID = bASKET_ID;
	}
	public String getMEM_ID() {
		return MEM_ID;
	}
	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}
	public int getITEM_ID() {
		return ITEM_ID;
	}
	public void setITEM_ID(int iTEM_ID) {
		ITEM_ID = iTEM_ID;
	}
	public int getBASKET_AMOUNT() {
		return BASKET_AMOUNT;
	}
	public void setBASKET_AMOUNT(int bASKET_AMOUNT) {
		BASKET_AMOUNT = bASKET_AMOUNT;
	}
	
}
