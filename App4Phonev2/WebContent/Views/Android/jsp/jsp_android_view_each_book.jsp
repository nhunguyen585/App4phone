<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>App4Phone - Top game hot nhất!</title>
		<link rel="stylesheet" type="text/CSS" href="Views/Android/css/jsp_android_view_each_game.css">
	</head>
	
	<%
		session.setAttribute("url", "jsp_android_view_each_book");
		if(session.getAttribute("rs_book") == null){
			response.sendRedirect("serv_android_view_each_book");
		}
	%>

	<body>
		<%@ include file="header.jsp" %>
		
		<!-- BEGIN MAIN -->
		<%@ include file="Main.jsp" %>	
			
			<%
				ResultSet rs_book = null;			
				if(session.getAttribute("rs_book") != null){
					rs_book = (ResultSet) session.getAttribute("rs_book");
					while(rs_book.next()){ %>
						<div class="info">
							<div class="imagegame">
								<img alt="" src="<%=rs_book.getString(4)%>">
							</div>
							<div class="namegame">
								<span><%=rs_book.getString(2) %></span>
							</div>
							<div class="nsx">
								<span><%=rs_book.getString(6) %></span>
							</div>
							<div class="part">
								<div class="part1">
									<span>Thể loại: <%=rs_book.getString(7) %></span>
								</div>
								<div class="part2">
									<span>Lượt tải về: <%=rs_book.getString(5) %></span>
								</div>
								<div class="part3">
									<button>Tải về</button>
								</div>
							</div>
						</div>
						
						<div class="extends">
							<h3>Top application</h3>
							<%
								ResultSet rs_book_top = (ResultSet) session.getAttribute("rs_book_top");
								int k = 1;
								while(rs_book_top.next() && k <= 3){ %>
									<div class="div">
										<img alt="" src="<%=rs_book_top.getString(4) %>"> <br>
										<span><%=rs_book_top.getString(2) %></span>
										<form action="serv_android_view_each_book"><button name="<%=rs_book_top.getString(1)%>">Tải về</button></form>
									</div>
							<%
									k++;
								}
							%>
						</div>
						
						<div class="detail"> 
							<%=rs_book.getString(3) %>
						</div>
			<%		
					}
				}
				session.removeAttribute("rs_book");
				session.removeAttribute("error");
			%>
			
		<%@ include file="endMain.jsp" %>	
		<!-- END MAIN -->
		
		<%@ include file="Hidden.jsp" %>
	</body>
	<script type="text/javascript" src="Views/Android/js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="Views/Android/js/app4phone.js"></script>
</html>