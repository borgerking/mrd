/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.jy.web;

import java.util.ArrayList;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.modules.jy.entity.JyTransaction;
import com.thinkgem.jeesite.modules.jy.service.JyTransactionService;
import com.thinkgem.jeesite.modules.jy.vo.MerchantVo;
import com.thinkgem.jeesite.modules.mac.entity.MacKsnDistribute;
import com.thinkgem.jeesite.modules.sh.entity.ShInfo;

/**
 * 按商户汇总Controller
 * @author xiax
 * @version 2018-06-09
 */
@Controller
@RequestMapping(value = "${adminPath}/jy/merchantTransaction")
public class MerchantTransactionController extends BaseController {

	@Autowired
	private JyTransactionService jyTransactionService;
	
	@ModelAttribute
	public JyTransaction get(@RequestParam(required=false) String id) {
		JyTransaction entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jyTransactionService.get(id);
		}
		if (entity == null){
			entity = new JyTransaction();
		}
		return entity;
	}
	
	@RequiresPermissions("jy:merchantTransaction:view")
	@RequestMapping(value = {"list", ""})
	public String list(JyTransaction jyTransaction, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JyTransaction> page = jyTransactionService.findPage(new Page<JyTransaction>(request, response), jyTransaction); 
		model.addAttribute("page", page);
		return "modules/jy/merchantTransactionList";
	}
	
	/**
	 * 导出商户交易数据
	 * @param jyTransaction
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("jy:merchantTransaction:view")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(JyTransaction jyTransaction, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "商户交易数据"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<JyTransaction> page = jyTransactionService.findPage(new Page<JyTransaction>(request, response, -1), jyTransaction);
            List<JyTransaction> list=page.getList();
            List<MerchantVo> plist=new ArrayList<MerchantVo>();
            if(list.size()>0) {
            	for(JyTransaction sa:list) {
            		
            		String shCode = "";
            		String shMc = "";
            		ShInfo shInfo = sa.getShInfo();
            		if (null != shInfo) {
            			shCode = shInfo.getShCode();
            			shMc = shInfo.getShMc();
            		}
            		
            		MerchantVo vo=new MerchantVo(sa.getTransactionDate(),shCode,shMc
            				,sa.getKsnCode(),sa.getSettlementModel(),sa.getPaymentMode());
            		plist.add(vo);
            	}
            }
            new ExportExcel("商户交易数据", MerchantVo.class).setDataList(plist).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出数据失败！失败信息："+e.getMessage());
		}
		return "redirect:" + adminPath + "/jy/merchantTransactionList/list?repage";
    }

//	@RequiresPermissions("jy:merchantTransaction:view")
//	@RequestMapping(value = "form")
//	public String form(JyTransaction jyTransaction, Model model) {
//		model.addAttribute("jyTransaction", jyTransaction);
//		return "modules/jy/jyTransactionForm";
//	}

//	@RequiresPermissions("jy:jyTransaction:edit")
//	@RequestMapping(value = "save")
//	public String save(JyTransaction jyTransaction, Model model, RedirectAttributes redirectAttributes) {
//		if (!beanValidator(model, jyTransaction)){
//			return form(jyTransaction, model);
//		}
//		jyTransactionService.save(jyTransaction);
//		addMessage(redirectAttributes, "保存transaction成功");
//		return "redirect:"+Global.getAdminPath()+"/jy/jyTransaction/?repage";
//	}
//	
//	@RequiresPermissions("jy:jyTransaction:edit")
//	@RequestMapping(value = "delete")
//	public String delete(JyTransaction jyTransaction, RedirectAttributes redirectAttributes) {
//		jyTransactionService.delete(jyTransaction);
//		addMessage(redirectAttributes, "删除transaction成功");
//		return "redirect:"+Global.getAdminPath()+"/jy/jyTransaction/?repage";
//	}

}