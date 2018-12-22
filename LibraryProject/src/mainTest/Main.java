package mainTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.book;

import dao.AppStudentDao;
import dao.AppTeacherDao;
import dao.BookDao;
import dao.BorrowStudentDao;
import dao.BorrowTeacherDao;
import dao.C3p0Connection;
import dao.TeacherDao;

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
//			BookDao bd = new BookDao();
//			bd.test();
			//TeacherDao td = new TeacherDao();
			//td.test();
			//AppTeacherDao atd = new AppTeacherDao();
			//atd.test();
			BorrowStudentDao btd = new BorrowStudentDao();
			btd.test();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
