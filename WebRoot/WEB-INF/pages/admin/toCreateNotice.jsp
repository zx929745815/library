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
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>发布通知</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="" id="bookInfo">
				
					<div class="form-group">
					<div class="label">
						<label>发布通知</label>
					</div>
					<div class="field">
					<textarea id="notice" rows="5" cols="70" name="contect" placeholder="请输入你要发布的通知"></textarea>
					</div>
				    </div>
				
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button id="createNotice" class="button bg-main icon-check-square-o" type="button">
							发布</button>
					</div>
				</div>
				
			</form>
		</div>
	</div>

	<script type="text/javascript">
	$("#createNotice").click(function(){
		var data = $("#notice").val();
		
      $.ajax({
        url : "${path }/library/admin/createNotice.do",
        type : "post",
        data : "content="+data,
        dataType : "json",
        success : function(result) {
          if (result.msg) {
            alert("发布通知成功！");
          } else {
            alert("发布通知失败！");
          }
        }
       
      });
	});
	
	
	</script>

</body>
</html>