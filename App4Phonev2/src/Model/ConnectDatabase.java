package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDatabase {
	private Connection con;
	private String user = "sa";
	private String pass = "nhu";
	private String url = "jdbc:sqlserver://NHUNGUYEN-PC;databaseName=App4Phone";
	public ConnectDatabase() throws ClassNotFoundException, SQLException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection(url, user, pass);
	}
	public ResultSet getData(String sql) throws SQLException{
		Statement st = con.createStatement();
		return st.executeQuery(sql);
	}
	public int updateData(String sql) throws Exception{
		Statement st = con.createStatement();
		return st.executeUpdate(sql);
	}
}
