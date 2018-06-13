/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sub.web;

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
import com.thinkgem.jeesite.modules.sub.entity.SubMerchant;
import com.thinkgem.jeesite.modules.sub.service.SubMerchantService;

/**
 * 代理商Controller
 * @author 代理商
 * @version 2018-06-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sub/subMerchant")
public class SubMerchantController extends BaseController {

	@Autowired
	private SubMerchantService subMerchantService;
	
	@ModelAttribute
	public SubMerchant get(@RequestParam(required=false) String id) {
		SubMerchant entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = subMerchantService.get(id);
		}
		if (entity == null){
			entity = new SubMerchant();
		}
		return entity;
	}
	
	@RequiresPermissions("sub:subMerchant:view")
	@RequestMapping(value = {"list", ""})
	public String list(SubMerchant subMerchant, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SubMerchant> page = subMerchantService.findPage(new Page<SubMerchant>(request, response), subMerchant); 
		model.addAttribute("page", page);
		return "modules/sub/subMerchantList";
	}

	@RequiresPermissions("sub:subMerchant:view")
	@RequestMapping(value = "form")
	public String form(SubMerchant subMerchant, Model model) {
		model.addAttribute("subMerchant", subMerchant);
		return "modules/sub/subMerchantForm";
	}

	@RequiresPermissions("sub:subMerchant:edit")
	@RequestMapping(value = "save")
	public String save(SubMerchant subMerchant, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, subMerchant)){
			return form(subMerchant, model);
		}
		subMerchantService.save(subMerchant);
		addMessage(redirectAttributes, "保存代理商成功");
		return "redirect:"+Global.getAdminPath()+"/sub/subMerchant/?repage";
	}
	
	@RequiresPermissions("sub:subMerchant:edit")
	@RequestMapping(value = "delete")
	public String delete(SubMerchant subMerchant, RedirectAttributes redirectAttributes) {
		subMerchantService.delete(subMerchant);
		addMessage(redirectAttributes, "删除代理商成功");
		return "redirect:"+Global.getAdminPath()+"/sub/subMerchant/?repage";
	}

}