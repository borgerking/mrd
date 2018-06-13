<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>代理商管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sub/subMerchant/">代理商列表</a></li>
		<shiro:hasPermission name="sub:subMerchant:edit"><li><a href="${ctx}/sub/subMerchant/form">代理商添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="subMerchant" action="${ctx}/sub/subMerchant/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>代理商编号：</label>
				<form:input path="merchantNo" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>代理商名称：</label>
				<form:input path="merchantName" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>代理商级别：</label>
				<form:select path="merchantLevel" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('merchantLevelState')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>签约人员：</label>
				<sys:treeselect id="user" name="user.id" value="${subMerchant.user.id}" labelName="user.name" labelValue="${subMerchant.user.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>分润模式：</label>
				<form:select path="shareType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('shareTypeState')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>分润版本：</label>
				<form:select path="shareVersion" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('shareVersionState')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>线上分润模式：</label>
				<form:select path="shareProdVersion" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('shareProdVersionState')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>可否自定义费率：</label>
				<form:radiobuttons path="customRate" items="${fns:getDictList('customRateState')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li><label>创建时间：</label>
				<input name="beginCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${subMerchant.beginCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${subMerchant.endCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>代理商编号</th>
				<th>代理商名称</th>
				<th>代理商级别</th>
				<th>签约人员</th>
				<th>分润模式</th>
				<th>分润版本</th>
				<th>线上分润模式</th>
				<th>可否自定义费率</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="sub:subMerchant:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="subMerchant">
			<tr>
				<td><a href="${ctx}/sub/subMerchant/form?id=${subMerchant.id}">
					${subMerchant.merchantNo}
				</a></td>
				<td>
					${subMerchant.merchantName}
				</td>
				<td>
					${fns:getDictLabel(subMerchant.merchantLevel, 'merchantLevelState', '')}
				</td>
				<td>
					${subMerchant.user.name}
				</td>
				<td>
					${fns:getDictLabel(subMerchant.shareType, 'shareTypeState', '')}
				</td>
				<td>
					${fns:getDictLabel(subMerchant.shareVersion, 'shareVersionState', '')}
				</td>
				<td>
					${fns:getDictLabel(subMerchant.shareProdVersion, 'shareProdVersionState', '')}
				</td>
				<td>
					${fns:getDictLabel(subMerchant.customRate, 'customRateState', '')}
				</td>
				<td>
					<fmt:formatDate value="${subMerchant.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${subMerchant.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${subMerchant.remarks}
				</td>
				<shiro:hasPermission name="sub:subMerchant:edit"><td>
    				<a href="${ctx}/sub/subMerchant/form?id=${subMerchant.id}">修改</a>
					<a href="${ctx}/sub/subMerchant/delete?id=${subMerchant.id}" onclick="return confirmx('确认要删除该代理商吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>