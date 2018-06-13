/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mac.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.User;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * KSN管理模块Entity
 * @author xiax
 * @version 2018-06-06
 */
public class MacKsn extends DataEntity<MacKsn> {
	
	private static final long serialVersionUID = 1L;
	private String ksnId;		// 主键ID
	private String ksnCode;		// KSN编号
	private String supplierId;		// 代理商ID
	private User user;		// 业务员ID
	private String officeId;		// 机构ID
	private String activationStatus;		// 激活状态
	private String useStatus;		// 使用状态
	private String distributeStatus;		// 分发状态
	private String value1;		// 备用字段1
	private String value2;		// 备用字段2
	private String value3;		// 备用字段3
	private String value4;		// 备用字段4
	private String value5;		// 备用字段5
	private String createUserId;		// 创建人ID
	private String updateUserId;		// 更新人ID
	private String createOfficeId;		// 创建人机构ID
	
	public MacKsn() {
		super();
	}

	public MacKsn(String id){
		super(id);
	}

	@Length(min=1, max=64, message="主键ID长度必须介于 1 和 64 之间")
	public String getKsnId() {
		return ksnId;
	}

	public void setKsnId(String ksnId) {
		this.ksnId = ksnId;
	}
	
	@Length(min=0, max=64, message="KSN编号长度必须介于 0 和 64 之间")
	public String getKsnCode() {
		return ksnCode;
	}

	public void setKsnCode(String ksnCode) {
		this.ksnCode = ksnCode;
	}
	
	@Length(min=0, max=64, message="代理商ID长度必须介于 0 和 64 之间")
	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Length(min=0, max=64, message="机构ID长度必须介于 0 和 1 之间")
	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	@Length(min=0, max=1, message="激活状态长度必须介于 0 和 1 之间")
	public String getActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(String activationStatus) {
		this.activationStatus = activationStatus;
	}
	
	@Length(min=0, max=1, message="使用状态长度必须介于 0 和 1 之间")
	public String getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}
	
	@Length(min=0, max=1, message="分发状态长度必须介于 0 和 1 之间")
	public String getDistributeStatus() {
		return distributeStatus;
	}

	public void setDistributeStatus(String distributeStatus) {
		this.distributeStatus = distributeStatus;
	}
	
	@Length(min=0, max=64, message="备用字段1长度必须介于 0 和 64 之间")
	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}
	
	@Length(min=0, max=64, message="备用字段2长度必须介于 0 和 64 之间")
	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}
	
	@Length(min=0, max=64, message="备用字段3长度必须介于 0 和 64 之间")
	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}
	
	@Length(min=0, max=64, message="备用字段4长度必须介于 0 和 64 之间")
	public String getValue4() {
		return value4;
	}

	public void setValue4(String value4) {
		this.value4 = value4;
	}
	
	@Length(min=0, max=64, message="备用字段5长度必须介于 0 和 64 之间")
	public String getValue5() {
		return value5;
	}

	public void setValue5(String value5) {
		this.value5 = value5;
	}
	
	@Length(min=0, max=64, message="创建人ID长度必须介于 0 和 64 之间")
	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	
	@Length(min=0, max=64, message="更新人ID长度必须介于 0 和 64 之间")
	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	
	@Length(min=0, max=64, message="创建人机构ID长度必须介于 0 和 64 之间")
	public String getCreateOfficeId() {
		return createOfficeId;
	}

	public void setCreateOfficeId(String createOfficeId) {
		this.createOfficeId = createOfficeId;
	}
	
}