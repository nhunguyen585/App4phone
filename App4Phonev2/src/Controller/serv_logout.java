package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class serv_logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public serv_logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "";
		if(session.getAttribute("url") != null){
			 url = (String) session.getAttribute("url");
		}
		session.removeAttribute("url");
		session.removeAttribute("admin");
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		for(int i = 0; i < cookies.length; i++){
			if(cookies[i].getName().equals("name")){
				cookie = cookies[i];
				cookie.setMaxAge(0);
				if(cookie != null)
					response.addCookie(cookie);
				break;
			}
		}
		//response.sendRedirect("jsp_app4phone");
		response.sendRedirect(url);
	}

}
