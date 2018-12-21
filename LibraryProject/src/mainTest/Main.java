package mainTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import dao.AppStudentDao;
import dao.BookDao;
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
			//AppStudentDao as = new AppStudentDao();
			//as.Insert(101, 110, 123, "2018/12/20");
			BookDao bd = new BookDao();
			bd.Insert(101, "时间简史", "史蒂芬霍金", "伟大的书籍","101室", "北京林业大学出版社", 2, "2018/12/21", 3, 23.5, "科学",2 );
			bd.select();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
