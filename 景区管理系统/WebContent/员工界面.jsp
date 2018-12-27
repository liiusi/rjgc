<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎操作</title>
</head>
<style type="text/css">
body{
   background: url("1.jpg") no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
}
</style>
<body>
<form style="margin-top: 100px"><center>
           <br><input type="button" value="查询游客当前位置" onclick="window.location.href='位置.jsp';"/></br>
           </br><input type="button" value="呼叫110和120"  onclick="window.location.href='紧急呼救.jsp';"/></br>
           </br><input type="button" value="注销"  onclick="window.location.href='Denglu.jsp';"/></br>          
</form></center>
</body>
</html>