<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商户信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnExport").click(function(){
				$.jBox.confirm("确认要导出用户数据吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#searchForm").attr("action","${ctx}/sh/shInfo/export");
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
		<li class="active"><a href="${ctx}/sh/shInfo/">商户信息列表</a></li>
		<shiro:hasPermission name="sh:shInfo:edit"><li><a href="${ctx}/sh/shInfo/form">商户信息添加</a></li></shiro:hasPermission>
	</ul>
	<div id="importBox" class="hide">
		<form id="importForm" action="${ctx}/sh/shInfo/import" method="post" enctype="multipart/form-data"
			class="form-search" style="padding-left:20px;text-align:center;" onsubmit="loading('正在导入，请稍等...');"><br/>
			<input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>　　
			<input id="btnImportSubmit" class="btn btn-primary" type="submit" value="导    入   "/>
			<a href="${ctx}/sh/shInfo/import/template">下载模板</a>
		</form>
	</div>
	<form:form id="searchForm" modelAttribute="shInfo" action="${ctx}/sh/shInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>商户名称：</label>
				<form:input path="shMc" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>商户号：</label>
				<form:input path="shCode" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>商户姓名：</label>
				<form:input path="shName" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>手机号：</label>
				<form:input path="phone" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>结算产品：</label>
				<form:input path="jsCp" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>所属代理商：</label>
				<sys:treeselect id="agent" name="agent.id" value="${shInfo.agent.id}" labelName="agent.name" labelValue="${shInfo.agent.name}"
					title="代理商" url="/sys/office/treeData?type=4" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>维护业务员：</label>
				<sys:treeselect id="user" name="user.id" value="${shInfo.user.id}" labelName="user.name" labelValue="${shInfo.user.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>开通状态：</label>
				<form:select path="ktState" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('kt_state')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>商户状态：</label>
				<form:select path="shState" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sh_state')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>ksn编号：</label>
				<form:input path="ksnCode" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>序列号：</label>
				<form:input path="xlNumber" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>注册时间：</label>
				<input name="beginZcDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${shInfo.beginZcDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endZcDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${shInfo.endZcDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>开通时间：</label>
				<input name="beginKtDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${shInfo.beginKtDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endKtDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${shInfo.endKtDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			<input id="btnExport" class="btn btn-primary" type="button" value="导出"/>
				<input id="btnImport" class="btn btn-primary" type="button" value="导入"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>商户名称</th>
				<th>商户号</th>
				<th>商户姓名</th>
				<th>手机号</th>
				<th>结算模式</th>
				<th>结算产品</th>
				<th>所属代理商</th>
				<th>维护业务员</th>
				<th>开通状态</th>
				<th>商户状态</th>
				<th>ksn编号</th>
				<th>序列号</th>
				<th>结算卡号</th>
				<th>注册时间</th>
				<th>开通时间</th>
				<shiro:hasPermission name="sh:shInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="shInfo">
			<tr>
				<td><a href="${ctx}/sh/shInfo/form?id=${shInfo.id}">
					${shInfo.shMc}
				</a></td>
				<td>
					${shInfo.shCode}
				</td>
				<td>
					${shInfo.shName}
				</td>
				<td>
					${shInfo.phone}
				</td>
				<td>
					${shInfo.jsMode}
				</td>
				<td>
					${shInfo.jsCp}
				</td>
				<td>
				<sys:treeselect id="agent${shInfo.agent.id}" name="agent${shInfo.agent.id}.id" value="${shInfo.agent.id}" labelName="agent${shInfo.agent.id}.name" labelValue="${shInfo.agent.name}"
					title="代理商" url="/sys/office/treeData?type=4" cssClass="" allowClear="false" notAllowSelectParent="true"/>
				 <%--   <a href="${ctx}/sys/office/form?id=${shInfo.agent.id}">
					${shInfo.agent.name}
				</a> --%>
				</td>
				<td>
					${shInfo.user.name}
				</td>
				<td>
					${fns:getDictLabel(shInfo.ktState, 'kt_state', '')}
				</td>
				<td>
					${fns:getDictLabel(shInfo.shState, 'sh_state', '')}
				</td>
				<td>
					${shInfo.ksnCode}
				</td>
				<td>
					${shInfo.xlNumber}
				</td>
				<td>
					${shInfo.jsCode}
				</td>
				<td>
					<fmt:formatDate value="${shInfo.zcDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${shInfo.ktDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="sh:shInfo:edit"><td>
    				<a href="${ctx}/sh/shInfo/form?id=${shInfo.id}">修改</a>
					<a href="${ctx}/sh/shInfo/delete?id=${shInfo.id}" onclick="return confirmx('确认要删除该商户功能模块吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>