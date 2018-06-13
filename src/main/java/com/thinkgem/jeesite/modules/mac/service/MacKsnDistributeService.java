/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mac.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.mac.entity.MacKsnDistribute;
import com.thinkgem.jeesite.modules.mac.dao.MacKsnDistributeDao;

/**
 * KSN分发Service
 * @author xiax
 * @version 2018-06-07
 */
@Service
@Transactional(readOnly = true)
public class MacKsnDistributeService extends CrudService<MacKsnDistributeDao, MacKsnDistribute> {

	public MacKsnDistribute get(String id) {
		return super.get(id);
	}
	
	public List<MacKsnDistribute> findList(MacKsnDistribute macKsnDistribute) {
		return super.findList(macKsnDistribute);
	}
	
	public Page<MacKsnDistribute> findPage(Page<MacKsnDistribute> page, MacKsnDistribute macKsnDistribute) {
		return super.findPage(page, macKsnDistribute);
	}
	
	@Transactional(readOnly = false)
	public void save(MacKsnDistribute macKsnDistribute) {
		super.save(macKsnDistribute);
	}
	
	@Transactional(readOnly = false)
	public void delete(MacKsnDistribute macKsnDistribute) {
		super.delete(macKsnDistribute);
	}
	
}