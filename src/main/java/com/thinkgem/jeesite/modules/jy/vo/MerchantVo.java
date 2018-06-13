package com.thinkgem.jeesite.modules.jy.vo;

import java.util.Date;

import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;
import com.thinkgem.jeesite.modules.sh.entity.ShInfo;

public class MerchantVo {
	private Date transactionDate;		// 交易日期
	private String shCode;	// 商户号
	private String shMc;	// 商户名称
	private String ksnCode;		
	private String settlementModel;		// 结算模式
	private String paymentMode;			// 支付模式
	
	public MerchantVo() {
		
	}
	
	public MerchantVo(Date transactionDate, String shCode, String shMc, String ksnCode, String settlementModel,
			String paymentMode) {
		this.transactionDate = transactionDate;
		this.shCode = shCode;
		this.shMc = shMc;
		this.ksnCode = ksnCode;
		this.settlementModel = settlementModel;
		this.paymentMode = paymentMode;
	}
	
	@ExcelField(title="交易日期", type=1, align=2, sort=10 )
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
	@ExcelField(title="商户号", type=1, align=2, sort=20 )
	public String getShCode() {
		return shCode;
	}

	public void setShCode(String shCode) {
		this.shCode = shCode;
	}
	
	@ExcelField(title="商户名称", type=1, align=2, sort=30 )
	public String getShMc() {
		return shMc;
	}

	public void setShMc(String shMc) {
		this.shMc = shMc;
	}
	
	@ExcelField(title="KSN号", type=1, align=2, sort=40 )
	public String getKsnCode() {
		return ksnCode;
	}
	public void setKsnCode(String ksnCode) {
		this.ksnCode = ksnCode;
	}
	
	@ExcelField(title="结算模式", type=1, align=2, sort=50, dictType="")
	public String getSettlementModel() {
		return settlementModel;
	}
	public void setSettlementModel(String settlementModel) {
		this.settlementModel = settlementModel;
	}
	
	@ExcelField(title="支付模式", type=1, align=2, sort=60 )
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}	
}
