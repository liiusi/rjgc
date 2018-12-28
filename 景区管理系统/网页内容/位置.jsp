<%@page import="java.sql.*"%>
<%@page import="test.DbConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>游客位置</title>
<style type="text/css">
body {
	background: url("1.jpg") no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}
</style>
</head>
<body>

	<%
		Connection con = DbConnect.getConnection();

		String sql = "select * from a";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
	%>
	<div align="center">
		<table width="100" border="1">
			<tr>
				<td>景区编号</td>
				<td>游客ID</td>
			</tr>

			<%
				while (rs.next()) {
						out.print("<tr><td>" + rs.getString("景区编号") + "</td><td>" + rs.getString("游客ID") + "</td></tr>");
					}
					//     		out.print("success");
				} catch (Exception e) {
					//     		out.print("fail");
					e.printStackTrace();
				}
			%>

		</table>
	</div>

	<center>
		<br>
		<input type="button" value="返回"
			onclick="window.location.href='工作人员操作界面.jsp';" /></br>
	</center>
</body>
</html>
