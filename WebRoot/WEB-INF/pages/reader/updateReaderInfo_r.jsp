<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet" href="${path}/library/static/css/sweetalert.css">
<script src="${path}/library/static/js/jquery-3.1.1.js"></script>
<script src="${path}/library/static/js/jquery.form.js"></script>
<script src="${path}/library/static/js/pintuer.js"></script>
<script src="${path}/library/static/js/sweetalert.min.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-key"></span>修改个人信息</strong>
		</div>
		<div class="body-content">


			<form role="form" id="readerinfo" name="readerinfo"
				enctype="multipart/form-data" class="form-x" action="" method="post">
				<div class="form-group">
					<div class="label">
						<label for="sitename">学号：</label>
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
						<input type="text" class="input w50" name="rName" size="50"
							value="${reader.rName }" />
					</div>
				</div>



				<div class="form-group">
					<div class="label">
						<label for="sitename">头&nbsp;&nbsp;像:</label>
					</div>
					<div class="field">
						<c:if test="${not empty reader.logoSrc}">
							<img width="100px;" alt="头像" src="/pic/logo/${reader.logoSrc }">
							<br>
						</c:if>
						<input type="file" name="tmpFile" />
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label for="sitename">性别：</label>
					</div>
					<div class="field">
						<input type="radio" name="rSex" value="男" checked="checked" />男
						&nbsp;&nbsp;<input type="radio" name="rSex" value="女" />女
					</div>
				</div>


				<div class="form-group">
					<div class="label">
						<label for="sitename">年级：</label>
					</div>
					<div class="field">
						<input type="text" name="rGrade" class="input w50" size="50"
							value="${reader.rGrade }">
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label for="sitename">院系：</label>
					</div>
					<div class="field">
						<input type="text" name="rDept" class="input w50" size="50"
							value="${reader.rDept }">

					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label for="sitename">专业：</label>
					</div>
					<div class="field">
						<input type="text" name="rPref" class="input w50" size="50"
							value="${reader.rPref }">

					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<input id="update" class="button bg-main icon-check-square-o"
							type="submit" value="提交">
					</div>
				</div>
			</form>
		</div>
	</div>

	<script type="text/javascript">
		$('#update').click(function() {
			$('#readerinfo').ajaxSubmit({
				type : 'post',
				url : 'updateReader.do',
				
				success : function(data) {
					if (data.msg == 'success') {
						swal("修改用户信息成功！");
					} else {
						swal("修改用户信息失败！");
					}
				}
			});
		});
	</script>
</body>
</html>
