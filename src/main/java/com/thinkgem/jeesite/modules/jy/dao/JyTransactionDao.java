/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.jy.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.jy.entity.JyTransaction;

/**
 * 按商户汇总DAO接口
 * @author xiax
 * @version 2018-06-09
 */
@MyBatisDao
public interface JyTransactionDao extends CrudDao<JyTransaction> {
	
}