$('#querybook').click(function(){
	
	$("#bookTbody").html("");
	var condition = $('#condition').val();
	var keywords = $('#keywords').val();
	$.ajax({
		url : "/library/book/queryBookByCondition.do",
		type : "post",
		data : "condition=" + condition + "&keywords=" + keywords,
		dataType : "json",

		success : function(result) {
			var bookList = result.bookList;

			var html = ""
			if(bookList.length > 0){
			for (var i = 0; i < bookList.length; i++) {
				var book = bookList[i];
				var bookId = book.bId;

				html += "<tr>"
				html += " <td style='text-align:left; padding-left:20px;'><input type='checkbox' name='id[]' value='' />" + book.bId + "</td>";
				html += "  <td>" + book.bISBN + "</td>";
				html += " <td width='10%'>" + book.bName + "</td>";
				html += "<td>" + book.bAuth + "</td>";
				html += "<td><font color='#00CC99'>" + book.bPublish + "</font></td>";
				html += " <td>" + book.bRNo + "</td>";
				html += "<td>" + book.bType + "</td>";
				html += "<td><div class='button-group'> <a class='button border-main' href='/library/book/bookInfo.do?bId="+bookId+"'>";
				html +="<span class='icon-edit'></span> 查看详细</a> " +
						"<a class='button border-main' href='javascript:void(0)' onclick='toBorrow("+book.bId+");'>" +
								"<span class='icon-edit'></span> 借阅</a> </div></td>";
				html += "</tr>";
			}
		}else{
			html+="<tr><td colspan='7'>抱歉没有找到相关书籍</td></tr>";
		}
			$("#bookTbody").html(html);
			return;
		}
	});
	
	
});

