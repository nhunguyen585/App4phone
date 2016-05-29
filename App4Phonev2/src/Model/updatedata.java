package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class updatedata {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		connect con1 = new connect();
		ConnectDatabase con2 = new ConnectDatabase();
		ResultSet rs = con2.getData("select * from AndroidBook");
		while(rs.next()){
			con1.updateData("insert into androidbook values('"+rs.getString(1)+"','"+rs.getString(2)+"','"+rs.getString(3)+"','"+rs.getString(4)+"','"+rs.getString(5)+"','"+rs.getString(6)+"','"+rs.getString(7)+"','NULL','"+rs.getString(8)+"')     ");
		}
//		ResultSet rs3 = con2.getData("select * from AndroidApp");
//		while(rs3.next()){
//			con1.updateData("insert into androidapp values('"+rs3.getString(1)+"','"+rs3.getString(2)+"','"+rs3.getString(3)+"','"+rs3.getString(4)+"','"+rs3.getString(5)+"','"+rs3.getString(6)+"','"+rs3.getString(7)+"','NULL','"+rs3.getString(9)+"')     ");
//		}
		ResultSet rs2 = con2.getData("select * from AndroidGame");
		while(rs2.next()){
			con1.updateData("insert into androidgame values('"+rs2.getString(1)+"','"+rs2.getString(2)+"','"+rs2.getString(3)+"','"+rs2.getString(4)+"','"+rs2.getString(5)+"','"+rs2.getString(6)+"','"+rs2.getString(7)+"','"+rs2.getString(8)+"','"+rs2.getString(9)+"')");
		}
	}
}
