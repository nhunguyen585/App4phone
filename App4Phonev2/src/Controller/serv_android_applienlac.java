package Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.getInfoDatabase;

public class serv_android_applienlac extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public serv_android_applienlac() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ResultSet rs_app_lienlac = new getInfoDatabase().getTopByMuc("androidapp", "2");
			HttpSession session = request.getSession();
			session.setAttribute("rs_app_lienlac", rs_app_lienlac);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("jsp_android_applienlac");
	}
}
