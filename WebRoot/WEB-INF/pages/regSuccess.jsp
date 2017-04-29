<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'success.jsp' starting page</title>

<!--自动跳转  -->
<script type="text/javascript">
	function countDown(secs, surl) {
		//alert(surl);    
		var jumpTo = document.getElementById('jumpTo');
		jumpTo.innerHTML = secs;
		if (--secs > 0) {
			setTimeout("countDown(" + secs + ",'" + surl + "')", 1000);
		} else {
			location.href = surl;
		}
	}
</script>

<style type="text/css">
#content{
	width: 100%;
    height: 100%;
    text-align: center;
    font-size: 30px;
    margin-top: 160px;
    color: white;
}
</style>

</head>

<body background="${path }/library/static/images/bg.jpg">
    <div id="content">
           注册成功！<br>
	<span id="jumpTo">5</span>秒后自动跳转到登陆界面！
	<script type="text/javascript">
	countDown(5, 'http://localhost:8080/library/login/toLogin.do');
	</script>
	<br>
    </div>
</body>
</html>
