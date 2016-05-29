package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connect {
	private Connection con;
	private String url = "jdbc:mysql://localhost:3306/app4phone?useUnicode=true&characterEncoding=UTF-8";
	public connect() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,"root","");
	}
	public ResultSet getData(String sql) throws SQLException{
		Statement s = con.createStatement();
		return s.executeQuery(sql);
	}
	public int updateData(String sql) throws SQLException{
		Statement s = con.createStatement();
		return s.executeUpdate(sql);
	}
}
