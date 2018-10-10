package kr.co.beauty.vo;

import java.sql.Date;

public class PaymentVO {
	private int PAY_ID;
	private int PAY_NUM;
	private int ITEM_ID;
	private String MEM_ID; //구매자 아이디
	private String PAY_NAME; //받는 사람 이름
	private String PAY_PHONE; //받는 사람 폰 번호
	private String PAY_ADDR; //받는 사람 주소
	private String PAY_MESSAGE; //배송메세지
	private int PAY_PRICE; //결제금액
	private Date PAY_DATE;
	private String PAY_METHOD;
	private int PAY_AMOUNT; //구매수량

	public PaymentVO() {
		
	}
	
	
	public PaymentVO(int pAY_ID, int pAY_NUM, int iTEM_ID, String mEM_ID, String pAY_NAME,
			String pAY_PHONE, String pAY_ADDR, String pAY_MESSAGE, int pAY_PRICE, Date pAY_DATE, String pAY_METHOD,
			int pAY_AMOUNT) {
		super();
		PAY_ID = pAY_ID;
		PAY_NUM = pAY_NUM;
		ITEM_ID = iTEM_ID;
		MEM_ID = mEM_ID;
		PAY_NAME = pAY_NAME;
		PAY_PHONE = pAY_PHONE;
		PAY_ADDR = pAY_ADDR;
		PAY_MESSAGE = pAY_MESSAGE;
		PAY_PRICE = pAY_PRICE;
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
	public int getPAY_NUM() {
		return PAY_NUM;
	}
	public void setPAY_NUM(int pAY_NUM) {
		PAY_NUM = pAY_NUM;
	}
	public int getITEM_ID() {
		return ITEM_ID;
	}
	public void setITEM_ID(int iTEM_ID) {
		ITEM_ID = iTEM_ID;
	}
	public String getMEM_ID() {
		return MEM_ID;
	}
	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}
	public String getPAY_NAME() {
		return PAY_NAME;
	}
	public void setPAY_NAME(String pAY_NAME) {
		PAY_NAME = pAY_NAME;
	}
	public String getPAY_PHONE() {
		return PAY_PHONE;
	}
	public void setPAY_PHONE(String pAY_PHONE) {
		PAY_PHONE = pAY_PHONE;
	}
	public String getPAY_ADDR() {
		return PAY_ADDR;
	}
	public void setPAY_ADDR(String pAY_ADDR) {
		PAY_ADDR = pAY_ADDR;
	}
	public String getPAY_MESSAGE() {
		return PAY_MESSAGE;
	}
	public void setPAY_MESSAGE(String pAY_MESSAGE) {
		PAY_MESSAGE = pAY_MESSAGE;
	}
	public int getPAY_PRICE() {
		return PAY_PRICE;
	}
	public void setPAY_PRICE(int pAY_PRICE) {
		PAY_PRICE = pAY_PRICE;
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
