package com.thinkgem.jeesite.modules.jy.vo;

import java.util.Date;

import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

public class MyTransactionVo {
	private Date transactionDate;		// 交易日期	
	private String settlementModel;		// 结算模式
	private String transactionNumber;		// 交易笔数
	private String transactionAmount;		// 交易金额
	private String serviceCharge;		// 交易手续费
	
	public MyTransactionVo() {
		
	}
	
	public MyTransactionVo(Date transactionDate, String settlementModel, String transactionNumber
			, String transactionAmount, String serviceCharge) {
		this.transactionDate = transactionDate;
		this.settlementModel = settlementModel;
		this.transactionNumber = transactionNumber;
		this.transactionAmount = transactionAmount;
		this.serviceCharge = serviceCharge;
	}
	
	@ExcelField(title="交易日期", type=1, align=2, sort=10 )
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	@ExcelField(title="结算模式", type=1, align=2, sort=20 )
	public String getSettlementModel() {
		return settlementModel;
	}
	public void setSettlementModel(String settlementModel) {
		this.settlementModel = settlementModel;
	}
	
	@ExcelField(title="消费笔数", type=1, align=2, sort=30 )
	public String getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	
	@ExcelField(title="消费金额", type=1, align=2, sort=40 )
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	@ExcelField(title="交易手续费", type=1, align=2, sort=40 )
	public String getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(String serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	
	
	
	
	
	
}
