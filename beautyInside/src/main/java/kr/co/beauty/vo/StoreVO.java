package kr.co.beauty.vo;

public class StoreVO {
	private int STO_ID;
	private String MEM_ID;
	private int ITEM_ID;
	
	public StoreVO() {
	}
	
	
	public StoreVO(int sTO_ID, String mEM_ID, int iTEM_ID) {
		STO_ID = sTO_ID;
		MEM_ID = mEM_ID;
		ITEM_ID = iTEM_ID;
	}


	public int getSTO_ID() {
		return STO_ID;
	}
	public void setSTO_ID(int sTO_ID) {
		STO_ID = sTO_ID;
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
	
	
}
