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


	 <button class="button bg-main " type="button" id="byHand"> 手动增加</button>  
	 <button class="button bg-main " type="button" id="auto"> 校园卡扫描</button>  




	<div class="panel admin-panel"  id="addReader">
		<div class="panel-head">
			<strong><span class="icon-key"></span>添加读者</strong>
		</div>
		<div class="body-content">


			<form id="readerinfo"  class="form-x" action="">
				<div class="form-group">
					<div class="label">
						<label for="sitename">学号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50"  name="rNo"
							size="50" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="sitename">姓名：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50"  name="rName"
							size="50"  />
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
						<label>年级：</label>
					</div>
					<div class="field">
						<select name="rGrade" class="input w50">
							<option value="">请选择年级</option>
							<option value="1">大一</option>
							<option value="2">大二</option>
							<option value="3">大三</option>
							<option value="4">大四</option>
							<option value="5">研一</option>
							<option value="6">研二</option>
							<option value="7">研三</option>
						</select>
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label for="sitename">院系：</label>
					</div>
					<div class="field">
						<input type="text" name="rDept" class="input w50" size="50">
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label for="sitename">专业：</label>
					</div>
					<div class="field">
						<input type="text" name="rPref" class="input w50" size="50">
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
	
	<div class="panel admin-panel"  id="scanner" hidden="hidden">
		<div class="panel-head">
			<strong><span class="icon-key"></span>添加读者</strong>
		</div>
	<div  style="text-align: center; height: 200px; padding-top: 90px;">
	<h1>请扫描学生的校园卡。</h1>
	</div>
    </div>
      <script type="text/javascript">
      
      $(document).ready(function(){
      
      $('#byHand').click(function(){
      	$('#addReader').show(200);
      	$('#scanner').hide(200);
      	
      });
      
      $('#auto').click(function(){
      	$('#scanner').show(200);
      	$('#addReader').hide(200);
      });  
      });
      
      	
	$('#update').click(function(){
    var readerInfo = $('#readerinfo').serialize();
	$.ajax({
		url: "/library/reader/addReader.do",
        type: "post",
		data:readerInfo, 
		dataType: "json",
		
		success:function(result) {
		if(result.msg){
		alert("添加成功！")
		}else{
		alert("添加失败！");
		}
		},
		
		error: function(){
			alert("在添加过程中发生了系统错误！");
		}
	});
	});
	</script>

</body>
</html>
