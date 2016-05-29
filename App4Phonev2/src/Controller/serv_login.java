package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.getInfoDatabase;

public class serv_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public serv_login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		String url = "";
		if(session.getAttribute("url") != null){
			 url = (String) session.getAttribute("url");
		}
		session.removeAttribute("url");
		if(username == "" || password == ""){
			session.setAttribute("error", "Bạn chưa nhập đủ thông tin");
		}
		String name = null;
		String admin = null;
		try {
			new getInfoDatabase();
			name = getInfoDatabase.checkAccount(username, password);
			admin = getInfoDatabase.checkAdmin(username, password);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		if(name != null){
			//session.setAttribute("name", name);
			Cookie cookie = new Cookie("name", name);
			cookie.setMaxAge(-1);
			response.addCookie(cookie);
		}else{
			session.setAttribute("error", "Tài khoản không tồn tại hoặc nhập sai thông tin");
		}
		if(admin != null){
			if(admin.equals("admin")){
				session.setAttribute("admin", admin);
			}
		}
		response.sendRedirect(url);
	}

}
