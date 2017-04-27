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
    <div class="panel-head"><strong class="icon-reorder">通知列表</strong></div>

    <table class="table table-hover text-center" id="msginfo">
    	<thead>
      <tr>
        <th>通知编号</th>
        <th>发布者</th>
        <th>内容</th>
        <th>发布时间</th>
       
      </tr>
      </thead>
      
      <tbody id="msgTbody">
      <c:forEach items="${noticeList }" var="msg">
      
   <!--   <div id="msglist">    -->
        <tr class="msginfo" >
          <td>${msg.nId }</td>
          <td width="10%">${msg.author }</td>
          <td width="25%"><font color="#00CC99">${msg.content }</font></td>
          <td width="10%">${msg.createDate }</td>
          
          <td><div class="button-group"> <a class="button border-main" href="##"><span class="icon-edit"></span> 查看</a></div></td>
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
        <td colspan="8"><div class="pagelist">
         <a href="${path }/library/notice/queryNoticeHistory.do?pageIndex=1">首页</a>
         <a href="/library/notice/queryNoticeHistory.do?pageIndex=<%=currentPage-1 %>">上一页</a> 
       <% 
          for(int i=1; i<=totlePage; i++){
       %> 
        <a href="${path }/library/notice/queryNoticeHistory.do?pageIndex=<%=i %>" ><%=i %></a>
       <%  
           }
       %>
        <a href="${path }/library/notice/queryNoticeHistory.do?pageIndex=<%=currentPage+1 %>">下一页</a>
        <a href="${path }/library/notice/queryNoticeHistory.do?pageIndex=<%=maxPage %>">尾页</a> </div></td>
      </tr>
      </tbody>
    </table>
  </div>
</form>
</body>
</html>