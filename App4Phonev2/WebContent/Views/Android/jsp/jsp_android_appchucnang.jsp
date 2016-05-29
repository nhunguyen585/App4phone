<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>App4Phone - Ứng dụng tin tức!</title>
		<link rel="stylesheet" type="text/CSS" href="Views/Android/css/jsp_android_gamenew.css">
	</head>
	
	<%
		session.setAttribute("url", "jsp_android_appchucnang");
		if(session.getAttribute("rs_app_chucnang") == null){
			response.sendRedirect("serv_android_appchucnang");
		}
	%>

	<body>
		<%@ include file="header.jsp" %>
		
		<!-- BEGIN MAIN -->
		<%@ include file="Main.jsp" %>

			<h1>Ứng dụng chức năng!</h1>
			<%
				if(session.getAttribute("rs_app_chucnang") != null){
					ResultSet rs_app_chucnang = (ResultSet) session.getAttribute("rs_app_chucnang");
					while(rs_app_chucnang.next()){ %>
						<div class="div">
							<img alt="" src="<%=rs_app_chucnang.getString(4) %>"> <br>
							<span><%=rs_app_chucnang.getString(2) %></span>
							<form action="serv_android_view_each_app"><button name="<%=rs_app_chucnang.getString(1)%>">Tải về</button></form>
						</div>
			<%			
					}
					session.removeAttribute("rs_app_chucnang");
					session.removeAttribute("error");
				}
			%>
		<%@ include file="endMain.jsp" %>	
		<!-- END MAIN -->

		<%@ include file="Hidden.jsp" %>	
	</body>
	<script type="text/javascript" src="Views/Android/js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="Views/Android/js/app4phone.js"></script>
</html>