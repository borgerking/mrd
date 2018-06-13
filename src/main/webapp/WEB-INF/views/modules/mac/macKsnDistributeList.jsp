<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>KSN分发</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$(document).ready(function() {
				$("#btnExport").click(function(){
					top.$.jBox.confirm("确认要导出KSN分发批次数据吗？","系统提示",function(v,h,f){
						if(v=="ok"){
							$("#searchForm").attr("action","${ctx}/mac/macKsnDistribute/export");
							$("#searchForm").submit();
						}
					},{buttonsFocus:1});
					top.$('.jbox-body .jbox-icon').css('top','55px');
				});
				$("#btnImport").click(function(){
					$.jBox($("#importBox").html(), {title:"导入数据", buttons:{"关闭":true}, 
						bottomText:"导入文件不能超过5M，仅允许导入“xls”或“xlsx”格式文件！"});
				});
			});
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/mac/macKsnDistribute/list");
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<div id="importBox" class="hide">
		<form id="importForm" action="${ctx}/mac/macKsnDistribute/import" method="post" enctype="multipart/form-data"
			class="form-search" style="padding-left:20px;text-align:center;" onsubmit="loading('正在导入，请稍等...');"><br/>
			<input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>　　
			<input id="btnImportSubmit" class="btn btn-primary" type="submit" value="   导    入   "/>
			<a href="${ctx}/mac/macKsnDistribute/import/template">下载模板</a>
		</form>
	</div>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/mac/macKsnDistribute/">KSN分发批次列表</a></li>
<%-- 		<shiro:hasPermission name="mac:macKsnDistribute:edit"><li><a href="${ctx}/mac/macKsnDistribute/form">KSN分发添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="macKsnDistribute" action="${ctx}/mac/macKsnDistribute/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li>
				<label>批次号：</label>
					<form:input path="batchNumber" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li>
				<label>服务商名称：</label>
					<form:input path="" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li> 
			<li class="clearfix"></li>
			<li>
				<label>开始时间：</label>
				<input id="beginDate"  name="beginDate"  type="text" readonly="readonly" maxlength="20" class="input-medium Wdate" style="width:163px;"
					value="<fmt:formatDate value="${macKsnDistribute.beginDate}" pattern="yyyy-MM-dd"/>"
						onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
				<label>截至时间：</label>
				<input id="endDate" name="endDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate" style="width:163px;"
					value="<fmt:formatDate value="${macKsnDistribute.endDate}" pattern="yyyy-MM-dd"/>"
						onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
			</li>
			<li class="btns">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
				<input id="btnExport" class="btn btn-primary" type="button" value="导出"/>
				<input id="btnImport" class="btn btn-primary" type="button" value="导入"/>
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>序列号</th>
				<th>批次号</th>
				<th>操作时间</th>
				<th>总数量</th>
				<th>成功数量</th>
				<th>失败数量</th>
				<th>批次状态</th>
				<th>操作人</th>
				<shiro:hasPermission name="mac:macKsnDistribute:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="macKsnDistribute">
			<tr>
				<td></td>
				<td>${macKsnDistribute.batchNumber}</td>
				<td>
					<fmt:formatDate value="${macKsnDistribute.createDate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>${macKsnDistribute.totalCount}</td>
				<td>${macKsnDistribute.successCount}</td>
				<td>${macKsnDistribute.failCount}</td>
				<td>${macKsnDistribute.batchStatus eq '1'?'未完成':'已完成'}</td>
				<td></td>
				<shiro:hasPermission name="mac:macKsnDistribute:edit"><td>
					<a href="${ctx}/mac/macKsnDistribute/form?id=${macKsnDistribute.id}">查看详情</a>
    				<a href="${ctx}/mac/macKsnDistribute/form?id=${macKsnDistribute.id}">修改</a>
					<a href="${ctx}/mac/macKsnDistribute/delete?id=${macKsnDistribute.id}" onclick="return confirmx('确认要删除该KsnDistribute吗？', this.href)">删除</a>
					<a href="${ctx}/mac/macKsnDistribute/form?id=${macKsnDistribute.id}">导出</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>