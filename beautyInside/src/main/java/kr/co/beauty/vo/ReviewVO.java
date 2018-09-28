package kr.co.beauty.vo;

public class ReviewVO {
	private int REVIEW_ID;
	private String MEM_ID;
	private String REVIEW_TITLE;
	private String REVIEW_CONTENT;
	private int ITEM_ID;
	private int REVIEW_LIKE;
	private float REVIEW_GRADE;
	
	
	
	public ReviewVO() {
	}

	public ReviewVO(int rEVIEW_ID, String mEM_ID, String rEVIEW_TITLE, String rEVIEW_CONTENT, int iTEM_ID,
			int rEVIEW_LIKE, float rEVIEW_GRADE) {
		REVIEW_ID = rEVIEW_ID;
		MEM_ID = mEM_ID;
		REVIEW_TITLE = rEVIEW_TITLE;
		REVIEW_CONTENT = rEVIEW_CONTENT;
		ITEM_ID = iTEM_ID;
		REVIEW_LIKE = rEVIEW_LIKE;
		REVIEW_GRADE = rEVIEW_GRADE;
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

	public String getREVIEW_TITLE() {
		return REVIEW_TITLE;
	}

	public void setREVIEW_TITLE(String rEVIEW_TITLE) {
		REVIEW_TITLE = rEVIEW_TITLE;
	}

	public String getREVIEW_CONTENT() {
		return REVIEW_CONTENT;
	}

	public void setREVIEW_CONTENT(String rEVIEW_CONTENT) {
		REVIEW_CONTENT = rEVIEW_CONTENT;
	}

	public int getITEM_ID() {
		return ITEM_ID;
	}

	public void setITEM_ID(int iTEM_ID) {
		ITEM_ID = iTEM_ID;
	}

	public int getREVIEW_LIKE() {
		return REVIEW_LIKE;
	}

	public void setREVIEW_LIKE(int rEVIEW_LIKE) {
		REVIEW_LIKE = rEVIEW_LIKE;
	}

	public float getREVIEW_GRADE() {
		return REVIEW_GRADE;
	}

	public void setREVIEW_GRADE(float rEVIEW_GRADE) {
		REVIEW_GRADE = rEVIEW_GRADE;
	}
	
	
}
