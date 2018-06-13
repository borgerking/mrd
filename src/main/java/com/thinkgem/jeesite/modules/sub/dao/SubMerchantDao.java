/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sub.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sub.entity.SubMerchant;

/**
 * 代理商DAO接口
 * @author 代理商
 * @version 2018-06-10
 */
@MyBatisDao
public interface SubMerchantDao extends CrudDao<SubMerchant> {
	
}