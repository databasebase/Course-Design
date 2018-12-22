package mainTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.book;

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
			book b = new book();
			b.setBook_name("时间简史");
			b.setBook_aut("史蒂芬霍金");
			b.setBook_intro("伟大的书籍");
			b.setBook_addr("101室");
			b.setBook_ok("北京林业大学出版社");
			b.setBook_health(2);
			b.setBook_record("2018/12/21");
			b.setBook_borrow_times(3);
			b.setBook_price(23.5);
			b.setBook_sort("科学");
			b.setBook_state(2 );
			bd.Insert(b);
			bd.select();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
