package mainTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.C3p0Connection;

public class Main {
	public static void main(String[] args)
	{
		try {
			//Connection conn = JdbcUtil.getConnection();
			//Connection conn = DbcpJdbcUtil.getConnection();
			C3p0Connection cc = new C3p0Connection();
			Connection conn = cc.getConnection();
			Statement stmt = conn.createStatement();
			System.out.println("SUCCESS");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
