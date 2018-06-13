<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>transaction管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnExport").click(function(){
				$.jBox.confirm("确认要导出交易明细数据吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#searchForm").attr("action","${ctx}/jy/transactionDetailed/export");
						$("#searchForm").submit();
					}
				},{buttonsFocus:1});
				top.$('.jbox-body .jbox-icon').css('top','55px');
			});
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/jy/transactionDetailed/list");
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/jy/transactionDetailed/">交易明细查询列表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="jyTransaction" action="${ctx}/jy/transactionDetailed/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li>
				<label>商户号: </label>
					<form:input path="" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li>
				<label>商户名称:  </label>
					<form:input path="" htmlEscape="false" maxlength="64" class="input-medium"/>
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
				<label>终端号: </label>
					<form:input path="terminalNumber" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li>
				<label>参考号: </label>
					<form:input path="consultNumber" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li>
				<label>卡号(末四位): </label>
					<form:input path="cardNumber" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="clearfix"></li>
			<li>
				<label>结算状态: </label>
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
				<th>序号</th>
				<th>交易时间</th>
				<th>商户号</th>
				<th>商户名称</th>
				<th>终端号</th>
				<th>交易类型</th>
				<th>结算模式</th>
				<th>交易卡号</th>
				<th>卡类型</th>
				<th>交易金额</th>
				<th>结算状态</th>
				<shiro:hasPermission name="jy:transactionDetailed:view">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="jyTransaction">
			<tr>
				<td>${jyTransaction.serialNumber}</td>
				<td>
					<fmt:formatDate value="${jyTransaction.transactionDate}" pattern="yyyy-MM-dd"/>
				</td>
				<td></td>
				<td></td>
				<td>${jyTransaction.terminalNumber}</td>
				<td>${jyTransaction.transactionType eq '1'?'消费':'消费'}</td>
				<td>${jyTransaction.settlementModel eq '1'?'D+0':'T+1'}</td>
				<td>${jyTransaction.cardNumber}</td>
				<td>${jyTransaction.cardType eq '1'?'信用卡':'信用卡'}</td>
				<td>${jyTransaction.transactionAmount}</td>
				<td></td>
				<shiro:hasPermission name="jy:transactionDetailed:view">
					<td>
	    				<a href="###">查看详情</a>
	    				<a href="###">下载小票</a>
					</td>
				</shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>