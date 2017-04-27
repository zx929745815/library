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
.condition{
margin-left: 250px;
margin-top: 150px;
width: 150px;
}
.search{
margin-top: 150px;
}
</style>

</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-key"></span>修改个人信息</strong>
		</div>
		
		<div style="height: 400px;">
		<div class="form-group" >
          <div class="field" >
            <select name="condition" id="condition" class="input w50 condition" >
              <option value="">请选择查询方式</option>
              <option value="byrname" >按姓名</option>
              <option value="byrno">按学号</option>
            </select>
            
          <input type="text" placeholder="请输入搜索关键字" id="keywords" name="keywords" class="input search" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" id="update" class="button border-main icon-search" onclick="changesearch()" > 搜索</a>
          </div>
        </div>
		</div>
	
	</div>
    
    <script type="text/javascript">
    $(document).ready(function(){
	$('#update').click(function(){
	var condition = $('#condition').val();
	var keywords = $('#keywords').val();
	location.href = "http://localhost:8080/library/reader/updateReaderByCondition.do?condition="+condition+"&keywords="+keywords; 
	});    
    });
    </script>
   

</body>
</html>
