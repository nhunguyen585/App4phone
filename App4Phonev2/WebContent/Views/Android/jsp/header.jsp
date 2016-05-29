<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="header">
	<div id="image">
		<a href="jsp_app4phone"><img src="Views/Image/icon.jpg"></a>	
	</div>
	
	<div id="search">
		<!-- 	<form action="../serv_android_search" method=""> -->
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
		
