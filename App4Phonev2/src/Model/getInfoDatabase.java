package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class getInfoDatabase {
	public ResultSet getTop(String position) throws ClassNotFoundException, SQLException{
		//ConnectDatabase con = new ConnectDatabase();
		connect con = new connect();
		return con.getData("select * from "+position+" order by download desc");
	}
	public ResultSet getTopByMuc(String position, String muc) throws ClassNotFoundException, SQLException{
		//ConnectDatabase con = new ConnectDatabase();
		connect con = new connect();
		return con.getData("select * from "+position+" where muc='"+muc+"' order by download desc");
	}
	public ResultSet getGameAppBook(String position, int id) throws ClassNotFoundException, SQLException{
		//ConnectDatabase con = new ConnectDatabase();
		connect con = new connect();
		return con.getData("select * from "+position+" where id='"+id+"'");
	}
	public static String checkAccount(String username, String password) throws ClassNotFoundException, SQLException{
		//ConnectDatabase con = new ConnectDatabase();
		connect con = new connect();
		ResultSet rs = con.getData("select * from account where username='"+username+"' and password='"+password+"' ");
		while(rs.next()){
			return rs.getString(3);
		}
		return null;
	}
	public static String checkAdmin(String username, String password) throws ClassNotFoundException, SQLException{
		connect con = new connect();
		ResultSet rs = con.getData("select * from account where username='"+username+"' and password='"+password+"' ");
		while(rs.next()){
			return rs.getString(4);
		}
		return null;
	}
	public int addAccount(String name, String username, String password) throws Exception{
		if(checkAccount(username, password) != null){
			return 0;
		}else{
			//ConnectDatabase con = new ConnectDatabase();
			connect con = new connect();
			con.updateData("insert into account values('"+username+"','"+password+"','"+name+"') ");
			return 1;
		}
	}
	public void addApp(String table, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9) throws ClassNotFoundException, SQLException{
		connect con = new connect();
		int i = 0;
		ResultSet rs = con.getData("select * from "+table);
		while(rs.next()){
			i++;
		}
		i++;
		if(table.equals("AndroidGame")){
			con.updateData("insert into "+table+" values('"+i+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"')");
		}else{
			con.updateData("insert into "+table+" values('"+i+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','NULL','"+s8+"')");
		}
	}
	public static ArrayList<Object> search(String word) throws ClassNotFoundException, SQLException{
		word = word.toLowerCase();
		connect con = new connect();
		ArrayList<Object> rs_rs = new ArrayList<>();
		ResultSet rs = con.getData("select * from androidgame");
		ResultSet rs2 = con.getData("select * from androidapp");
		ResultSet rs3 = con.getData("select * from androidbook");
		while(rs.next()){
			String s = rs.getString(2);
			s = s.toLowerCase();
			if(s.indexOf(word) > -1){
				Object in = new Object(rs.getString(1), rs.getString(2), rs.getString(4), "serv_android_view_each_game");
				rs_rs.add(in);
			}
		}
		while(rs2.next()){
			String s = rs2.getString(2);
			s = s.toLowerCase();
			if(s.indexOf(word) > -1){
				Object in = new Object(rs2.getString(1), rs2.getString(2), rs2.getString(4), "serv_android_view_each_app");
				rs_rs.add(in);
			}
		}
		while(rs3.next()){
			String s = rs3.getString(2);
			s = s.toLowerCase();
			if(s.indexOf(word) > -1){
				Object in = new Object(rs3.getString(1), rs3.getString(2), rs3.getString(4), "serv_android_view_each_book");
				rs_rs.add(in);
			}
		}
		return rs_rs;
	}
}
