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

public class serv_android_view_each_book extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public serv_android_view_each_book() {
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
			ResultSet rs_book = new getInfoDatabase().getGameAppBook("androidbook", position);
			ResultSet rs_book_top = new getInfoDatabase().getTop("androidbook");
			session.setAttribute("rs_book_top", rs_book_top);
			session.setAttribute("rs_book", rs_book);
			session.setAttribute("position", position);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("jsp_android_view_each_book");
	}
}
