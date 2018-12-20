package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public abstract class C3p0Connection {
	private static ComboPooledDataSource ds = null;
	static {
		try {
			ds = new ComboPooledDataSource("");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void release(Connection conn,Statement st, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(st!=null) {
			try {
				st.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			st = null;
		}
		if(conn!=null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
