package kr.co.beauty.vo;

public class MemberVO {
	private String MEM_ID;
	private String MEM_PW;
	private String MEM_NAME;
	private int MEM_AGE;
	private String MEM_EMAIL;
	private String MEM_PROFILE;
	private int GENDER_ID;
	private int SKINTYPE_ID;
	private int AGE_ID;
	private String MEM_ADDR;
	private String MEM_PHONE;
	private int MEM_POINT;
	private int MEM_GRADE;
	
	public MemberVO() {
	}
	
	public MemberVO(String mEM_ID, String mEM_PW, String mEM_NAME, int mEM_AGE, String mEM_EMAIL, String mEM_PROFILE,
			int gENDER_ID, int sKINTYPE_ID, int aGE_ID, String mEM_ADDR, String mEM_PHONE, int mEM_POINT, int mEM_GRADE) {
		MEM_ID = mEM_ID;
		MEM_PW = mEM_PW;
		MEM_NAME = mEM_NAME;
		MEM_AGE = mEM_AGE;
		MEM_EMAIL = mEM_EMAIL;
		MEM_PROFILE = mEM_PROFILE;
		GENDER_ID = gENDER_ID;
		SKINTYPE_ID = sKINTYPE_ID;
		AGE_ID = aGE_ID;
		MEM_ADDR = mEM_ADDR;
		MEM_PHONE = mEM_PHONE;
		MEM_POINT = mEM_POINT;
		MEM_GRADE = mEM_GRADE;
	}
	
	public String getMEM_ADDR() {
		return MEM_ADDR;
	}

	public void setMEM_ADDR(String mEM_ADDR) {
		MEM_ADDR = mEM_ADDR;
	}

	public String getMEM_PHONE() {
		return MEM_PHONE;
	}

	public void setMEM_PHONE(String mEM_PHONE) {
		MEM_PHONE = mEM_PHONE;
	}

	public int getMEM_POINT() {
		return MEM_POINT;
	}

	public void setMEM_POINT(int mEM_POINT) {
		MEM_POINT = mEM_POINT;
	}

	public String getMEM_ID() {
		return MEM_ID;
	}

	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}

	public String getMEM_PW() {
		return MEM_PW;
	}

	public void setMEM_PW(String mEM_PW) {
		MEM_PW = mEM_PW;
	}

	public String getMEM_NAME() {
		return MEM_NAME;
	}

	public void setMEM_NAME(String mEM_NAME) {
		MEM_NAME = mEM_NAME;
	}

	public int getMEM_AGE() {
		return MEM_AGE;
	}

	public void setMEM_AGE(int mEM_AGE) {
		MEM_AGE = mEM_AGE;
	}

	public String getMEM_EMAIL() {
		return MEM_EMAIL;
	}

	public void setMEM_EMAIL(String mEM_EMAIL) {
		MEM_EMAIL = mEM_EMAIL;
	}

	public String getMEM_PROFILE() {
		return MEM_PROFILE;
	}

	public void setMEM_PROFILE(String mEM_PROFILE) {
		MEM_PROFILE = mEM_PROFILE;
	}

	public int getGENDER_ID() {
		return GENDER_ID;
	}

	public void setGENDER_ID(int gENDER_ID) {
		GENDER_ID = gENDER_ID;
	}

	public int getSKINTYPE_ID() {
		return SKINTYPE_ID;
	}

	public void setSKINTYPE_ID(int sKINTYPE_ID) {
		SKINTYPE_ID = sKINTYPE_ID;
	}

	public int getAGE_ID() {
		return AGE_ID;
	}

	public void setAGE_ID(int aGE_ID) {
		AGE_ID = aGE_ID;
	}

	public int getMEM_GRADE() {
		return MEM_GRADE;
	}

	public void setMEM_GRADE(int mEM_GRADE) {
		MEM_GRADE = mEM_GRADE;
	}
	
}
