package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.entity.AppStudent;

public class AppStudentDao extends C3p0Connection{
	//insert a new application to the AppStudent table
	public void Insert(AppStudent at)
	{
		try {
			Connection cn = null;
			Statement st = null;
			cn = getConnection();
			st = cn.createStatement();
			String sql = "insert into app_student (stu_id,book_id,app_date)values('"+at.getStu_id()+"','"+at.getBook_id()+"','"+at.getApp_date()+"')";
			st.executeUpdate(sql);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//select all application from application_student table
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
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//delete the application table according the id
	public void delete(AppStudent at)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "delete from app_student where app_student_id = '"+at.getApp_student_id()+"'";
			st.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//change the student_id from application table
	public void changestu_id(int student_id,int app_student_id)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "update app_student set stu_id = '"+student_id+"' where app_student_id = '"+app_student_id+"'";
			st.executeUpdate(sql);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//change the book_id from application table
		public void changebook_id(int book_id,int app_student_id)
		{
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update app_student set book_id = '"+book_id+"' where app_student_id = '"+app_student_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		//change the app_date from application table
		public void changeapp_date(String app_date,int app_student_id)
		{
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update app_student set app_date = '"+app_date+"' where app_student_id = '"+app_student_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	//test
	public void test() {
		AppStudentDao atd = new AppStudentDao();
		AppStudent at = new AppStudent();
		at.setBook_id(1);
		at.setStu_id(1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date =new Date();
		at.setApp_date(df.format(date));
		atd.Insert(at);
		atd.select();
		System.out.println();
		AppStudent at1 = new AppStudent();
		at1.setApp_student_id(1);
		atd.delete(at1);
		atd.select();
	}
}
