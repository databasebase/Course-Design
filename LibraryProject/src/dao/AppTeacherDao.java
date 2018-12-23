package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.entity.AppTeacher;

public class AppTeacherDao extends C3p0Connection{
	//insert a new application to the AppTeacher table
	public void Insert(AppTeacher at)
	{
		try {
			Connection cn = null;
			Statement st = null;
			cn = getConnection();
			st = cn.createStatement();
			String sql = "insert into app_teacher (tea_id,book_id,app_date)values('"+at.getTea_id()+"','"+at.getBook_id()+"','"+at.getApp_date()+"')";
			st.executeUpdate(sql);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//select all application from application_teacher table
	public void select()
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "select * from app_teacher";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getInt("app_teacher_id")+" "+rs.getInt("tea_id")+" "+rs.getInt("book_id")+" "+rs.getString("app_date"));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//delete the application table according the id
	public void delete(AppTeacher at)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "delete from app_teacher where app_teacher_id = '"+at.getApp_teacher_id()+"'";
			st.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//change the teacher_id from application table
		public void changetea_id(int teacher_id,int app_teacher_id)
		{
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update app_teacher set tea_id = '"+teacher_id+"' where app_teacher_id = '"+app_teacher_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		//change the book_id from application table
			public void changebook_id(int book_id,int app_teacher_id)
			{
				try {
					Connection cn = null;
					cn = getConnection();
					Statement st = null;
					st = cn.createStatement();
					String sql = "update app_teacher set book_id = '"+book_id+"' where app_teacher_id = '"+app_teacher_id+"'";
					st.executeUpdate(sql);
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			//change the app_date from application table
			public void changeapp_date(String app_date,int app_teacher_id)
			{
				try {
					Connection cn = null;
					cn = getConnection();
					Statement st = null;
					st = cn.createStatement();
					String sql = "update app_teacher set app_date = '"+app_date+"' where app_teacher_id = '"+app_teacher_id+"'";
					st.executeUpdate(sql);
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
	//test
	public void test() {
		AppTeacherDao atd = new AppTeacherDao();
		AppTeacher at = new AppTeacher();
		at.setBook_id(1);
		at.setTea_id(1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date =new Date();
		at.setApp_date(df.format(date));
		atd.Insert(at);
		atd.select();
		System.out.println();
		AppTeacher at1 = new AppTeacher();
		at1.setApp_teacher_id(1);
		atd.delete(at1);
		atd.select();
	}
}
