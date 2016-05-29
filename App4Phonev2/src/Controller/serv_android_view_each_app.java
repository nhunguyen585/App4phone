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

public class serv_android_view_each_app extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public serv_android_view_each_app() {
        super();     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int position = 0;
		try {
			for(int i = 0; i < 100; i++){
				if(request.getParameter(i+"") != null){
					position = i;
					break;	
				}
			}
			if(position == 0){
				position = (int) session.getAttribute("position");
			}
			ResultSet rs_app = new getInfoDatabase().getGameAppBook("androidapp", position);
			ResultSet rs_app_top = new getInfoDatabase().getTop("androidapp");
			session.setAttribute("rs_app_top", rs_app_top);
			session.setAttribute("rs_app", rs_app);
			session.setAttribute("position", position);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("jsp_android_view_each_app");
	}
}
