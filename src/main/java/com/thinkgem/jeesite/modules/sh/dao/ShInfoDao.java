/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sh.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sh.entity.ShInfo;

/**
 * 商户管理DAO接口
 * @author borger
 * @version 2018-06-06
 */
@MyBatisDao
public interface ShInfoDao extends CrudDao<ShInfo> {
	
}