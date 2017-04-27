<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="${path}/library/static/css/pintuer.css">
<link rel="stylesheet" href="${path}/library/static/css/admin.css">
<script src="${path}/library/static/js/jquery-3.1.1.js"></script>
<script src="${path}/library/static/js/pintuer.js"></script>



</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-key" id="test"></span>个人信息</strong>
		</div>
		<div class="body-content" style="background-color: #EAFBE9">


			<form id="readerinfo" class="form-x" action="">
				<div class="form-group">
					<div class="label">
						<label for="sitename">学号:</label>
					</div>
					<div class="field">
						<label style="line-height:33px;"> ${reader.rNo} </label>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">姓名：</label>
					</div>
					<div class="field">
						<label style="line-height:33px;"> ${reader.rName} </label>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">性别：</label>
					</div>
					<div class="field">
						<label style="line-height:33px;"> ${reader.rSex} </label>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label for="sitename">年级：</label>
					</div>
					<div class="field">
						<c:if test="${reader.rGrade == '1'}">
							<label style="line-height:33px;"> 大一 </label>
						</c:if>
						<c:if test="${reader.rGrade == '2'}">
							<label style="line-height:33px;"> 大二 </label>
						</c:if>
						<c:if test="${reader.rGrade == '3'}">
							<label style="line-height:33px;"> 大三</label>
						</c:if>
						<c:if test="${reader.rGrade == '4'}">
							<label style="line-height:33px;"> 大四 </label>
						</c:if>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label for="sitename">院系：</label>
					</div>
					<div class="field">
						<label style="line-height:33px;"> ${reader.rDept}</label>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label for="sitename">专业：</label>
					</div>
					<div class="field">
						<label style="line-height:33px;"> ${reader.rPref} </label>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button id="back" class="button bg-main "
							type="button">返回</button>
					</div>
				</div>
			</form>
		</div>
	</div>



	<script type="text/javascript">
		$('#back').click(function() {
			window.history.back();
		});
	</script>

</body>
</html>
