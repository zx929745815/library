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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="${path}/library/static/css/pintuer.css">
    <link rel="stylesheet" href="${path}/library/static/css/admin.css">
    <script src="${path}/library/static/js/jquery.js"></script>
    <script src="${path}/library/static/js/pintuer.js"></script> 
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 读者列表</strong></div>
  <div class="padding border-bottom">  
  </div> 
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">学号</th>     
      <th>姓名</th>  
      <th>院系</th> 
      <th>专业</th>     
      <th width="250">操作</th>
    </tr>
    
    
    <c:forEach items="${readerList }" var="reader">
    <tr>
      <td>${reader.rNo }</td>      
      <td>${reader.rName }</td>  
      <td>${reader.rDept }</td>   
      <td>${reader.rPref }</td> 
      
      
      <c:if test="${operator == 'search'}">
      <td>
      <div class="button-group">
      <a type="button" class="button border-main" href="${path }/library/reader/toCheckBorMsg.do?rId=${reader.rId }">查看借阅信息</a>
      </div>
      </td>
      </c:if> 
      
      <c:if test="${empty operator}"> 
      <td>
      <div class="button-group">
      <a type="button" class="button border-main" href="${path }/library/reader/readerInfo.do?rId=${reader.rId }"><span class="icon-edit"></span>查看</a>
       <a class="button border-main" href="${path }/library/reader/updateReaderInfo.do?rId=${reader.rId }"><span class="icon-trash-o"></span> 修改</a>
      </div>
      </td>
      </c:if>
      
      
    </tr> 
    </c:forEach>
    
    
  </table>
</div>
</body>
</html>