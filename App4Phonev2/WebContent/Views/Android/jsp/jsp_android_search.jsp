<%@page import="Model.Object"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>App4Phone - Top game hot nhất!</title>
		<link rel="stylesheet" type="text/CSS" href="Views/Android/css/jsp_android_gamenew.css">
	</head>
	
	<%
		session.setAttribute("url", "jsp_android_gametop");
		if(session.getAttribute("result") == null){
			response.sendRedirect("serv_android_search");
		}
	%>

	<body>
		<%@ include file="header.jsp" %>
		
		<!-- BEGIN MAIN -->
		<%@ include file="Main.jsp" %>	

			<%
				ArrayList<Object> result = null;
				if(session.getAttribute("result") != null){
					result = (ArrayList<Object>) session.getAttribute("result"); %>
					<h1>Tìm thấy <%=result.size() %> kết quả</h1>	
			<%	
				}
				if(session.getAttribute("result") != null){
					for(int i = 0; i < result.size(); i++){ 
			%>
						<div class="div">
							<img alt="" src="<%=result.get(i).getPath() %>"> <br>
							<span><%=result.get(i).getName() %></span>
							<form action="<%=result.get(i).getTable()%>"><button name="<%=result.get(i).getId()%>">Tải về</button></form>
						</div>
			<%			
					}
				}
				session.removeAttribute("result");
			%>
			
		<%@ include file="endMain.jsp" %>	
		<!-- END MAIN -->
		
		<%@ include file="Hidden.jsp" %>
	</body>
	<script type="text/javascript" src="Views/Android/js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="Views/Android/js/app4phone.js"></script>
</html>