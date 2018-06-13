/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mac.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.mac.entity.MacKsn;
import com.thinkgem.jeesite.modules.mac.dao.MacKsnDao;

/**
 * KSN管理模块Service
 * @author xiax
 * @version 2018-06-06
 */
@Service
@Transactional(readOnly = true)
public class MacKsnService extends CrudService<MacKsnDao, MacKsn> {

	public MacKsn get(String id) {
		return super.get(id);
	}
	
	public List<MacKsn> findList(MacKsn macKsn) {
		return super.findList(macKsn);
	}
	
	public Page<MacKsn> findPage(Page<MacKsn> page, MacKsn macKsn) {
		return super.findPage(page, macKsn);
	}
	
	@Transactional(readOnly = false)
	public void save(MacKsn macKsn) {
		super.save(macKsn);
	}
	
	@Transactional(readOnly = false)
	public void delete(MacKsn macKsn) {
		super.delete(macKsn);
	}
	
}