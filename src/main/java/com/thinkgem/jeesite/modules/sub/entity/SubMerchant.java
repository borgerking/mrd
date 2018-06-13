/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sub.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.User;
import java.util.Date;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 代理商Entity
 * @author 代理商
 * @version 2018-06-10
 */
public class SubMerchant extends DataEntity<SubMerchant> {
	
	private static final long serialVersionUID = 1L;
	private String merchantNo;		// 代理商编号
	private String merchantName;		// 代理商名称
	private String merchantLevel;		// 代理商级别
	private User user;		// 签约人员
	private String shareType;		// 分润模式
	private String shareVersion;		// 分润版本
	private String shareProdVersion;		// 线上分润模式
	private String accountName;		// 账号名字
	private String customRate;		// 可否自定义费率
	private String accountBank;		// 开户行
	private String accountCard;		// 开户卡号
	private String accountStandard;		// 联行号
	private String accountType;		// 账号类型1.对公，2.对私
	private String accountProvince;		// 开户省
	private String accountCity;		// 开户市
	private String accountArea;		// 开户区
	private String accountStreet;		// 街道
	private Date beginCreateDate;		// 开始 创建时间
	private Date endCreateDate;		// 结束 创建时间
	
	public SubMerchant() {
		super();
	}

	public SubMerchant(String id){
		super(id);
	}

	@Length(min=0, max=64, message="代理商编号长度必须介于 0 和 64 之间")
	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	
	@Length(min=0, max=100, message="代理商名称长度必须介于 0 和 100 之间")
	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	
	@Length(min=0, max=255, message="代理商级别长度必须介于 0 和 255 之间")
	public String getMerchantLevel() {
		return merchantLevel;
	}

	public void setMerchantLevel(String merchantLevel) {
		this.merchantLevel = merchantLevel;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Length(min=0, max=20, message="分润模式长度必须介于 0 和 20 之间")
	public String getShareType() {
		return shareType;
	}

	public void setShareType(String shareType) {
		this.shareType = shareType;
	}
	
	@Length(min=0, max=20, message="分润版本长度必须介于 0 和 20 之间")
	public String getShareVersion() {
		return shareVersion;
	}

	public void setShareVersion(String shareVersion) {
		this.shareVersion = shareVersion;
	}
	
	@Length(min=0, max=20, message="线上分润模式长度必须介于 0 和 20 之间")
	public String getShareProdVersion() {
		return shareProdVersion;
	}

	public void setShareProdVersion(String shareProdVersion) {
		this.shareProdVersion = shareProdVersion;
	}
	
	@Length(min=0, max=20, message="账号名字长度必须介于 0 和 20 之间")
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	@Length(min=0, max=20, message="可否自定义费率长度必须介于 0 和 20 之间")
	public String getCustomRate() {
		return customRate;
	}

	public void setCustomRate(String customRate) {
		this.customRate = customRate;
	}
	
	@Length(min=0, max=20, message="开户行长度必须介于 0 和 20 之间")
	public String getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}
	
	@Length(min=0, max=20, message="开户卡号长度必须介于 0 和 20 之间")
	public String getAccountCard() {
		return accountCard;
	}

	public void setAccountCard(String accountCard) {
		this.accountCard = accountCard;
	}
	
	@Length(min=0, max=255, message="联行号长度必须介于 0 和 255 之间")
	public String getAccountStandard() {
		return accountStandard;
	}

	public void setAccountStandard(String accountStandard) {
		this.accountStandard = accountStandard;
	}
	
	//@对私长度必须介于 0 和 20 之间")
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	@Length(min=0, max=20, message="开户省长度必须介于 0 和 20 之间")
	public String getAccountProvince() {
		return accountProvince;
	}

	public void setAccountProvince(String accountProvince) {
		this.accountProvince = accountProvince;
	}
	
	@Length(min=0, max=200, message="开户市长度必须介于 0 和 200 之间")
	public String getAccountCity() {
		return accountCity;
	}

	public void setAccountCity(String accountCity) {
		this.accountCity = accountCity;
	}
	
	@Length(min=0, max=200, message="开户区长度必须介于 0 和 200 之间")
	public String getAccountArea() {
		return accountArea;
	}

	public void setAccountArea(String accountArea) {
		this.accountArea = accountArea;
	}
	
	@Length(min=0, max=200, message="街道长度必须介于 0 和 200 之间")
	public String getAccountStreet() {
		return accountStreet;
	}

	public void setAccountStreet(String accountStreet) {
		this.accountStreet = accountStreet;
	}
	
	public Date getBeginCreateDate() {
		return beginCreateDate;
	}

	public void setBeginCreateDate(Date beginCreateDate) {
		this.beginCreateDate = beginCreateDate;
	}
	
	public Date getEndCreateDate() {
		return endCreateDate;
	}

	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}
		
}