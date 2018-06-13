/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sh.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.User;
import java.util.Date;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

/**
 * 商户管理Entity
 * @author borger
 * @version 2018-06-06
 */
public class ShInfo extends DataEntity<ShInfo> {
	
	private static final long serialVersionUID = 1L;
	private String shMc;		// 商户名称
	private String shCode;		// 商户号
	private String shName;		// 商户姓名
	private String phone;		// 手机号
	private String jsMode;		// 结算模式
	private String jsCp;		// 结算产品
	//private User dls_user;		// 所属代理商
	private Office agent;	// 归属部门
	private User user;		// 维护业务员
	private String ktState;		// 开通状态
	private String shState;		// 商户状态
	private String ksnCode;		// ksn编号
	private String xlNumber;		// 序列号
	private String jsCode;		// 结算卡号
	private Date zcDate;		// 注册时间
	private Date ktDate;		// 开通时间
	private Date beginZcDate;		// 开始 注册时间
	private Date endZcDate;		// 结束 注册时间
	private Date beginKtDate;		// 开始 开通时间
	private Date endKtDate;		// 结束 开通时间
	
	public ShInfo() {
		super();
	}

	public ShInfo(String id){
		super(id);
	}

	@Length(min=0, max=100, message="商户名称长度必须介于 0 和 100 之间")
	@ExcelField(title="商户名称", align=2, sort=10)
	public String getShMc() {
		return shMc;
	}

	public void setShMc(String shMc) {
		this.shMc = shMc;
	}
	
	@Length(min=0, max=64, message="商户号长度必须介于 0 和 64 之间")
	@ExcelField(title="商户号", align=2, sort=20)
	public String getShCode() {
		return shCode;
	}

	public void setShCode(String shCode) {
		this.shCode = shCode;
	}
	
	@Length(min=0, max=100, message="商户姓名长度必须介于 0 和 100 之间")
	@ExcelField(title="商户姓名", align=2, sort=30)
	public String getShName() {
		return shName;
	}

	public void setShName(String shName) {
		this.shName = shName;
	}
	
	@Length(min=0, max=64, message="手机号长度必须介于 0 和 64 之间")
	@Pattern(regexp = "1[3|4|5|6|7|8][0-9]\\d{8}",message = "手机号码格式错误")
	@ExcelField(title="手机号", align=2, sort=40)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=64, message="结算模式长度必须介于 0 和 64 之间")
	@ExcelField(title="结算模式", align=2, sort=50)
	public String getJsMode() {
		return jsMode;
	}

	public void setJsMode(String jsMode) {
		this.jsMode = jsMode;
	}
	
	@Length(min=0, max=100, message="结算产品长度必须介于 0 和 100 之间")
	@ExcelField(title="结算产品", align=2, sort=60)
	public String getJsCp() {
		return jsCp;
	}

	public void setJsCp(String jsCp) {
		this.jsCp = jsCp;
	}
	/*@JsonIgnore
	public User getDls_user() {
		return dls_user;
	}

	public void setDls_user(User dls_user) {
		this.dls_user = dls_user;
	}*/
	@JsonIgnore
	public User getUser() {
		return user;
	}

	public Office getAgent() {
		return agent;
	}

	public void setAgent(Office agent) {
		this.agent = agent;
	}

	public void setUser(User user) {
		this.user =user;
	}

	@Length(min=0, max=1, message="开通状态长度必须介于 0 和 1 之间")
	@ExcelField(title="开通状态", align=2, sort=70)
	public String getKtState() {
		return ktState;
	}

	public void setKtState(String ktState) {
		this.ktState = ktState;
	}
	
	@Length(min=0, max=1, message="商户状态长度必须介于 0 和 1 之间")
	@ExcelField(title="商户状态", align=2, sort=80)
	public String getShState() {
		return shState;
	}

	public void setShState(String shState) {
		this.shState = shState;
	}
	
	@Length(min=0, max=64, message="ksn编号长度必须介于 0 和 64 之间")
	@ExcelField(title="ksn编号", align=2, sort=90)
	@Pattern(regexp = "[0-9]{0,17}",message = "ksn编号不能大于17个字符，且只能是数字")
	public String getKsnCode() {
		return ksnCode;
	}

	public void setKsnCode(String ksnCode) {
		this.ksnCode = ksnCode;
	}
	
	@Length(min=0, max=64, message="序列号长度必须介于 0 和 64 之间")
	@ExcelField(title="序列号", align=2, sort=100)
	public String getXlNumber() {
		return xlNumber;
	}

	public void setXlNumber(String xlNumber) {
		this.xlNumber = xlNumber;
	}
	
	@Length(min=0, max=64, message="结算卡号长度必须介于 0 和 64 之间")
	@ExcelField(title="结算卡号", align=2, sort=110)
	@Pattern(regexp = "[0-9]{0,17}",message = "结算卡号不能大于17个字符，且只能是数字")
	public String getJsCode() {
		return jsCode;
	}

	public void setJsCode(String jsCode) {
		this.jsCode = jsCode;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="注册日期", align=2, sort=120)
	public Date getZcDate() {
		return zcDate;
	}

	public void setZcDate(Date zcDate) {
		this.zcDate = zcDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="开通日期", align=2, sort=130)
	public Date getKtDate() {
		return ktDate;
	}

	public void setKtDate(Date ktDate) {
		this.ktDate = ktDate;
	}
	
	public Date getBeginZcDate() {
		return beginZcDate;
	}

	public void setBeginZcDate(Date beginZcDate) {
		this.beginZcDate = beginZcDate;
	}
	
	public Date getEndZcDate() {
		return endZcDate;
	}

	public void setEndZcDate(Date endZcDate) {
		this.endZcDate = endZcDate;
	}
		
	public Date getBeginKtDate() {
		return beginKtDate;
	}

	public void setBeginKtDate(Date beginKtDate) {
		this.beginKtDate = beginKtDate;
	}
	
	public Date getEndKtDate() {
		return endKtDate;
	}

	public void setEndKtDate(Date endKtDate) {
		this.endKtDate = endKtDate;
	}
		
}