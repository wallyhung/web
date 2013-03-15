<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>电话号码保存</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="telkeep!telKeepToDB.do" method="post">
    <div>黑名单导入(<span style="color: red;">带入规则：每个号码用回车分隔，号码中间不可有其他字符或空格，每次最多导入1000个号码，多余号码请分批导入</span>)：</div>
  	<br>
  	<div><textarea rows="30" cols="40" style="resize:none;overflow: scroll;overflow-x:hidden" name="teltests"></textarea>
  		<input type="submit" value="提交">
  	</div>
  </form>
  </body>
</html>
