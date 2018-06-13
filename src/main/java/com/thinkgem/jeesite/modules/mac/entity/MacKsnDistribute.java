/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mac.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

/**
 * KSN分发Entity
 * @author xiax
 * @version 2018-06-07
 */
public class MacKsnDistribute extends DataEntity<MacKsnDistribute> {
	
	private static final long serialVersionUID = 1L;
	private String distributeId;		// 主键ID
	private String serialNumber;		//序号
	private User user;					// 业务员
	private User serviceProvider;		// 服务商
	private String supplierId;		// 代理商ID
	private String batchNumber;		// 批次号
	private String totalCount;		// 总数量
	private String successCount;		// 成功数量
	private String failCount;		// 失败数量
	private String batchStatus;		// 批次状态
	private String ksnCode;		// KSN编码
	private String value3;		// 临时数据3
	private String value4;		// 临时数据4
	private String remarks;		// 备注
	private String createUserId;		// 创建人ID
	private Date createDate;		// 操作时间
	private String updateUserId;		// 更新人ID
	private Date updateDate;		// 更新时间
	private String createCompanyId;		// 创建人机构ID
	private MacKsn macKsn;				//ksn
	
	private Date beginDate;	// 开始查询日期
	private Date endDate;	// 结束查询日期
	
	public MacKsnDistribute() {
		super();
	}

	public MacKsnDistribute(String id){
		super(id);
	}

	@Length(min=1, max=64, message="主键ID长度必须介于 1 和 64 之间")
	public String getDistributeId() {
		return distributeId;
	}

	public void setDistributeId(String distributeId) {
		this.distributeId = distributeId;
	}
	
	
	@ExcelField(title="序号", type=1, align=2, sort=10 )
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@ExcelField(title="业务员", type=0, align=2, sort=50 )
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@ExcelField(title="服务商名称", type=0, align=2, sort=40 )
	public User getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(User serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	@Length(min=0, max=64, message="代理商ID长度必须介于 0 和 64 之间")
	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	
	@Length(min=0, max=64, message="批次号长度必须介于 0 和 64 之间")
	@ExcelField(title="批次号", type=0, align=2, sort=20)
	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	
	@Length(min=0, max=64, message="总数量长度必须介于 0 和 64 之间")
	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	
	@Length(min=0, max=64, message="成功数量长度必须介于 0 和 64 之间")
	public String getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(String successCount) {
		this.successCount = successCount;
	}
	
	@Length(min=0, max=64, message="失败数量长度必须介于 0 和 64 之间")
	public String getFailCount() {
		return failCount;
	}

	public void setFailCount(String failCount) {
		this.failCount = failCount;
	}
	
	@Length(min=0, max=64, message="KSN编码长度必须介于 0 和 64 之间")
	@ExcelField(title="KSN编号", type=1, align=2, sort=30)
	public String getKsnCode() {
		return ksnCode;
	}

	public void setKsnCode(String ksnCode) {
		this.ksnCode = ksnCode;
	}
	
	@Length(min=0, max=1, message="批次状态长度必须介于 0 和 1 之间")
	public String getBatchStatus() {
		return batchStatus;
	}

	public void setBatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
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
	
	@Length(min=0, max=250, message="临时数据5长度必须介于 0 和 250 之间")
	@ExcelField(title="备注", type=1, align=2, sort=70)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Length(min=0, max=64, message="创建人ID长度必须介于 0 和 64 之间")
	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Length(min=0, max=64, message="更新人ID长度必须介于 0 和 64 之间")
	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Length(min=0, max=64, message="创建人机构ID长度必须介于 0 和 64 之间")
	public String getCreateCompanyId() {
		return createCompanyId;
	}

	public void setCreateCompanyId(String createCompanyId) {
		this.createCompanyId = createCompanyId;
	}
	
	@ExcelField(title="操作状态", type=1, align=2, sort=60, dictType="	mac_distribute_status")
	public MacKsn getMacKsn() {
		return macKsn;
	}

	public void setMacKsn(MacKsn macKsn) {
		this.macKsn = macKsn;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}