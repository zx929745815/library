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

<style type="text/css">
.info {
	margin-left: 60px;
	font-size: 25px;
	color: green;
}
</style>

</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-barcode"></span>&nbsp;&nbsp;图书借阅</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="" id="">

				<div style="margin-left: 220px;margin-top: 40px;">
					<div class="form-group">
						<div class="label">
							<label for="sitename">ISBN：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" id="ISBN" size="50"
								placeholder="ISBN" data-validate="required:请输入ISBN" />
						</div>
					</div>

					<div class="form-group">
						<div class="label">
							<label for="sitename">学号：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" id="RNO" size="50"
								placeholder="学号" data-validate="required:请输入学号" />
						</div>
					</div>

					<div class="form-group" >
						<div class="label">
							<label></label>
						</div>
						<div class="field">
							<button class="button bg-main icon-check-square-o" type="button"
								id="borrow">借出</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#borrow').click(function() {
				var ISBN = $('#ISBN').val();
				var RNO = $('#RNO').val();
	
				$.ajax({
					url : "/library/reader/borrowBook.do",
					type : "post",
					data : "ISBN=" + ISBN + "&RNO=" + RNO,
					dataType : "json",
					success : function(result) {
						if (result.msg) {
							alert("借阅成功！");
						} else {
							alert("借阅失败！");
						}
					},
					error : function() {
						alert("出现了系统错误！");
					}
				});
	
	
	
	
			});
		});
	</script>


</body>
</html>
