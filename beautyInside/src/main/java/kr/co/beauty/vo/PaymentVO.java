package kr.co.beauty.vo;

import java.sql.Date;

public class PaymentVO {
	private int PAY_ID;
	private String PAY_NUM;
	private int ITEM_ID;
	private String ITEM_IMAGE;
	private String ITEM_NAME;
	private String MEM_ID; //구매자 아이디
	private String MEM_NAME; //받는 사람 이름
	private String MEM_PHONE; //받는 사람 폰 번호
	private String MEM_ADDR; //받는 사람 주소
	private String PAY_MESSAGE; //배송메세지
	private int ITEM_PRICE; 
	private Date PAY_DATE;
	private String PAY_METHOD;
	private int PAY_AMOUNT; //구매수량

	public PaymentVO() {
		
	}

	public PaymentVO(int pAY_ID, String pAY_NUM, int iTEM_ID, String iTEM_IMAGE, String iTEM_NAME, String mEM_ID,
			String mEM_NAME, String mEM_PHONE, String mEM_ADDR, String pAY_MESSAGE, int iTEM_PRICE, Date pAY_DATE,
			String pAY_METHOD, int pAY_AMOUNT) {
		super();
		PAY_ID = pAY_ID;
		PAY_NUM = pAY_NUM;
		ITEM_ID = iTEM_ID;
		ITEM_IMAGE = iTEM_IMAGE;
		ITEM_NAME = iTEM_NAME;
		MEM_ID = mEM_ID;
		MEM_NAME = mEM_NAME;
		MEM_PHONE = mEM_PHONE;
		MEM_ADDR = mEM_ADDR;
		PAY_MESSAGE = pAY_MESSAGE;
		ITEM_PRICE = iTEM_PRICE;
		PAY_DATE = pAY_DATE;
		PAY_METHOD = pAY_METHOD;
		PAY_AMOUNT = pAY_AMOUNT;
	}


	public int getPAY_ID() {
		return PAY_ID;
	}

	public void setPAY_ID(int pAY_ID) {
		PAY_ID = pAY_ID;
	}

	public String getPAY_NUM() {
		return PAY_NUM;
	}

	public void setPAY_NUM(String pAY_NUM) {
		PAY_NUM = pAY_NUM;
	}

	public int getITEM_ID() {
		return ITEM_ID;
	}

	public void setITEM_ID(int iTEM_ID) {
		ITEM_ID = iTEM_ID;
	}

	public String getITEM_IMAGE() {
		return ITEM_IMAGE;
	}

	public void setITEM_IMAGE(String iTEM_IMAGE) {
		ITEM_IMAGE = iTEM_IMAGE;
	}

	public String getITEM_NAME() {
		return ITEM_NAME;
	}

	public void setITEM_NAME(String iTEM_NAME) {
		ITEM_NAME = iTEM_NAME;
	}

	public String getMEM_ID() {
		return MEM_ID;
	}

	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}

	public String getMEM_NAME() {
		return MEM_NAME;
	}

	public void setMEM_NAME(String mEM_NAME) {
		MEM_NAME = mEM_NAME;
	}

	public String getMEM_PHONE() {
		return MEM_PHONE;
	}

	public void setMEM_PHONE(String mEM_PHONE) {
		MEM_PHONE = mEM_PHONE;
	}

	public String getMEM_ADDR() {
		return MEM_ADDR;
	}

	public void setMEM_ADDR(String mEM_ADDR) {
		MEM_ADDR = mEM_ADDR;
	}

	public String getPAY_MESSAGE() {
		return PAY_MESSAGE;
	}

	public void setPAY_MESSAGE(String pAY_MESSAGE) {
		PAY_MESSAGE = pAY_MESSAGE;
	}

	public int getITEM_PRICE() {
		return ITEM_PRICE;
	}

	public void setITEM_PRICE(int iTEM_PRICE) {
		ITEM_PRICE = iTEM_PRICE;
	}

	public Date getPAY_DATE() {
		return PAY_DATE;
	}

	public void setPAY_DATE(Date pAY_DATE) {
		PAY_DATE = pAY_DATE;
	}

	public String getPAY_METHOD() {
		return PAY_METHOD;
	}

	public void setPAY_METHOD(String pAY_METHOD) {
		PAY_METHOD = pAY_METHOD;
	}

	public int getPAY_AMOUNT() {
		return PAY_AMOUNT;
	}

	public void setPAY_AMOUNT(int pAY_AMOUNT) {
		PAY_AMOUNT = pAY_AMOUNT;
	}
	
	
}
