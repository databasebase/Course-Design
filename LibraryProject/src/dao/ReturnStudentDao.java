package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.entity.ReturnStudent;
import com.entity.ReturnTeacher;
import com.entity.teacher;



public class ReturnStudentDao extends C3p0Connection{
	public void Insert (ReturnStudent r)
	{
		try {
			Connection cn = null;
			Statement st = null;
			cn = getConnection();
			st = cn.createStatement();
			String sql = "insert into return_student(stu_id,book_id,return_date,manager_id,book_health) values('"+r.getStu_id()+"','"+r.getBook_id()+"','"+r.getReturn_date()+"','"+r.getManager_id()+"','"+r.getBook_health()+"'";
			st.executeUpdate(sql);
			System.out.println("Insert successfully");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void select()
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "select * from return_student";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("return_student_id")+" "+rs.getInt("stu_id")+" "+rs.getInt("book_id")+" "+rs.getString("return_date")+" "+rs.getInt("manager_id")+" "+rs.getInt("book_health"));
			}
			System.out.println("select successfully");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete_id(ReturnStudent r)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "delete from return_student where return_student_id = '"+r.getReturn_student_id()+"'";
			st.executeUpdate(sql);
			System.out.println("delete successfully(id)");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void change(ReturnStudent r)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "update return_student set stu_id = '"+r.getStu_id()+"',book_id = '"+r.getBook_id()+"',return_date = '"+r.getReturn_date()+"',manager_id = '"+r.getManager_id()+"',book_health = '"+r.getBook_health()+"'";
			st.executeUpdate(sql);
			System.out.println("change successfully");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
