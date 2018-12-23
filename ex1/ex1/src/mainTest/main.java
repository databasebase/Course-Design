package mainTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.C3p0Connection;
import dao.managerDao;
import dao.usersDao;



public class main {
	public static void main(String[] args)
	{
		//Connection conn = JdbcUtil.getConnection();
		//Connection conn = DbcpJdbcUtil.getConnection();
		
		//AppStudentDao as = new AppStudentDao();
		//as.Insert(101, 110, 123, "2018/12/20");
//			BookDao bd = new BookDao();
//			bd.test();
		//TeacherDao td = new TeacherDao();
		//td.test();
		//AppTeacherDao atd = new AppTeacherDao();
		//atd.test();
		managerDao a=new managerDao();
		a.test();
	}
}
