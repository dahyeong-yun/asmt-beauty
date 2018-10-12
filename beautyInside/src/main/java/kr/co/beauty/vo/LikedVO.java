package kr.co.beauty.vo;

public class LikedVO {

	private int LIKE_ID;
	private int REVIEW_ID;
	private String MEM_ID;
	private String TARGET_MEM_ID;
	
	public LikedVO() {
		
	}
	
	public LikedVO(int lIKE_ID, int rEVIEW_ID, String mEM_ID, String tARGET_MEM_ID) {
		LIKE_ID = lIKE_ID;
		REVIEW_ID = rEVIEW_ID;
		MEM_ID = mEM_ID;
		TARGET_MEM_ID = tARGET_MEM_ID;
	}

	public int getLIKE_ID() {
		return LIKE_ID;
	}

	public void setLIKE_ID(int lIKE_ID) {
		LIKE_ID = lIKE_ID;
	}

	public int getREVIEW_ID() {
		return REVIEW_ID;
	}

	public void setREVIEW_ID(int rEVIEW_ID) {
		REVIEW_ID = rEVIEW_ID;
	}

	public String getMEM_ID() {
		return MEM_ID;
	}

	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}

	public String getTARGET_MEM_ID() {
		return TARGET_MEM_ID;
	}

	public void setTARGET_MEM_ID(String tARGET_MEM_ID) {
		TARGET_MEM_ID = tARGET_MEM_ID;
	}
}
