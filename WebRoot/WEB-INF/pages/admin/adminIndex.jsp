<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <title>湘潭大学图书馆后台管理中心</title>  
    <link rel="stylesheet" href="${path}/library/static/css/pintuer.css">
    <link rel="stylesheet" href="${path}/library/static/css/admin.css">
    <script src="${path}/library/static/js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1>湘潭大学图书馆后台管理中心</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="${path }/library/login/logOut.do"><span class="icon-power-off"></span> 退出登录</a> </div>
  
  <div id="welcome"><img src="${path}/library/static/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="用户头像" /><strong >${admin.aName},欢迎登陆！</Strong></div>
</div>


<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>读者管理</h2>
  <ul style="display:block">
    <li><a href="${path }/library/admin/toAddReader.do" target="right"><span class="icon-caret-right"></span>添加会员</a></li>
    <li><a href="${path }/library/admin/toListAllReaders.do" target="right"><span class="icon-caret-right"></span>所有会员</a></li>
    <li><a href="${path }/library/admin/toUpdateReader.do" target="right"><span class="icon-caret-right"></span>会员查询</a></li>  
  </ul>  

  <h2><span class="icon-book"></span>图书管理</h2>
  <ul>
    <li><a href="${path }/library/admin/toAddBook.do" target="right"><span class="icon-caret-right"></span>图书添加</a></li>
    <li><a href="${path }/library/admin/toListAllBooks.do" target="right"><span class="icon-caret-right"></span>图书检索</a></li>
    <li><a href="${path }/library/login/notComplete.do" target="right"><span class="icon-caret-right"></span>快速查找</a></li>        
  </ul>  

  <h2><span class="icon-pencil-square-o"></span>借阅信息管理</h2>
  <ul>
    <li><a href="${path }/library/admin/toCheckBorMsg.do?pageIndex=1" target="right"><span class="icon-caret-right"></span>借阅信息</a></li> 
    <li><a href="${path }/library/admin/toBorrowBook.do" target="right"><span class="icon-caret-right"></span>图书借阅</a></li>
    <li><a href="${path }/library/admin/toReturnBook.do" target="right"><span class="icon-caret-right"></span>图书归还</a></li>
    <li><a href="${path }/library/admin/toQueryOverduBorMsg.do" target="right"><span class="icon-caret-right"></span>逾期图书查询</a></li>
    <li><a href="${path }/library/login/notComplete.do" target="right"><span class="icon-caret-right"></span>扣费查询</a></li>           
  </ul>
  
   <h2><span class="icon-envelope"></span>公告管理</h2>
    <ul>
    <li><a href="${path }/library/admin/toCreateNotice.do" target="right"><span class="icon-caret-right"></span>发布公告</a></li>
    <li><a href="${path }/library/notice/queryNoticeHistory.do?pageIndex=1" target="right"><span class="icon-caret-right"></span>历史公告</a></li>
    </ul>    

</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文</php></span></li>
</ul>
<!--默认的主页面  -->
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="${path }/library/admin/toAttention.do" name="right" width="100%" height="100%" ></iframe>
</div>

<div style="text-align:center;">
<p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
</body>
</html>
