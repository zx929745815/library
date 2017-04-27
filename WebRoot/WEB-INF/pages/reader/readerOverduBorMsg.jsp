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
    <div class="panel-head"><strong class="icon-reorder">逾期图书</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">

    <table class="table table-hover text-center" id="bookinfo">
    	<thead>

        
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">ID</th>
        <th width="10%">ISBN</th>
        <th width="300">书名</th>
        <th>出版社</th>
        <th>借书日期</th>
        <th width="200">借阅状态</th>
        <th>应交罚金</th>
        
      </tr>
      </thead>
      
      <tbody id="bookTbody">
      <c:forEach items="${borMsgList }" var="bm">
      
   <!--   <div id="booklist">    -->
        <tr class="borrowinfo" >
          <td style="text-align:left; padding-left:20px;"><input type="hidden" id="bId+${bm.mId }" value="${bm.mId }" />${bm.bId }</td>
          <td>${bm.bookISBN }</td>
          <td width="10%">${bm.bookName }</td>
          <td>${bm.bookPublish }</td>
          <td>${bm.borrowDate }</td>
          <c:if test="${bm.borrowState  == '0'}">
          <td><font color="#00CC99">待还</font></td>
          </c:if>
          <c:if test="${bm.borrowState  == '1'}">
          <td><font color="#00CC99">已还</font></td>
          </c:if>
          <td> <span style="color: red">￥${bm.fine }</span>   </td>
         <td><div class="button-group"> <a class="button border-main" href="/library/book/bookInfo.do?bId=${bm.bId}"><span class="icon-edit"></span> 查看</a> 
         <%--  <a class="button border-main" href="javascript:void(0);" onclick="toBorrow(${book.bId});" ><span class="icon-edit"></span> 借阅</a>--%> </div> </td>
        </tr>
        </c:forEach>  
      <tr>
      </tbody>
    </table>
  </div>
</form> 

</body>
</html>