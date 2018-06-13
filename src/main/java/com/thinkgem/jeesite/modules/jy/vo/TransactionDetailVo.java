package com.thinkgem.jeesite.modules.jy.vo;

import java.util.Date;

import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;
import com.thinkgem.jeesite.modules.sh.entity.ShInfo;

public class TransactionDetailVo {
	
	private String serialNumber;		//序列号
	private Date transactionDate;		// 交易日期
	private String shCode;	// 商户号
	private String shMc;	// 商户名称
	private String terminalNumber;		// 终端号
	private String transactionType;		// 交易类型
	private String settlementModel;		// 结算模式
	private String cardNumber;			// 交易卡号
	private String cardType;			// 卡类型
	private String transactionAmount;	// 交易金额
	private String settlementStatus;	// 结算状态
	
	public TransactionDetailVo() {
		
	}
	
	public TransactionDetailVo(String serialNumber, Date transactionDate, String shCode, String shMc, String terminalNumber
			, String transactionType, String settlementModel, String cardNumber
			, String cardType, String transactionAmount, String settlementStatus) {
		this.serialNumber = serialNumber;
		this.transactionDate = transactionDate;
		this.shCode = shCode;
		this.shMc = shMc;
		this.terminalNumber = terminalNumber;
		this.transactionType = transactionType;
		this.settlementModel = settlementModel;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.transactionAmount = transactionAmount;
		this.settlementStatus = settlementStatus;
	}
	
	@ExcelField(title="序列号", type=1, align=2, sort=10 )
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	@ExcelField(title="交易日期", type=1, align=2, sort=20 )
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	@ExcelField(title="商户号", type=1, align=2, sort=30 )
	public String getShCode() {
		return shCode;
	}
	public void setShCode(String shCode) {
		this.shCode = shCode;
	}
	
	@ExcelField(title="商户名称", type=1, align=2, sort=40 )
	public String getShMc() {
		return shMc;
	}
	public void setShMc(String shMc) {
		this.shMc = shMc;
	}
	
	@ExcelField(title="终端号", type=1, align=2, sort=50 )
	public String getTerminalNumber() {
		return terminalNumber;
	}
	public void setTerminalNumber(String terminalNumber) {
		this.terminalNumber = terminalNumber;
	}
	
	@ExcelField(title="交易类型", type=1, align=2, sort=60 )
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	@ExcelField(title="结算模式", type=1, align=2, sort=70 )
	public String getSettlementModel() {
		return settlementModel;
	}
	public void setSettlementModel(String settlementModel) {
		this.settlementModel = settlementModel;
	}
	
	@ExcelField(title="交易卡号", type=1, align=2, sort=80 )
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@ExcelField(title="卡类型", type=1, align=2, sort=90 )
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	@ExcelField(title="交易金额", type=1, align=2, sort=100 )
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	@ExcelField(title="交易状态", type=1, align=2, sort=110 )
	public String getSettlementStatus() {
		return settlementStatus;
	}
	public void setSettlementStatus(String settlementStatus) {
		this.settlementStatus = settlementStatus;
	}
}
