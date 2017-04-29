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
<title></title>
<link rel="stylesheet" href="${path}/library/static/css/pintuer.css">
<link rel="stylesheet" href="${path}/library/static/css/admin.css">
 <script src="${path}/library/static/js/jquery.js"></script> 
<script src="${path}/library/static/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span>读者须知</strong></div>
  <div class="body-content">
  <div style="padding-left: 30px;">
  1、各类读者卡只限本人使用，一人一卡，不得让他人代借（家庭借阅卡除外），但图书可由他人代还。<br>
<br>
2、读者在借到图书时，核对一下自己的证号与图书，以免因疏忽拿错图书。<br>
<br>
3、读者对所借图书应如期归还，请您留意每日的还书日期提示牌,在借书时记住应该归还的日期，按期还书，（您当天借阅/续借的图书当天不得归还）如到期未阅读完，
<br>
<br>&nbsp;&nbsp;&nbsp;应携带读者卡（可不必带书）到外借处办理续借手续，或电话续借，允许续借一次，具体续借天数请参看借阅权限（续借图书一定要在还期内进行，否则过期后将不可再续借）。<br>
<br>
4、读者在还书时一定要把书交到工作人员手中，以免发生丢失。<br>
<br>
5、请读者按期还书，逾期须交纳逾期使用费：逾期天数×0.1元/册，本馆业务部门不收现金，请您缴纳逾期使用费或赔偿时，到办证处交纳。<br>
<br>
6、有过期未还图书或逾期使用费未交的，不得再外借其他图书。<br>
<br>
7、读者应该爱护图书，不得涂改、剪裁、撕毁、遗失图书，如发现上述情况，视具体情节，按照图书遗失、损坏赔偿标准赔偿，或以相同版本或新版之同种书抵赔。<br>
<br>
8、读者在借书时，请检查所借图书及图书附件，如发现有涂改、损坏、掉页等现象，应立即交工作人员加盖标记，以明责任。<br>
<br>
9、凡偷窃书刊资料，故意撕、挖书页，偷换书页内容者，一经发现。本馆将按书刊原价的2-10倍赔偿，并通报所在单位，直至追究法律责任。<br>
<br>
  </div>
  </div>
</div>
</body></html>
