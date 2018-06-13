/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sh.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.beanvalidator.BeanValidators;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.common.utils.excel.ImportExcel;
import com.thinkgem.jeesite.modules.sh.entity.ShInfo;
import com.thinkgem.jeesite.modules.sh.service.ShInfoService;

/**
 * 商户管理Controller
 * @author borger
 * @version 2018-06-06
 */
@Controller
@RequestMapping(value = "${adminPath}/sh/shInfo")
public class ShInfoController extends BaseController {

	@Autowired
	private ShInfoService shInfoService;
	
	@ModelAttribute
	public ShInfo get(@RequestParam(required=false) String id) {
		ShInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = shInfoService.get(id);
		}
		if (entity == null){
			entity = new ShInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("sh:shInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(ShInfo shInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ShInfo> page = shInfoService.findPage(new Page<ShInfo>(request, response), shInfo); 
		model.addAttribute("page", page);
		return "modules/sh/shInfoList";
	}

	@RequiresPermissions("sh:shInfo:view")
	@RequestMapping(value = "form")
	public String form(ShInfo shInfo, Model model) {
		model.addAttribute("shInfo", shInfo);
		return "modules/sh/shInfoForm";
	}

	@RequiresPermissions("sh:shInfo:edit")
	@RequestMapping(value = "save")
	public String save(ShInfo shInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, shInfo)){
			return form(shInfo, model);
		}
		shInfoService.save(shInfo);
		addMessage(redirectAttributes, "保存商户信息成功");
		return "redirect:"+Global.getAdminPath()+"/sh/shInfo/?repage";
	}
	
	@RequiresPermissions("sh:shInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(ShInfo shInfo, RedirectAttributes redirectAttributes) {
		shInfoService.delete(shInfo);
		addMessage(redirectAttributes, "删除商户信息成功");
		return "redirect:"+Global.getAdminPath()+"/sh/shInfo/?repage";
	}
	
	/**
	 * 导出商户数据
	 * @param ShInfo
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("sh:shInfo:view")
    @RequestMapping(value = "export")
    public String exportFile(ShInfo shInfo, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "商户数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<ShInfo> page = shInfoService.findPage(new Page<ShInfo>(request, response, -1), shInfo);
    		new ExportExcel("商户数据", ShInfo.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出用户失败！失败信息："+e.getMessage());
		}
		return "redirect:" + Global.getAdminPath() + "/sh/shInfo/?repage";
    }

	/**
	 * 导入商户数据
	 * @param file
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("sh:shInfo:edit")
    @RequestMapping(value = "import")
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<ShInfo> list = ei.getDataList(ShInfo.class);
			for (ShInfo shInfo : list){
				try{
					BeanValidators.validateWithException(validator, shInfo);
					shInfoService.save(shInfo);
					successNum++;
				}catch (Exception ex) {
					failureMsg.append("<br/>商户名 "+shInfo.getShName()+" 导入失败："+ex.getMessage());
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条商户，导入信息如下：");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条商户"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入商户失败！失败信息："+e.getMessage());
		}
		return "redirect:" + Global.getAdminPath() + "/sh/shInfo/?repage";
    }
	
	/**
	 * 下载导入商户数据模板
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("sh:shInfo:view")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "商户数据导入模板.xlsx";
    		List<ShInfo> list = Lists.newArrayList(); list.add(new ShInfo());
    		new ExportExcel("商户数据", ShInfo.class, 2).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:" + Global.getAdminPath() + "/sh/shInfo/?repage";
    }

}