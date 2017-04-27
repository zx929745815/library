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
    
    <style type="text/css">
    .searchReader{
    margin: 10px;
    padding-left: 200px;
    }
    
    </style>   
</head>
<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">借阅信息报表(按时间降序)</strong></div>

    	<div class="searchReader">
		<div class="form-group" >
          <div class="field" >
            <select name="condition" id="condition" class="input w50 condition" >
              <option value="">请选择查询方式</option>
              <option value="byrname" >按姓名</option>
              <option value="byrno">按学号</option>
            </select>
            
          <input type="text" placeholder="请输入搜索关键字" id="keywords" name="keywords" class="input search" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" id="search" class="button border-main icon-search" onclick="changesearch()" > 搜索</a>
          </div>
        </div>
		</div>

    <table class="table table-hover text-center" id="msginfo">
    	<thead>
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">ISBN</th>
        <th width="10%">书名</th>
        <th width="300">出版社</th>
        <th>借阅者</th>
        <th>院系</th>
        <th>专业</th>
        <th width="200">时间</th>
        <th width="200">操作</th>
       
      </tr>
      </thead>
      
      <tbody id="msgTbody">
      <c:forEach items="${borMsgList }" var="msg">
      
   <!--   <div id="msglist">    -->
        <tr class="msginfo" >
         <%--  <td style="text-align:left; padding-left:20px;"><input type="hidden" id="bId+${msg.bId }" value="${msg.bId }" />${msg.bId }</td> --%>
          <td>${msg.bookISBN }</td>
          <td width="13%">${msg.bookName }</td>
          <td width="10%">${msg.bookPublish }</td>
          <td>${msg.rCard.reader.rName }</td>
          <td>${msg.rCard.reader.rDept }</td>
          <td>${msg.rCard.reader.rPref }</td>
          <td>${msg.borrowDate }</td>
          <c:if test="${msg.borrowState == '0' }">
          <td width="10%"><font color="#00CC99">借阅</font></td>
          </c:if>
          <c:if test="${msg.borrowState == '1' }">
          <td><font color="#00CC99">归还</font></td>
          </c:if>
          
          <td><div class="button-group"> <a class="button border-main" href="/library/book/bookInfo.do?bId=${msg.bId}"><span class="icon-edit"></span> 查看</a></div></td>
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
        <td colspan="8"><div class="pagelist"> <a href="${path }/library/admin/toCheckBorMsg.do?pageIndex=<%=currentPage-1 %>">上一页</a> 
       <% 
          for(int i=1; i<=totlePage; i++){
       %> 
        <a href="${path }/library/admin/toCheckBorMsg.do?pageIndex=<%=i %>" ><%=i %></a>
       <%  
           }
       %>
        
        <a href="${path }/library/admin/toCheckBorMsg.do?pageIndex=<%=currentPage+1 %>">下一页</a>
        <a href="${path }/library/admin/toCheckBorMsg.do?pageIndex=<%=maxPage %>">尾页</a> </div></td>
      </tr>
      </tbody>
    </table>
  </div>
</form>

<script>
 $(document).ready(function(){
	$('#search').click(function(){
	var condition = $('#condition').val();
	var keywords = $('#keywords').val();
	location.href = "http://localhost:8080/library/reader/queryReaderByCondition.do?condition="+condition+"&keywords="+keywords; 
	});    
    });
</script>

</body>
</html>