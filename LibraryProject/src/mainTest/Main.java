package mainTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import dao.AppStudentDao;
import dao.C3p0Connection;

public class Main {
	public static void main(String[] args)
	{
		try {
			//Connection conn = JdbcUtil.getConnection();
			//Connection conn = DbcpJdbcUtil.getConnection();
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			System.out.println("SUCCESS");
			AppStudentDao as = new AppStudentDao();
			as.Insert(101, 110, 123, "2018/12/20");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
