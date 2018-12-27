<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎注册</title>
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
<form action="Servlet1" method="post" id="myform">
	<table align="center"	style="margin-top: 100px">
		<tr><td>用户名：</td>
		<td colspan="2"><input type="text" placeholder="由字母与数字组成" style="width:180px"  title="用户名" name="name"/></td>
		</tr>
		<tr><td>密码：</td>
		<td colspan="2"><input type="password" placeholder="请输入6位以上的密码" style="width:180px" title="密码" name="pwd"/></td>
		</tr>
		<tr><td>邮箱：</td>
		<td colspan="2"><input type="text" style="width: 180px" title="邮箱" name="email"/>
		<tr><td>性别：</td><td>男<input type="radio" name="sex" title="性别" value="man"/></td><td>女<input type="radio" name="sex" title="性别" value="woman"/></td>
		</tr>
	</table>
	<div align="center" style="margin-top: 25px"><input type="button" value="提交" onclick="check()"/>
	</div>
</form>
</body>
</html>