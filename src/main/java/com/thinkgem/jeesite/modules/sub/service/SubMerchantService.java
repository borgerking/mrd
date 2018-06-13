/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sub.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sub.entity.SubMerchant;
import com.thinkgem.jeesite.modules.sub.dao.SubMerchantDao;

/**
 * 代理商Service
 * @author 代理商
 * @version 2018-06-10
 */
@Service
@Transactional(readOnly = true)
public class SubMerchantService extends CrudService<SubMerchantDao, SubMerchant> {

	public SubMerchant get(String id) {
		return super.get(id);
	}
	
	public List<SubMerchant> findList(SubMerchant subMerchant) {
		return super.findList(subMerchant);
	}
	
	public Page<SubMerchant> findPage(Page<SubMerchant> page, SubMerchant subMerchant) {
		return super.findPage(page, subMerchant);
	}
	
	@Transactional(readOnly = false)
	public void save(SubMerchant subMerchant) {
		super.save(subMerchant);
	}
	
	@Transactional(readOnly = false)
	public void delete(SubMerchant subMerchant) {
		super.delete(subMerchant);
	}
	
}