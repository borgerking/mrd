/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sh.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sh.entity.ShInfo;
import com.thinkgem.jeesite.modules.sh.dao.ShInfoDao;

/**
 * 商户管理Service
 * @author borger
 * @version 2018-06-06
 */
@Service
@Transactional(readOnly = true)
public class ShInfoService extends CrudService<ShInfoDao, ShInfo> {

	public ShInfo get(String id) {
		return super.get(id);
	}
	
	public List<ShInfo> findList(ShInfo shInfo) {
		return super.findList(shInfo);
	}
	
	public Page<ShInfo> findPage(Page<ShInfo> page, ShInfo shInfo) {
		return super.findPage(page, shInfo);
	}
	
	@Transactional(readOnly = false)
	public void save(ShInfo shInfo) {
		super.save(shInfo);
	}
	
	@Transactional(readOnly = false)
	public void delete(ShInfo shInfo) {
		super.delete(shInfo);
	}
	
}