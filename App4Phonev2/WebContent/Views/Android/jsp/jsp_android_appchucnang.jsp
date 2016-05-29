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
		<div id="header">
			<div id="image">
				<a href="jsp_app4phone"><img src="Views/Image/icon.jpg"></a>	
			</div>
			
			<div id="search">
				<form action="serv_android_search" method="">
					<input type="text" placeholder="Tìm kiếm" name="search">
					<button>Search</button>
				</form>		
			</div>
			
			<div id="account">
				<%
					Cookie[] cookies = null;
					cookies = request.getCookies();
					String name = "";
					for(int i = 0; i < cookies.length; i++){
						//if(session.getAttribute("name") != null){ 
						if(cookies[i].getName().equals("name")){
							name = cookies[i].getValue();
						}
					}
					if(name != ""){
					%>
						<a href="serv_logout"><span>Đăng xuất</span></a>
						<span>Xin chào <%=name %></span>
					<%
					}else{  %>
						<button id="register">Đăng Ký</button>
						<button id="login">Đăng nhập</button>
				<%		
					}
					if(session.getAttribute("error") != null){ %>
						<script type="text/javascript">
							alert("<%=(String) session.getAttribute("error")%>")
						</script>
				<%		
					}
				%>
			</div>		
		</div>
		
		<div id="main1">
			<ul>
				<a href="jsp_app4phone"><li>Android</li></a>
				<a href="Views/Android/jsp/isBuilding.html"><li>IOS</li></a>
			</ul>
		</div>
		
		<div id="main2">
			<div id="main2_menu">
				<div id="game" class="dis">
					<a href="#">Trò chơi</a>
					<div id="menu_game" class="dis2">
						<div class="dis21"><a href="serv_android_gamenew">Mới nhất</a></div>
						<div class="dis21"><a href="serv_android_gamehot">Tải nhiều</a></div>
					</div>	
				</div>
				<div id="app" class="dis">
					<a href="#">Ứng dụng</a>
					<div id="menu_app" class="dis2">
						<div class="dis21"><a href="serv_android_apptintuc">Tin tức</a></div>
						<div class="dis21"><a href="serv_android_applienlac">Liên lạc</a></div>
						<div class="dis21"><a href="serv_android_appchucnang">Chức năng</a></div>
					</div>
				</div>
				<div id="book" class="dis">
					<a href="serv_android_book">Sách</a>
				</div>
			</div>

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
		</div>

		<div id="popup_login">
			<button id="close_popup_login">X</button>
			<form action="serv_login" method="post">
				<h1>Đăng nhập</h1> <br>
				<input type="text" placeholder="Tên đăng nhập" name="username"><br><br>
				<input type="password" placeholder="Mật khẩu" name="password"><br><br><br>
				<button class="but">Đăng nhập</button>
			</form>
		</div>
		<div id="popup_register">
			<button id="close_popup_register">X</button>
			<form action="serv_register" method="post">
				<h1>Đăng ký</h1> 
				<input type="text" placeholder="Họ tên" name="name"><br><br>
				<input type="text" placeholder="Tên đăng ký" name="username"><br><br>
				<input type="password" placeholder="Mật khẩu" name="password"><br><br>
				<input type="password" placeholder="Nhập lại mật khẩu" name="repassword"><br><br>
				<button class="but">Đăng Ký</button>
			</form>
		</div>
		<div id="dark"></div>
		
		<%
			if(session.getAttribute("admin") != null){
		%>
				<div id="admin">
					<img src="Image/admin.png">
				</div>
		<%
			}
		%>
		
		<div id="add">
			<h3>Thêm</h3>
			<form action="serv_android_add">
				<input name="aaa" type="text" placeholder="Ứng dụng điền AndroidApp, game điền AndroidGame, sách điền AndroidBook"> <br> <br>
				<input name="name" type="text" placeholder="Tên ứng dụng">  <br> <br>
				<input name="description" type="text" placeholder="Mô tả"> <br> <br>
				<input name="path" type="text" placeholder="Đường dẫn ảnh nền"> <br> <br>
				<input name="download" type="text" placeholder="Lượt tải về (Mặc định 0)"> <br> <br>
				<input name="nsx" type="text" placeholder="Nhà sản xuất"> <br> <br>
				<input name="type" type="text" placeholder="Loại ứng dụng"> <br> <br>
				<input name="muc" type="text" placeholder="App: new hoặc hot. Game: 1, 2, 3"> <br> <br>
				<input name="video" type="text" placeholder="Đường dẫn video. App vs Book không cần"> <br> <br>
				<button>Thêm</button>
			</form>
		</div>
	</body>
	<script type="text/javascript" src="Views/Android/js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="Views/Android/js/app4phone.js"></script>
</html>