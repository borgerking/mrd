/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mac.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.mac.entity.MacKsn;

/**
 * KSN管理模块DAO接口
 * @author xiax
 * @version 2018-06-06
 */
@MyBatisDao
public interface MacKsnDao extends CrudDao<MacKsn> {
	
}