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
			<strong><span class="icon-key"></span>修改书籍信息</strong>
		</div>
		<div class="body-content">


			<form id="bookinfo"  class="form-x" action="">
				
				<div class="body-content">
				
				<div class="form-group" hidden="hidden">
					<div class="label">
						<label>id：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${book.bId }" name="bId"
							data-validate="required:请输入图书编号" />
						<div class="tips"></div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>图书编号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${book.bNo }" name="bNo"
							data-validate="required:请输入图书编号" />
						<div class="tips"></div>
					</div>
				</div>

				<!--    <div class="form-group">
        <div class="label">
          <label>图书图片：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="img" class="input tips" style="width:25%; float:left;"  value=""  data-toggle="hover" data-place="right" data-image="" />
          <input type="button" class="button bg-blue margin-left" id="image1" value="+ 浏览上传"  style="float:left;">
          <div class="tipss">图片尺寸：500*500</div>
        </div>
      </div>   -->

				<div class="form-group">
					<div class="label">
						<label>ISBN：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${book.bISBN }" name="bISBN"
							data-validate="required:请输入图书ISBN" />
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>图书书名：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${book.bName }" name="bName"
							data-validate="required:请输入图书书名" />
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>图书作者：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${book.bAuth }" name="bAuth"
							data-validate="required:请输入图书作者" />
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>图书价格：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${book.bPrice }" name="bPrice"
							data-validate="required:请输入图书价格" />
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>图书出版社：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${book.bPublish }" name="bPublish"
							data-validate="required:请输入图出版社" />
						<div class="tips"></div>
					</div>
				</div>


				<div class="form-group">
					<div class="label">
						<label>图书分类：</label>
					</div>
					<div class="field">
						<select name="bType" class="input w50">
							<option value="计算机">请选择分类</option>
							<option value="计算机">计算机</option>
							<option value="文学">文学</option>
							<option value="哲学">哲学</option>
							<option value="自然">自然</option>
						</select>
						<div class="tips"></div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>数量：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${book.bTol }" name="bTol"
							data-validate="required:请输入图书数量" />
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>是否可借：</label>
					</div>
					<div class="field" style="padding-top:8px;">
						<input type="radio" name="bState" value="1" checked="checked"/>可借&nbsp;&nbsp; <input
							type="radio" name="bState" value="1" />不可借&nbsp;&nbsp;
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>所在馆室：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${book.bRNo }" name="bRNo"
							data-validate="required:请输入图出版社" />
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>关键字：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${book.bKeyWords }" name="bKeyWords"
							data-validate="required:请输入图出版社" />
						<div class="tips"></div>
					</div>
				</div>


				<div class="form-group">
					<div class="label">
						<label>简介：</label>
					</div>
					<div class="field">
						<textarea class="input" name="bIntro" style=" height:90px;"
							data-validate="required:请输入图书简介">${book.bIntro }</textarea>
						<div class="tips"></div>
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
				</div>
			</form>
		</div>
	</div>

      <script type="text/javascript">	
	$('#update').click(function(){
    var data = $('#bookinfo').serialize();
	$.ajax({
		url: "/library/book/updateBook.do",
        type: "post",
		data:data, 
		dataType: "json",
		success:function(result) {
		
		if(result.result){
		alert("修改书籍信息成功！")
		}else{
		alert("修改书籍失败！");
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
