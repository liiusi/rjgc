<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎</title>
</head>

<script type="text/javascript">
  // 检查表单元素的值是否为空
    function check(){
        var myform = document.getElementById("myform");
        for(var i=0; i<myform.length; i++ ){
            if(myform.elements[i].value == ""){
                alert(myform.elements[i].title + "不能为空");
                myform.elements[i].focus();
                return;
            }
        }
    myform.submit();    // 表单中最后input提交标签用的是button类型，首先不提交表单，在js判断表单项都不为空时 再提交表单。
    }
</script>
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
<form action="Servlet2" method="post" id="myform">
	<h1 align="center">欢迎</h1>
	<table align="center" style="margin-top: 100px">
			<tr>
				<td><input type="text" placeholder="用户名" style="width: 180px" title="用户名" name="name"/></td>  
			</tr>
			<tr>
				<td><input type="password" placeholder="密码" style="width:180px"  title="密码" name="pwd"/></td>
	</table>
	<table align="center">
		<tr>
			<td><input type="button" value="登录" onclick="check()"></tr></td>
		</tr>
	</table>
	<table align="center" style="margin-top: 50px">	
		<tr>
			<td><div style="margin:15px 15px 15px 15px"><a href="http://localhost:8080/景区管理系统/注册.jsp">注册</a></div></td>
			<td><div style="margin:15px 15px 15px 15px"><a href="http://localhost:8080/景区管理系统/忘记密码.jsp">忘记密码？</a></div></td>
	</table>
</form>	
</body>

</html>