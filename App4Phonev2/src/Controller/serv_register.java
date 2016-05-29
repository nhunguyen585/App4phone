package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.getInfoDatabase;


public class serv_register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public serv_register() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		HttpSession session = request.getSession();
		String url = "";
		if(session.getAttribute("url") != null){
			 url = (String) session.getAttribute("url");
		}
		session.removeAttribute("url");
		if(name == "" || username == "" || password == ""){
			session.setAttribute("error", "Bạn chưa nhập đủ thông tin!");
		}
		if(!password.equals(repassword) && session.getAttribute("error") == null){
			session.setAttribute("error", "Mật khẩu không giống nhau");
		}
		try {
			if(session.getAttribute("error") == null){
				if(new getInfoDatabase().addAccount(name, username, password) == 0 ){
					session.setAttribute("error", "Tài khoản đã tồn tại!");
				}else{
					session.setAttribute("error", "Đăng ký thành công!");
					//session.setAttribute("name", name);
					Cookie cookie = new Cookie("name", name);
					cookie.setMaxAge(-1);
					response.addCookie(cookie);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(url);
	}
}
