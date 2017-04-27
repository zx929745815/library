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
<script src="${path}/library/static/js/jquery-3.1.1.js"></script>
<script src="${path}/library/static/js/pintuer.js"></script>



</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-key" id="test"></span>图书详细</strong>
		</div>
		<div class="body-content">


			<form id="readerinfo"  class="form-x" action="">
				<div class="form-group">
					<div class="label">
						<label for="sitename">图书编号:</label>
					</div>
					<div class="field">
						<label style="line-height:33px;"> ${book.bId} </label>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">ISBN:</label>
					</div>
					<div class="field">
					<label style="line-height:33px;"> ${book.bISBN} </label>
					
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">图书名称：</label>
					</div>
					<div class="field">
					<label style="line-height:33px;"> ${book.bName} </label>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label for="sitename">作者：</label>
					</div>
					<div class="field">
					<label style="line-height:33px;"> ${book.bAuth} </label>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label for="sitename">出版社：</label>
					</div>
					<div class="field">
					<label style="line-height:33px;"> ${book.bPublish}</label>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label for="sitename">类别：</label>
					</div>
					<div class="field">
					<label style="line-height:33px;"> ${book.bType} </label>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label for="sitename">简介：</label>
					</div>
					<div class="field">
					<label style="line-height:33px;"> ${book.bIntro} </label>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label for="sitename">所在馆室：</label>
					</div>
					<div class="field">
					<label style="line-height:33px;"> ${book.bRNo} </label>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button id="back" class="button bg-main"
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
