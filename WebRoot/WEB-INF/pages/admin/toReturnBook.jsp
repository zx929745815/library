<%@page import="xtu.library.entity.Pagination"%>
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
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>湘潭大学图书馆后台管理中心</title>
<link rel="stylesheet" href="${path}/library/static/css/pintuer.css">
<link rel="stylesheet" href="${path}/library/static/css/admin.css">
<script src="${path}/library/static/js/jquery.js"></script>

<style type="text/css">
.searchReader {
	margin: 10px;
	padding-left: 200px;
}
</style>
</head>
<body>
	<form method="post" action="" id="listform">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder">图书归还</strong>
			</div>

			<div class="searchReader">
				<div class="form-group">
					<div class="field">
						<select name="condition" id="condition"
							class="input w50 condition">
							<option value="byrno">请输入学号</option>
							<!--<option value="byrname" >按姓名</option>
              <option value="byrno">按学号</option> -->
						</select> <input type="text" placeholder="请输入搜索关键字" id="RNO" name="RNO"
							class="input search"
							style="width:250px; line-height:17px;display:inline-block" /> <a
							href="javascript:void(0)" id="search"
							class="button border-main icon-search"> 搜索</a>
					</div>
				</div>
			</div>

			<table class="table table-hover text-center" id="bookinfo">
				<thead>
					<tr>
						<th width="100" style="text-align:left; padding-left:20px;">ID</th>
						<th width="10%">ISBN</th>
						<th width="300">书名</th>
						<th>出版社</th>
						<th>借阅时间</th>

					</tr>
				</thead>

				<tbody id="bookTbody">
					<tr>
						<td colspan="4">抱歉没有找到相关书籍</td>
					</tr>
				</tbody>
			</table>


		</div>
	</form>

	<script>
	$(document).ready(function() {
		$('#search').click(function() {
			queryBorBook();
		});
	});

	function returnBook(mId, RNO, ISBN) {
		var r = confirm("确认归还？");
		if (r == true) {
			alert("确认");
			$.ajax({
				url : "/library/book/returnBook.do",
				type : "post",
				data : "mId=" + mId + "&RNO=" + RNO + "&ISBN=" + ISBN,
				dataType : "JSON",

				success : function(result) {
					if (result.msg) {
						alert("图书已归还");
						queryBorBook();
					} else {
						alert("归还失败");
					}
				},
				error : function() {
					alert("归还失败");
				}
			});
		} else {
			alert("取消");
		}
	}

	function queryBorBook() {
		var RNO = $('#RNO').val();
		$.ajax({
			url : "/library/book/queryBorBook.do",
			type : "post",
			data : "RNO=" + RNO,
			dataType : "JSON",

			success : function(result) {
				var borMsgList = result.borMsgList;
				var html = ""
				if (borMsgList.length > 0) {
					for (var i = 0; i < borMsgList.length; i++) {
						var msg = borMsgList[i];
						var mId = msg.mId;

						html += "<tr>"
						html += " <td style='text-align:left; padding-left:20px;'><input type='checkbox' name='id[]' value='' />" + msg.bId + "</td>";
						html += "  <td>" + msg.bookISBN + "</td>";
						html += " <td width='15%'>" + msg.bookName + "</td>";
						html += "<td><font color='#00CC99'>" + msg.bookPublish + "</font></td>";
						html += "  <td>" + new Date(msg.borrowDate).toLocaleDateString() + "</td>";
						//html += "<td><div class='button-group'> <a class='button border-main' href='/library/book/returnBook.do?bId="+bookId+"'>";
						html += "<td><div class='button-group'> <a class='button border-main' href='##' onclick='returnBook(" + msg.mId + "," + RNO + "," + msg.bookISBN + ")'>";
						html += "<span class='icon-book'></span> 归还</a> " ;
						html += "</tr>";
					}
				} else {
					html += "<tr><td colspan='5'>抱歉没有找到相关书籍</td></tr>";
				}
				$("#bookTbody").html(html);
				return;
			},
			error : function() {}
		});
	}

	function show_confirm() {
		var r = confirm("确认归还？");
		if (r == true) {
			alert("确认");
			queryBorBook();

		} else {
			alert("取消");
		}
	}
	</script>

</body>
</html>