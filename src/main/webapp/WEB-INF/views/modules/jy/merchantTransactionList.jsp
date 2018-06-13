<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>transaction管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
			$(document).ready(function() {
				$("#btnExport").click(function(){
					$.jBox.confirm("确认要导出商户交易数据吗？","系统提示",function(v,h,f){
						if(v=="ok"){
							$("#searchForm").attr("action","${ctx}/jy/merchantTransaction/export");
							$("#searchForm").submit();
						}
					},{buttonsFocus:1});
					top.$('.jbox-body .jbox-icon').css('top','55px');
				});
			});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/jy/merchantTransaction/list");
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/jy/merchantTransaction/">商户汇总查询列表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="jyTransaction" action="${ctx}/jy/merchantTransaction/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li>
				<label>商户号: </label>
					<form:input path="shInfo.shCode" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li>
				<label>商户名称:  </label>
					<form:input path="shInfo.shMc" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li>
				<label>交易日期：</label>
				<input id="jyBeginDate"  name="jyBeginDate"  type="text" readonly="readonly" maxlength="20" class="input-medium Wdate" style="width:163px;"
					value="<fmt:formatDate value="${jyTransaction.jyBeginDate}" pattern="yyyy-MM-dd"/>"
						onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
						--
				<input id="jyEndDate" name="jyEndDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate" style="width:163px;"
					value="<fmt:formatDate value="${jyTransaction.jyEndDate}" pattern="yyyy-MM-dd"/>"
						onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
			</li>
			<li class="clearfix"></li>
			<li>
				<label>KSN编号: </label>
					<form:input path="ksnCode" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li>
				<label>结算类型: </label> 
				<form:select path="settlementModel"
 					class="input-medium"> 
					<form:option value="" label="" /> 
 					<form:options items="${fns:getDictList('jy_settlement_type')}" 
 						itemLabel="label" itemValue="value" htmlEscape="false" /> 
 				</form:select>
 			</li> 
			<li>
				<label>结算周期: </label>
					<form:input path="" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
				<input id="btnExport" class="btn btn-primary" type="button" value="导出"/>
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>交易日期</th>
				<th>商户号</th>
				<th>商户名称</th>
				<th>KSN号</th>
				<th>结算模式</th>
				<th>支付模式</th>
				<th>借记卡费率</th>
				<th>贷记卡费率</th>
				<th>其他银联卡费率</th>
<%-- 				<shiro:hasPermission name="jy:jyTransaction:edit"> --%>
<!-- 					<th>操作</th> -->
<%-- 				</shiro:hasPermission> --%>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jyTransaction">
			<tr>
				<td>
					<fmt:formatDate value="${jyTransaction.transactionDate}" pattern="yyyy-MM-dd"/>
				</td>
				<td></td>
				<td></td>
				<td>${jyTransaction.ksnCode}</td>
				<td>${jyTransaction.settlementModel eq '1'?'D+0':'T+1'}</td>
				<td>${jyTransaction.paymentMode}</td>
				<td>${jyTransaction.debitCardRate}</td>
				<td>${jyTransaction.loanCardRate}</td>
				<td>${jyTransaction.otherCardRate}</td>
<%-- 				<shiro:hasPermission name="jy:jyTransaction:edit"> --%>
<!-- 					<td> -->
<%-- 	    				<a href="${ctx}/jy/jyTransaction/form?id=${jyTransaction.id}">修改</a> --%>
<%-- 						<a href="${ctx}/jy/jyTransaction/delete?id=${jyTransaction.id}" onclick="return confirmx('确认要删除该transaction吗？', this.href)">删除</a> --%>
<!-- 					</td> -->
<%-- 				</shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>