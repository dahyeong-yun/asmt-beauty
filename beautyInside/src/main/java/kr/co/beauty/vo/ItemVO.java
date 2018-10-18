package kr.co.beauty.vo;

import java.util.Arrays;

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
	private int[] filterAGE;
	private int[] filterGENDER;
	private int[] filterSKINTYPE;
	
	public ItemVO() {
	}
	

	@Override
	public String toString() {
		return "ItemVO [ITEM_ID=" + ITEM_ID + ", ITEM_NAME=" + ITEM_NAME + ", ITEM_BRAND=" + ITEM_BRAND
				+ ", ITEM_CATEGORY=" + ITEM_CATEGORY + ", AGE_ID=" + AGE_ID + ", SKINTYPE_ID=" + SKINTYPE_ID
				+ ", GENDER_ID=" + GENDER_ID + ", ITEM_PRICE=" + ITEM_PRICE + ", ITEM_CAPA=" + ITEM_CAPA
				+ ", ITEM_IMAGE=" + ITEM_IMAGE + ", filterAGE=" + Arrays.toString(filterAGE) + ", filterGENDER="
				+ Arrays.toString(filterGENDER) + ", filterSKINTYPE=" + Arrays.toString(filterSKINTYPE) + "]";
	}


	public ItemVO(int iTEM_ID, String iTEM_NAME, String iTEM_BRAND, String iTEM_CATEGORY, int aGE_ID, int sKINTYPE_ID,
			int gENDER_ID, int iTEM_PRICE, String iTEM_CAPA, String iTEM_IMAGE, int[] filterAGE, int[] filterGENDER,
			int[] filterSKINTYPE) {
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
		this.filterAGE = filterAGE;
		this.filterGENDER = filterGENDER;
		this.filterSKINTYPE = filterSKINTYPE;
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

	public int[] getFilterAGE() {
		return filterAGE;
	}

	public void setFilterAGE(int[] filterAGE) {
		this.filterAGE = filterAGE;
	}

	public int[] getFilterGENDER() {
		return filterGENDER;
	}

	public void setFilterGENDER(int[] filterGENDER) {
		this.filterGENDER = filterGENDER;
	}

	public int[] getFilterSKINTYPE() {
		return filterSKINTYPE;
	}

	public void setFilterSKINTYPE(int[] filterSKINTYPE) {
		this.filterSKINTYPE = filterSKINTYPE;
	}
	
}