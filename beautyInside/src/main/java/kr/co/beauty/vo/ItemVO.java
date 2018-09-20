package kr.co.beauty.vo;

public class ItemVO {
	private int ITEM_ID;
	private String ITEM_NAME;
	private String ITEM_BRAND;
	private String ITEM_CATEGORY;
	private int AGE_ID;
	private int SKINTYPE_ID;
	private int GENDER_ID;
	private int ITEM_PRICE;
	private String ITEM_CAPA;
	private String ITEM_IMAGE;
	
	public ItemVO() {
	}
	
	public ItemVO(int iTEM_ID, String iTEM_NAME, String iTEM_BRAND, String iTEM_CATEGORY, int aGE_ID, int sKINTYPE_ID,
			int gENDER_ID, int iTEM_PRICE, String iTEM_CAPA, String iTEM_IMAGE) {
		super();
		ITEM_ID = iTEM_ID;
		ITEM_NAME = iTEM_NAME;
		ITEM_BRAND = iTEM_BRAND;
		ITEM_CATEGORY = iTEM_CATEGORY;
		AGE_ID = aGE_ID;
		SKINTYPE_ID = sKINTYPE_ID;
		GENDER_ID = gENDER_ID;
		ITEM_PRICE = iTEM_PRICE;
		ITEM_CAPA = iTEM_CAPA;
		ITEM_IMAGE = iTEM_IMAGE;
	}
	public int getITEM_ID() {
		return ITEM_ID;
	}
	public void setITEM_ID(int iTEM_ID) {
		ITEM_ID = iTEM_ID;
	}
	public String getITEM_NAME() {
		return ITEM_NAME;
	}
	public void setITEM_NAME(String iTEM_NAME) {
		ITEM_NAME = iTEM_NAME;
	}
	public String getITEM_BRAND() {
		return ITEM_BRAND;
	}
	public void setITEM_BRAND(String iTEM_BRAND) {
		ITEM_BRAND = iTEM_BRAND;
	}
	public String getITEM_CATEGORY() {
		return ITEM_CATEGORY;
	}
	public void setITEM_CATEGORY(String iTEM_CATEGORY) {
		ITEM_CATEGORY = iTEM_CATEGORY;
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
	public int getITEM_PRICE() {
		return ITEM_PRICE;
	}
	public void setITEM_PRICE(int iTEM_PRICE) {
		ITEM_PRICE = iTEM_PRICE;
	}
	public String getITEM_CAPA() {
		return ITEM_CAPA;
	}
	public void setITEM_CAPA(String iTEM_CAPA) {
		ITEM_CAPA = iTEM_CAPA;
	}
	public String getITEM_IMAGE() {
		return ITEM_IMAGE;
	}
	public void setITEM_IMAGE(String iTEM_IMAGE) {
		ITEM_IMAGE = iTEM_IMAGE;
	}
}
