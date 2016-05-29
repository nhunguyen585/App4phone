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

public class serv_android_gamenew extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public serv_android_gamenew() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			ResultSet rs_game_new = new getInfoDatabase().getTopByMuc("androidgame", "new");
			session.setAttribute("rs_game_new", rs_game_new);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("jsp_android_gamenew");
	}
}
