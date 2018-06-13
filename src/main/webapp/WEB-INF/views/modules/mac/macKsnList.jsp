<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>KSN管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/mac/macKsn/list");
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/mac/macKsn/">KSN列表</a></li>
		<shiro:hasPermission name="mac:macKsn:edit"><li><a href="${ctx}/mac/macKsn/form">KSN添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="macKsn" action="${ctx}/mac/macKsn/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>		
		<ul class="ul-form">
			<li>
				<label>KSN编号：</label>
					<form:input path="ksnCode" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li> 
			<li><label>激活状态：</label>
				<form:select path="activationStatus" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('mac_activation_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>使用状态：</label>
				<form:select path="useStatus" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('mac_use_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>分发状态：</label>
				<form:select path="distributeStatus" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('mac_distribute_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>KSN编号</th>
				<th>业务员</th>
				<th>代理商</th>
				<th>激活状态</th>
				<th>使用状态</th>
				<th>分发状态</th>
				<th>操作人</th>
				<th>最后操作时间</th>
				<shiro:hasPermission name="mac:macKsn:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="macKsn">
			<tr>
				<td>${macKsn.ksnCode}</td>
				<td><a href="${ctx}/sys/user/form?id=${macKsn.user.id}">${macKsn.user.name}</a></td>
				<td>${macKsn.supplierId}</td>
				<td>${macKsn.activationStatus eq '1'?'未激活':'已激活'}</td>
				<td>${macKsn.useStatus eq '1'?'未使用':'已使用'}</td>
				<td>${macKsn.distributeStatus eq '1'?'未分发':'已分发'}</td>
				<td></td>
				<td>
					<fmt:formatDate value="${macKsn.createDate}" pattern="yyyy-MM-dd"/>
				</td>
				<shiro:hasPermission name="mac:macKsn:edit"><td>
    				<a href="${ctx}/mac/macKsn/form?id=${macKsn.ksnId}">修改</a>
					<a href="${ctx}/mac/macKsn/delete?id=${macKsn.ksnId}" onclick="return confirmx('确认要删除该KSN吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>