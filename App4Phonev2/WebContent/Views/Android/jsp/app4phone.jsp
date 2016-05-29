<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>App4Phone - Trò chơi, ứng dụng, sách</title>
		<link rel="stylesheet" type="text/CSS" href="Views/Android/css/app4phone.css">
	</head>
	
	
	<%
		session.setAttribute("url", "jsp_app4phone");
		if(session.getAttribute("rs_top_game") == null){
			response.sendRedirect("serv_app4phone");
		}
	%>

	<body>
		<%@ include file="header.jsp" %>
		
		<!-- BEGIN MAIN -->
		<%@ include file="Main.jsp" %>	
		
			<div class="slide">
				<img id="next" alt="" src="Image/Homepage/next.png">
				<img id="previous" alt="" src="Image/Homepage/previous.png">
				<img id="img" alt="" src="Image/Homepage/1.jpg">
				<img id="img2" alt="" src="Image/Homepage/5.jpg">
				<img id="img2" alt="" src="Image/Homepage/6.jpg">
				<img id="img2" alt="" src="Image/Homepage/7.jpg">
				<img id="img2" alt="" src="Image/Homepage/8.jpg">
			</div>
			
			<h1>Top trò chơi</h1>
			<%
				int i = 1;
				if(session.getAttribute("rs_top_game") != null){
					ResultSet rs_top_game = (ResultSet) session.getAttribute("rs_top_game");
					while(rs_top_game.next() && i <= 6){ %>
						<div class="div">
							<img alt="" src="<%=rs_top_game.getString(4) %>"> <br>
							<span><%=rs_top_game.getString(2) %></span>
							<form action="serv_android_view_each_game"><button name="<%=rs_top_game.getString(1)%>">Tải về</button></form>
						</div>
			<%			
						i++;
					}
					session.removeAttribute("rs_top_game");
				}
			%>
			<form><button class="more">Xem thêm</button></form>
			
			<h1>Top ứng dụng</h1>
			<%
				i = 1;
				if(session.getAttribute("rs_top_app") != null){
					ResultSet rs_top_app = (ResultSet) session.getAttribute("rs_top_app");
					while(rs_top_app.next() && i <= 6){ %>
						<div class="div">
							<img alt="" src="<%=rs_top_app.getString(4) %>">
							<span><%=rs_top_app.getString(2) %></span>
							<form action="serv_android_view_each_app"><button name="<%=rs_top_app.getString(1)%>">Tải về</button></form>
						</div>
			<%			
						i++;
					}
					session.removeAttribute("rs_top_app");
				}
			%>
			<form><button class="more">Xem thêm</button></form>
			
			<h1>Top Sách</h1>
			<%
				i = 1;
				if(session.getAttribute("rs_top_book") != null){
					ResultSet rs_top_book = (ResultSet) session.getAttribute("rs_top_book");
					if(rs_top_book != null){
						while(rs_top_book.next() && i <= 6){ %>
							<div class="div">
								<img alt="" src="<%=rs_top_book.getString(4) %>"> <br>
								<span><%=rs_top_book.getString(2) %></span>
								<form action="serv_android_view_each_book"><button name="<%=rs_top_book.getString(1)%>">Tải về</button></form>
							</div>
			<%			
							i++;
						}
						session.removeAttribute("rs_top_book");
						session.removeAttribute("error");
					}
				}
			%>
			<form><button class="more">Xem thêm</button></form>
			
			
		<%@ include file="endMain.jsp" %>	
		<!-- END MAIN -->
		
		<%@ include file="Hidden.jsp" %>	

	</body>
	<script type="text/javascript" src="Views/Android/js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="Views/Android/js/app4phone.js"></script>
</html>