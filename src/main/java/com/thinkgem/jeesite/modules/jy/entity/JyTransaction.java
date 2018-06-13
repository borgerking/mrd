/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.jy.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;
import com.thinkgem.jeesite.modules.sh.entity.ShInfo;
import com.thinkgem.jeesite.modules.sub.entity.SubMerchant;

/**
 * 按商户汇总Entity
 * @author xiax
 * @version 2018-06-09
 */
public class JyTransaction extends DataEntity<JyTransaction> {
	
	private static final long serialVersionUID = 1L;
	private String transactionId;		// 交易ID
	private String merchantId;			// 商户ID
	private String transactionUserId;	// 交易员ID	
	private String subMerchantId;		// 子服务商ID	
	private String serialNumber;		//序列号 
	private String ksnCode;				// KSN编码
	private String settlementModel;		// 结算模式
	private String settlementType;		// 结算类型
	private String paymentMode;			// 支付模式
	private String debitCardRate;		// 借记卡费率
	private String loanCardRate;		// 贷记卡费率
	private String otherCardRate;		// 其他银联卡费率
	private String additionalCost;		// 附加费
	private String transactionNumber;	// 交易笔数
	private String transactionAmount;	// 交易金额
	private String serviceCharge;		// 交易手续费
	private String terminalNumber;		// 终端号
	private String consultNumber;		// 参考号
	private String transactionType;		// 交易类型
	private String cardNumber;			// 交易卡号
	private String cardType;			// 卡类型
	private String settlementStatus;	// 结算状态
	private String value1;		// 临时数据1
	private String value2;		// 临时数据2
	private String value3;		// 临时数据3
	private String value4;		// 临时数据4
	private String value5;		// 临时数据5
	private String value6;		// 临时数据6
	private Date transactionDate;		// 交易日期
	private String createUserId;		// 创建人ID
	private String createCompanyId;		// 创建人机构ID
	
	private Date jyBeginDate;	//交易开始时间
	private Date jyEndDate;		//交易截止时间
	
	private ShInfo shInfo;	//商户
	
	private SubMerchant subMerchant; 	//子服务商
	
	public JyTransaction() {
		super();
	}

	public JyTransaction(String id){
		super(id);
	}

	@Length(min=1, max=64, message="交易ID长度必须介于 1 和 64 之间")
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	@Length(min=0, max=64, message="商户ID长度必须介于 0 和 64 之间")
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	
	@Length(min=0, max=64, message="交易员ID长度必须介于 0 和 64 之间")
	public String getTransactionUserId() {
		return transactionUserId;
	}
	public void setTransactionUserId(String transactionUserId) {
		this.transactionUserId = transactionUserId;
	}
	
	@Length(min=0, max=64, message="子服务商ID长度必须介于 0 和 64 之间")
	public String getSubMerchantId() {
		return subMerchantId;
	}
	public void setSubMerchantId(String subMerchantId) {
		this.subMerchantId = subMerchantId;
	}
	
	@Length(min=0, max=64, message="序列号长度必须介于 0 和 64 之间")
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Length(min=0, max=64, message="交易员ID长度必须介于 0 和 64 之间")
	public String getKsnCode() {
		return ksnCode;
	}
	public void setKsnCode(String ksnCode) {
		this.ksnCode = ksnCode;
	}
	
	@Length(min=0, max=1, message="结算模式长度必须介于 0 和 1 之间")
	public String getSettlementModel() {
		return settlementModel;
	}
	public void setSettlementModel(String settlementModel) {
		this.settlementModel = settlementModel;
	}
	
	@Length(min=0, max=1, message="结算类型长度必须介于 0 和 1 之间")
	public String getSettlementType() {
		return settlementType;
	}
	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
	}

	@Length(min=0, max=1, message="支付模式长度必须介于 0 和 1 之间")
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	@Length(min=0, max=64, message="借记卡费率长度必须介于 0 和 64 之间")
	public String getDebitCardRate() {
		return debitCardRate;
	}
	public void setDebitCardRate(String debitCardRate) {
		this.debitCardRate = debitCardRate;
	}
	
	@Length(min=0, max=64, message="贷记卡费率长度必须介于 0 和 64 之间")
	public String getLoanCardRate() {
		return loanCardRate;
	}
	public void setLoanCardRate(String loanCardRate) {
		this.loanCardRate = loanCardRate;
	}
	
	@Length(min=0, max=64, message="其他银联卡费率长度必须介于 0 和 64 之间")
	public String getOtherCardRate() {
		return otherCardRate;
	}
	public void setOtherCardRate(String otherCardRate) {
		this.otherCardRate = otherCardRate;
	}
	
	@Length(min=0, max=64, message="附加费长度必须介于 0 和 64 之间")
	public String getAdditionalCost() {
		return additionalCost;
	}
	public void setAdditionalCost(String additionalCost) {
		this.additionalCost = additionalCost;
	}
	
	@Length(min=0, max=64, message="交易笔数长度必须介于 0 和 64 之间")
	public String getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	
	@Length(min=0, max=64, message="交易金额长度必须介于 0 和 64 之间")
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	@Length(min=0, max=64, message="交易手续费长度必须介于 0 和 64 之间")
	public String getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(String serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	
	@Length(min=0, max=64, message="终端号长度必须介于 0 和 64 之间")
	public String getTerminalNumber() {
		return terminalNumber;
	}
	public void setTerminalNumber(String terminalNumber) {
		this.terminalNumber = terminalNumber;
	}
	
	@Length(min=0, max=64, message="参考号长度必须介于 0 和 64 之间")
	public String getConsultNumber() {
		return consultNumber;
	}
	public void setConsultNumber(String consultNumber) {
		this.consultNumber = consultNumber;
	}

	@Length(min=0, max=64, message="交易类型长度必须介于 0 和 64之间")
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	@Length(min=0, max=64, message="交易卡号长度必须介于 0 和 64 之间")
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@Length(min=0, max=1, message="卡类型长度必须介于 0 和 1 之间")
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	@Length(min=0, max=1, message="支付状态长度必须介于 0 和 1 之间")
	public String getSettlementStatus() {
		return settlementStatus;
	}
	public void setSettlementStatus(String settlementStatus) {
		this.settlementStatus = settlementStatus;
	}

	@Length(min=0, max=64, message="临时数据1长度必须介于 0 和 64 之间")
	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}
	
	@Length(min=0, max=64, message="临时数据2长度必须介于 0 和 64 之间")
	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}
	
	@Length(min=0, max=64, message="临时数据3长度必须介于 0 和 64 之间")
	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}
	
	@Length(min=0, max=64, message="临时数据4长度必须介于 0 和 64 之间")
	public String getValue4() {
		return value4;
	}
	public void setValue4(String value4) {
		this.value4 = value4;
	}
	
	@Length(min=0, max=64, message="临时数据5长度必须介于 0 和 64 之间")
	public String getValue5() {
		return value5;
	}
	public void setValue5(String value5) {
		this.value5 = value5;
	}
	
	@Length(min=0, max=64, message="临时数据6长度必须介于 0 和 64 之间")
	public String getValue6() {
		return value6;
	}
	public void setValue6(String value6) {
		this.value6 = value6;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	@Length(min=0, max=64, message="创建人ID长度必须介于 0 和 64 之间")
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	
	@Length(min=0, max=64, message="创建人机构ID长度必须介于 0 和 64 之间")
	public String getCreateCompanyId() {
		return createCompanyId;
	}
	public void setCreateCompanyId(String createCompanyId) {
		this.createCompanyId = createCompanyId;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getJyBeginDate() {
		return jyBeginDate;
	}
	public void setJyBeginDate(Date jyBeginDate) {
		this.jyBeginDate = jyBeginDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getJyEndDate() {
		return jyEndDate;
	}
	public void setJyEndDate(Date jyEndDate) {
		this.jyEndDate = jyEndDate;
	}

	public ShInfo getShInfo() {
		return shInfo;
	}
	public void setShInfo(ShInfo shInfo) {
		this.shInfo = shInfo;
	}

	public SubMerchant getSubMerchant() {
		return subMerchant;
	}
	public void setSubMerchant(SubMerchant subMerchant) {
		this.subMerchant = subMerchant;
	}
	
}