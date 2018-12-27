<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="UTF-8">
<title>忘记密码</title>
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
<form action="Servlet3" method="post" id="myform">
	<table align="center" style="margin-top: 100px">
		<tr><td ><input type="text" placeholder="请输入邮箱" title="邮箱" name="email"/></td></tr>
		<tr><td ><input type="password" placeholder="请输入新密码" title="密码" name="passwd"/></td></tr>
		<tr><td align="center"><input type="button" value="提交" onclick="check()" /></td></tr>
	</table>
</form>
</body>
</html>