<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="${path}/library/static/css/pintuer.css">
<link rel="stylesheet" href="${path}/library/static/css/admin.css">
<script src="${path}/library/static/js/jquery.js"></script>

<!--引用dataTable插件  -->
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>

    <script type="text/javascript" src="<%=basePath%>static/js/confirm.js">
	</script>
</head>
<body>
<form method="post" action="" id="listform">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder">读者列表</strong>
			</div>
			
		<table id="readerinfos" class="display cell-border "
				style="text-align: center;">
				<thead>
					<tr>
						<th>序号</th>
						<th>姓名</th>
						<th>学号</th>
						<th>性别</th>
						<th>年级</th>
						<th>院系</th>
						<th>专业</th>
						<th>操作</th>
					</tr>
				</thead>
			</table>			
</form>


	<script type="text/javascript">
		$(document).ready(function() {
			$('#readerinfos').DataTable({
				//lengthMenu: [5, 10, 20, 30],//这里也可以设置分页，但是不能设置具体内容，只能是一维或二维数组的方式，所以推荐下面language里面的写法。
				paging : true, //分页
				ordering : true, //是否启用排序
				searching : true, //搜索
				language : {
					lengthMenu : '<select class="form-control input-xsmall">' + '<option value="1">1</option>' + '<option value="10">10</option>' + '<option value="20">20</option>' + '<option value="30">30</option>' + '<option value="40">40</option>' + '<option value="50">50</option>' + '</select>条记录', //左上角的分页大小显示。
					search : '<span class="label label-success">搜索：</span>', //右上角的搜索文本，可以写html标签
	
					paginate : { //分页的样式内容。
						previous : "上一页",
						next : "下一页",
						first : "第一页",
						last : "最后"
					},
	
					zeroRecords : "没有内容", //table tbody内容为空时，tbody的内容。
					//下面三者构成了总体的左下角的内容。
					info : "总共_PAGES_ 页，显示第_START_ 到第 _END_ ，筛选之后得到 _TOTAL_ 条，初始_MAX_ 条 ", //左下角的信息显示，大写的词为关键字。
					infoEmpty : "0条记录", //筛选为空时左下角的显示。
					infoFiltered : "" //筛选之后的左下角筛选提示，
				},
				paging : true,
				pagingType : "full_numbers", //分页样式的类型
	
				"ajax" : "/library/reader/listAllReaders.do",
				"columns" : [
					{
						"data" : "rId"
					},
					{
						"data" : "rName"
					},
					{
						"data" : "rNo"
					},
					{
						"data" : "rSex"
					},
					{
						"data" : "rGrade"
					},
					{
						"data" : "rDept"
					},
					{
						"data" : "rPref"
					},
				],
				"columnDefs" : [
	
					// 增加一列，包括删除和修改，同时将我们需要传递的数据传递到链接中
					{
						"targets" : [ 7 ], // 目标列位置，下标从0开始
						"data" : "rId", // 数据列名
						"render" : function(data, type, full) { // 返回自定义内容
							return "<a class='button bg-main' href='/library/reader/readerInfo.do?rId=" + data + "'>查看</a>&nbsp;" +
								"<a class='button bg-main' href='/library/reader/updateReaderInfo.do?rId=" + data + "'>修改</a>&nbsp;" +
								"<a class='button bg-main' href='/library/reader/updateReaderInfo.do?rId=" + data + "'>锁定</a>&nbsp;" +
								"<a class='button bg-main' href='##' onclick='show_confirm(" + data + ");'>删除</a>&nbsp;";
	
						}
					}
	
				]
			});
		});
	
	
		function show_confirm(data) {
			var r = confirm("删除当前用户？");
			if (r == true) {
				alert("确认删除");
				$.ajax({
					url : "/library/reader/deleteReaderById.do",
					type : "post",
					data : "rId=" + data,
					dataType : "json",
					success : function(result) {
						if (result.msg) {
							alert("删除成功");
							location.href = "/library/admin/toListAllReaders.do";
						} else {
							alert("删除失败！");
						}
					},
					error : function() {
						alert("删除过程中出现了系统错误！");
					}
				});
	
			} else {
				alert("取消删除");
				location.href = "/library/admin/toListAllReaders.do";
			}
		}
	</script>



</body>
</html>
