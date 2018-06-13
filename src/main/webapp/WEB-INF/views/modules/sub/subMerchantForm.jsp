<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>代理商管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sub/subMerchant/">代理商列表</a></li>
		<li class="active"><a href="${ctx}/sub/subMerchant/form?id=${subMerchant.id}">代理商<shiro:hasPermission name="sub:subMerchant:edit">${not empty subMerchant.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sub:subMerchant:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="subMerchant" action="${ctx}/sub/subMerchant/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">代理商编号：</label>
			<div class="controls">
				<form:input path="merchantNo" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">代理商名称：</label>
			<div class="controls">
				<form:input path="merchantName" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">代理商级别：</label>
			<div class="controls">
				<form:select path="merchantLevel" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('merchantLevelState')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">签约人员：</label>
			<div class="controls">
				<sys:treeselect id="user" name="user.id" value="${subMerchant.user.id}" labelName="user.name" labelValue="${subMerchant.user.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">分润模式：</label>
			<div class="controls">
				<form:select path="shareType" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('shareTypeState')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">分润版本：</label>
			<div class="controls">
				<form:select path="shareVersion" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('shareVersionState')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">线上分润模式：</label>
			<div class="controls">
				<form:select path="shareProdVersion" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('shareProdVersionState')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">账号名字：</label>
			<div class="controls">
				<form:input path="accountName" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">可否自定义费率：</label>
			<div class="controls">
				<form:radiobuttons path="customRate" items="${fns:getDictList('customRateState')}" itemLabel="label" itemValue="value" htmlEscape="false" class=""/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">开户行：</label>
			<div class="controls">
				<form:input path="accountBank" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">开户卡号：</label>
			<div class="controls">
				<form:input path="accountCard" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联行号：</label>
			<div class="controls">
				<form:input path="accountStandard" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">账号类型1.对公，2.对私：</label>
			<div class="controls">
				<form:select path="accountType" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('accountTypeState')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">开户省：</label>
			<div class="controls">
				<form:input path="accountProvince" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">开户市：</label>
			<div class="controls">
				<form:input path="accountCity" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">开户区：</label>
			<div class="controls">
				<form:input path="accountArea" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">街道：</label>
			<div class="controls">
				<form:input path="accountStreet" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sub:subMerchant:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>