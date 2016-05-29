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

public class serv_android_apptintuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public serv_android_apptintuc() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ResultSet rs_app_tintuc = new getInfoDatabase().getTopByMuc("androidapp", "1");
			HttpSession session = request.getSession();
			session.setAttribute("rs_app_tintuc", rs_app_tintuc);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("jsp_android_apptintuc");
	}
}
