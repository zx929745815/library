<%@page import="xtu.library.entity.Pagination"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>湘潭大学图书馆后台管理中心</title>  
    <link rel="stylesheet" href="${path}/library/static/css/pintuer.css">
    <link rel="stylesheet" href="${path}/library/static/css/admin.css">
    <script src="${path}/library/static/js/jquery.js"></script>   
</head>
<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 图书检索</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li>搜索：</li>
  <!--       <li>首页
          <select name="s_ishome" class="input" onchange="changesearch()" style="width:60px; line-height:17px; display:inline-block">
            <option value="">选择</option>
            <option value="1">是</option>
            <option value="0">否</option>
          </select>
          &nbsp;&nbsp;
          推荐
          <select name="s_isvouch" class="input" onchange="changesearch()"  style="width:60px; line-height:17px;display:inline-block">
            <option value="">选择</option>
            <option value="1">是</option>
            <option value="0">否</option>
          </select>
          &nbsp;&nbsp;
          置顶
          <select name="s_istop" class="input" onchange="changesearch()"  style="width:60px; line-height:17px;display:inline-block">
            <option value="">选择</option>
            <option value="1">是</option>
            <option value="0">否</option>
          </select>
        </li> -->
        <if condition="$iscid eq 1">
          <li>
            <select  id="condition" class="input" style="width:200px; line-height:17px;" >
              <option value="">请选择查询条件</option>
              <option value="byISBN">按ISBN查询</option>
              <option value="byName">按书名查询</option>
              <option value="byType">按分类查询</option>
            </select>
          </li>
        </if>
        <li>
          <input type="text" placeholder="请输入查询关键字关键字" id="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <input  class="button border-main icon-search" id="querybook" type="button" value="搜索"> </li>
      </ul>
    </div>
    <table class="table table-hover text-center" id="bookinfo">
    	<thead>
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">ID</th>
        <th width="10%">ISBN</th>
        <th width="300">书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th>所在馆室</th>
        <th width="200">书籍类别</th>
       
      </tr>
      </thead>
      
      <tbody id="bookTbody">
      <c:forEach items="${bookList }" var="book">
      
   <!--   <div id="booklist">    -->
        <tr class="bookinfo" >
          <td style="text-align:left; padding-left:20px;"><input type="hidden" id="bId+${book.bId }" value="${book.bId }" />${book.bId }</td>
          <td>${book.bISBN }</td>
          <td width="10%">${book.bName }</td>
          <td>${book.bAuth }</td>
          <td><font color="#00CC99">${book.bPublish }</font></td>
          <td>${book.bRNo }</td>
          <td>${book.bType }</td>
          <td><div class="button-group"> <a class="button border-main" href="/library/book/bookInfo.do?bId=${book.bId}"><span class="icon-edit"></span> 查看</a> 
          <a class="button border-main"  href="javascript:void(0);" onclick="toBorrow(${book.bId});" ><span class="icon-edit"></span> 借阅</a> </div></td>
        </tr>
  <!--   </div>  -->
     </c:forEach>  
   		 
 
      <tr>
      
      <%
          Pagination pagination = (Pagination)session.getAttribute("pagination");
          int totlePage = pagination.getTotlePage();
          int currentPage = pagination.getPageIndex();
          int maxPage = pagination.getTotlePage();
          if(currentPage<1){
            currentPage = 1;
          }else if(currentPage >= pagination.getTotlePage()){
            currentPage = pagination.getTotlePage()-1;
          }
       %>
        <td colspan="8"><div class="pagelist"> <a href="${path }/library/reader/toSearchBook.do?pageIndex=<%=currentPage-1 %>">上一页</a> 
       <% 
          for(int i=1; i<=totlePage; i++){
       %> 
        <a href="${path }/library/reader/toSearchBook.do?pageIndex=<%=i %>" ><%=i %></a>
       <%  
           }
       %>
        
        <a href="${path }/library/reader/toSearchBook.do?pageIndex=<%=currentPage+1 %>">下一页</a>
        <a href="${path }/library/reader/toSearchBook.do?pageIndex=<%=maxPage %>">尾页</a> </div></td>
      </tr>
      </tbody>
    </table>
  </div>
</form>

<script type="text/javascript" src="${path}/library/static/js/search.js"></script>

<script>
function toBorrow( bId){
	
	alert("test!");
	   var data = bId;
	   alert(data);
	   
	   $.ajax({
		url : "/library/reader/borrowBook.do",
		type : "post",
		data : "bId="+data,
		dataType : "json",

		success : function(result) {
		alert(result.msg)
		if(result.msg){
		alert("success");
		}else{
		alert("error");
		}
		},
		error:function(){
		alert("systemerror");
		}
	});
}
</script>

</body>
</html>