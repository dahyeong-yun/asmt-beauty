package kr.co.beauty.vo;

public class FollowVO {
	private int FOLLOW_ID;
	private String MEM_ID;
	private String TARGET_MEM_ID;
	
	public FollowVO() {
	}

	public FollowVO(int fOLLOW_ID, String mEM_ID, String tARGET_MEM_ID) {
		FOLLOW_ID = fOLLOW_ID;
		MEM_ID = mEM_ID;
		TARGET_MEM_ID = tARGET_MEM_ID;
	}

	public int getFOLLOW_ID() {
		return FOLLOW_ID;
	}

	public void setFOLLOW_ID(int fOLLOW_ID) {
		FOLLOW_ID = fOLLOW_ID;
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
