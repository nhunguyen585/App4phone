package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Object;
import Model.getInfoDatabase;

public class serv_android_search extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public serv_android_search() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("search");
		HttpSession session = request.getSession();
		session.setAttribute("word", name);
		ArrayList<Object> result = null;
		if(name == null){
			name = (String) session.getAttribute("word");
		}
		try {
			new getInfoDatabase();
			result = getInfoDatabase.search(name);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("result", result);
		response.sendRedirect("jsp_android_search");
	}
}
