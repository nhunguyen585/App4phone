<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<% if(session.getAttribute("admin") != null){ %>
	<div id="admin">
		<img src="Image/admin.png">
	</div>
<% } %>