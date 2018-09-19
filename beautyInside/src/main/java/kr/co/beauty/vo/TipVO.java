package kr.co.beauty.vo;

public class TipVO {

	private int TIP_ID;
	private String TIP_TITLE;
	private String TIP_THUMBNAIL;
	private String TIP_URL;
	private int AGE_ID;
	private int SKINTYPE_ID;
	private int GENDER_ID;
	
	TipVO(){
		
	}
	
	public TipVO(int tIP_ID, String tIP_TITLE, String tIP_THUMBNAIL, String tIP_URL, int aGE_ID, int sKINTYPE_ID,
			int gENDER_ID) {
		TIP_ID = tIP_ID;
		TIP_TITLE = tIP_TITLE;
		TIP_THUMBNAIL = tIP_THUMBNAIL;
		TIP_URL = tIP_URL;
		AGE_ID = aGE_ID;
		SKINTYPE_ID = sKINTYPE_ID;
		GENDER_ID = gENDER_ID;
	}

	public int getTIP_ID() {
		return TIP_ID;
	}

	public void setTIP_ID(int tIP_ID) {
		TIP_ID = tIP_ID;
	}

	public String getTIP_TITLE() {
		return TIP_TITLE;
	}

	public void setTIP_TITLE(String tIP_TITLE) {
		TIP_TITLE = tIP_TITLE;
	}

	public String getTIP_THUMBNAIL() {
		return TIP_THUMBNAIL;
	}

	public void setTIP_THUMBNAIL(String tIP_THUMBNAIL) {
		TIP_THUMBNAIL = tIP_THUMBNAIL;
	}

	public String getTIP_URL() {
		return TIP_URL;
	}

	public void setTIP_URL(String tIP_URL) {
		TIP_URL = tIP_URL;
	}

	public int getAGE_ID() {
		return AGE_ID;
	}

	public void setAGE_ID(int aGE_ID) {
		AGE_ID = aGE_ID;
	}

	public int getSKINTYPE_ID() {
		return SKINTYPE_ID;
	}

	public void setSKINTYPE_ID(int sKINTYPE_ID) {
		SKINTYPE_ID = sKINTYPE_ID;
	}

	public int getGENDER_ID() {
		return GENDER_ID;
	}

	public void setGENDER_ID(int gENDER_ID) {
		GENDER_ID = gENDER_ID;
	}
	
	
}
