/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mac.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.mac.entity.MacKsn;
import com.thinkgem.jeesite.modules.mac.service.MacKsnService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * KSN管理模块Controller
 * @author xiax
 * @version 2018-06-06
 */
@Controller
@RequestMapping(value = "${adminPath}/mac/macKsn")
public class MacKsnController extends BaseController {

	@Autowired
	private MacKsnService macKsnService;
	
	@ModelAttribute
	public MacKsn get(@RequestParam(required=false) String id) {
		MacKsn entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = macKsnService.get(id);
		}
		if (entity == null){
			entity = new MacKsn();
		}
		return entity;
	}
	
	@RequiresPermissions("mac:macKsn:view")
	@RequestMapping(value = {"list", ""})
	public String list(MacKsn macKsn, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MacKsn> page = macKsnService.findPage(new Page<MacKsn>(request, response), macKsn); 
		model.addAttribute("page", page);
		return "modules/mac/macKsnList";
	}

	@RequiresPermissions("mac:macKsn:view")
	@RequestMapping(value = "form")
	public String form(MacKsn macKsn, Model model) {
		model.addAttribute("macKsn", macKsn);
		return "modules/mac/macKsnForm";
	}

	@RequiresPermissions("mac:macKsn:edit")
	@RequestMapping(value = "save")
	public String save(MacKsn macKsn, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, macKsn)){
			return form(macKsn, model);
		}
		
		String userID = UserUtils.getUser().getId();
		if (StringUtils.isEmpty(macKsn.getKsnId())) {
			macKsn.setCreateUserId(userID);
		}
		else {
			macKsn.setUpdateUserId(userID);
		}
		
		macKsnService.save(macKsn);
		
		addMessage(redirectAttributes, "保存KSN成功");
		
		return "redirect:"+Global.getAdminPath()+"/mac/macKsn/?repage";
	}
	
	@RequiresPermissions("mac:macKsn:edit")
	@RequestMapping(value = "delete")
	public String delete(MacKsn macKsn, RedirectAttributes redirectAttributes) throws Exception{
		
		String kansID = macKsn.getKsnId();
		if(StringUtils.isEmpty(kansID)) {
			
		}
		
		macKsnService.delete(macKsn);
		addMessage(redirectAttributes, "删除KSN成功");
		return "redirect:"+Global.getAdminPath()+"/mac/macKsn/?repage";
	}

}