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

public class serv_app4phone extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public serv_app4phone() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			ResultSet rs_top_game = new getInfoDatabase().getTop("androidgame");
			ResultSet rs_top_app = new getInfoDatabase().getTop("androidapp");
			ResultSet rs_top_book = new getInfoDatabase().getTop("androidbook");
			session.setAttribute("rs_top_game", rs_top_game);
			session.setAttribute("rs_top_app", rs_top_app);
			session.setAttribute("rs_top_book", rs_top_book);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("jsp_app4phone");
	}

}
