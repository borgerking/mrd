/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.mac.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
import com.thinkgem.jeesite.modules.mac.entity.MacKsnDistribute;
import com.thinkgem.jeesite.modules.mac.service.MacKsnDistributeService;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * KSN分发Controller
 * @author xiax
 * @version 2018-06-08
 */
@Controller
@RequestMapping(value = "${adminPath}/mac/macKsnChange")
public class MacKsnChangeController extends BaseController {

	@Autowired
	private MacKsnDistributeService macKsnDistributeService;
	
	@ModelAttribute
	public MacKsnDistribute get(@RequestParam(required=false) String id) {
		MacKsnDistribute entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = macKsnDistributeService.get(id);
		}
		if (entity == null){
			entity = new MacKsnDistribute();
		}
		return entity;
	}
	
	@RequiresPermissions("mac:macKsnChange:view")
	@RequestMapping(value = {"list", ""})
	public String list(MacKsnDistribute macKsnDistribute, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MacKsnDistribute> page = macKsnDistributeService.findPage(new Page<MacKsnDistribute>(request, response), macKsnDistribute); 
		model.addAttribute("page", page);
		return "modules/mac/macKsnChangeList";
	}

//	@RequiresPermissions("mac:macKsnChange:view")
//	@RequestMapping(value = "form")
//	public String form(MacKsnDistribute macKsnDistribute, Model model) {
//		model.addAttribute("macKsnDistribute", macKsnDistribute);
//		return "modules/mac/macKsnDistributeForm";
//	}

//	@RequiresPermissions("mac:macKsnChange:edit")
//	@RequestMapping(value = "save")
//	public String save(MacKsnDistribute macKsnDistribute, Model model, RedirectAttributes redirectAttributes) {
//		if (!beanValidator(model, macKsnDistribute)){
//			return form(macKsnDistribute, model);
//		}
//		macKsnDistributeService.save(macKsnDistribute);
//		addMessage(redirectAttributes, "保存KsnDistribute成功");
//		return "redirect:"+Global.getAdminPath()+"/mac/macKsnDistribute/?repage";
//	}
	
	@RequiresPermissions("mac:macKsnChange:edit")
	@RequestMapping(value = "delete")
	public String delete(MacKsnDistribute macKsnDistribute, RedirectAttributes redirectAttributes) {
		macKsnDistributeService.delete(macKsnDistribute);
		addMessage(redirectAttributes, "删除KsnDistribute成功");
		return "redirect:"+Global.getAdminPath()+"/mac/macKsnDistribute/?repage";
	}
	
	/**
	 * 导出KSN分发批次数据
	 * @param macKsnDistribute
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("mac:macKsnChange:view")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(MacKsnDistribute macKsnDistribute, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "KSN分发批次数据"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<MacKsnDistribute> page = macKsnDistributeService.findPage(new Page<MacKsnDistribute>(request, response, -1), macKsnDistribute);
    		new ExportExcel("KSN分发批次数据", MacKsnDistribute.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出数据失败！失败信息："+e.getMessage());
		}
		return "redirect:" + adminPath + "/mac/macKsnDistribute/list?repage";
    }
	
	/**
	 * 导入入KSN分发批次数据
	 * @param file
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("mac:macKsnChange:edit")
    @RequestMapping(value = "import", method=RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<MacKsnDistribute> list = ei.getDataList(MacKsnDistribute.class);
			for (MacKsnDistribute macKsnDistribute : list){
				try{
					BeanValidators.validateWithException(validator, macKsnDistribute);
					macKsnDistributeService.save(macKsnDistribute);
					successNum++;
				}catch (Exception ex) {
					failureMsg.append("<br/>KSN批次号 "+ macKsnDistribute.getBatchNumber() +" 导入失败："+ ex.getMessage());
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条KSN，导入信息如下：");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条KSN"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入KSN分发批次失败！失败信息："+e.getMessage());
		}
		return "redirect:" + Global.getAdminPath() + "/mac/macKsnDistribute/list?repage";
    }
	
	/**
	 * 下载导入KSN分发批次数据模板
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("mac:macKsnChange:view")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "KSN分发批次导入模板.xlsx";
    		List<MacKsnDistribute> list = Lists.newArrayList(); list.add(new MacKsnDistribute());
    		new ExportExcel("KSN分发批次数据", MacKsnDistribute.class, 2).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:" + Global.getAdminPath() + "/mac/macKsnDistribute/list?repage";
    }
}