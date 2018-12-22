package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.entity.AppStudent;
import com.entity.AppTeacher;

public class AppStudentDao extends C3p0Connection{
	//insert a new application to the AppStudent table
	public void Insert(AppStudent as)
	{
		try {
			Connection cn = null;
			Statement st = null;
			cn = getConnection();
			st = cn.createStatement();
			String sql = "insert into app_student (stu_id,book_id,app_date)values('"+as.getStu_id()+"','"+as.getBook_id()+"','"+as.getApp_date()+"')";
			st.executeUpdate(sql);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//select all application from appStudent table 
	public void select()
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "select * from app_student";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getInt("app_student_id")+" "+rs.getInt("stu_id")+" "+rs.getInt("book_id")+" "+rs.getString("app_date"));
				
			}
			}catch(SQLException e )
			{
				e.printStackTrace();
			}
		}
	
	//delete the application table according the id
	public void delete(AppStudent as)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "delete from app_student where app_student_id = '"+as.getApp_student_id()+"'";
			st.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//change the application table
	public void change(AppStudent as)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "update app_student set tea_id = '"+as.getStu_id()+"',book_id = '"+as.getBook_id()+"',app_date = '"+as.getApp_date()+"'";
			st.executeUpdate(sql);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//test
	public void test() {
		AppStudentDao asd = new AppStudentDao();
		AppStudent as = new AppStudent();
		as.setBook_id(1);
		as.setStu_id(1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date =new Date();
		as.setApp_date(df.format(date));
		asd.Insert(as);
		asd.select();
		System.out.println();
		AppStudent as1 = new AppStudent();
		as1.setApp_student_id(1);
		asd.delete(as1);
		asd.select();
	}
}
