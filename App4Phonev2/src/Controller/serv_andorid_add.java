package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.getInfoDatabase;

public class serv_andorid_add extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public serv_andorid_add() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String table = request.getParameter("aaa");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String path = request.getParameter("path");
		String download = request.getParameter("download");
		String nsx = request.getParameter("nsx");
		String type = request.getParameter("type");
		String muc = request.getParameter("muc");
		String video = request.getParameter("video");
		try {
			new getInfoDatabase().addApp(table, name, description, path, download, nsx, type, muc, video);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println("Đã thêm");
	}
}
