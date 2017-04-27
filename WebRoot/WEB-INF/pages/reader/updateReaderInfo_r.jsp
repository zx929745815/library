<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<script src="${path}/library/static/js/jquery.js"></script>
<script src="${path}/library/static/js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-key"></span>修改个人信息</strong>
		</div>
		<div class="body-content">


			<form id="readerinfo"  class="form-x" action="">
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
						<input type="text" class="input w50"  name="rName"
							size="50" value="${reader.rName }" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label for="sitename">头像</label>
					</div>
					<div class="field">
						<input type="file" name="logoSrc" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label for="sitename">性别：</label>
					</div>
					<div class="field">
						<input type="radio" name="rSex" value="男" checked="checked"/>男 &nbsp;&nbsp;<input
							type="radio" name="rSex" value="女" />女
					</div>
				</div>
				

				<div class="form-group">
					<div class="label">
						<label for="sitename">年级：</label>
					</div>
					<div class="field">
						<input type="text" name="rGrade" class="input w50" size="50"
							placeholder="${reader.rGrade }">
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label for="sitename">院系：</label>
					</div>
					<div class="field">
						<input type="text" name="rDept" class="input w50" size="50"
							placeholder="${reader.rDept }">

					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label for="sitename">专业：</label>
					</div>
					<div class="field">
						<input type="text" name="rPref" class="input w50" size="50"
							placeholder="${reader.rPref }">

					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button id="update" class="button bg-main icon-check-square-o" type="button">
							提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>

      <script type="text/javascript">	
	$('#update').click(function(){
    var r = $('#readerinfo').serialize();
	$.ajax({
		url: "updateReader.do",
        type: "post",
		data:r, 
		dataType: "json",
		success:function(result) {
		
		if(result.msg == 'success'){
		alert("修改用户信息成功！")
		}else{
		alert("修改失败！");
		}
		},
		error: function(){
			alert("在修改过程中发生了系统错误！");
		}
	});
	});
	</script>

</body>
</html>
