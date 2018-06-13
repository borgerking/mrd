/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.jy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.jy.entity.JyTransaction;
import com.thinkgem.jeesite.modules.jy.dao.JyTransactionDao;

/**
 * 按商户汇总Service
 * @author xiax
 * @version 2018-06-09
 */
@Service
@Transactional(readOnly = true)
public class JyTransactionService extends CrudService<JyTransactionDao, JyTransaction> {

	public JyTransaction get(String id) {
		return super.get(id);
	}
	
	public List<JyTransaction> findList(JyTransaction jyTransaction) {
		return super.findList(jyTransaction);
	}
	
	public Page<JyTransaction> findPage(Page<JyTransaction> page, JyTransaction jyTransaction) {
		return super.findPage(page, jyTransaction);
	}
	
	@Transactional(readOnly = false)
	public void save(JyTransaction jyTransaction) {
		super.save(jyTransaction);
	}
	
	@Transactional(readOnly = false)
	public void delete(JyTransaction jyTransaction) {
		super.delete(jyTransaction);
	}
	
}