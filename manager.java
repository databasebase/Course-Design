package mainTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.C3p0Connection;

public class manager {
	public static void view_stu() {
	try {
		//Connection conn = JdbcUtil.getConnection();
		//Connection conn = DbcpJdbcUtil.getConnection();
		Connection conn = C3p0Connection.getConnection();
		Statement stmt = conn.createStatement();
		String sql="select * from student";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString("stu_id")+" "+rs.getString("stu_name")+" "+rs.getString("stu_sex")+" "+rs.getString("stu_age")+" "+rs.getString("stu_pro")+" "+rs.getString("stu_grade")+" "+rs.getString("stu_username")+" "+rs.getString("stu_email")+" "+rs.getString("stu_cardid")+" "+rs.getString("stu_code"));
		}
		//System.out.println("SUCCESS");
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}
	public static void view_tea() {
		try {
			//Connection conn = JdbcUtil.getConnection();
			//Connection conn = DbcpJdbcUtil.getConnection();
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql="select * from teacher";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("tea_id")+" "+rs.getString("tea_name")+" "+rs.getString("tea_sex")+" "+rs.getString("tea_age")+" "+rs.getString("tea_pro")+" "+rs.getString("tea_grade")+" "+rs.getString("tea_username")+" "+rs.getString("tea_email")+" "+rs.getString("tea_cardid")+" "+rs.getString("tea_code"));
			}
			//System.out.println("SUCCESS");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void delete_stu(String id) {
		try {
			//Connection conn = JdbcUtil.getConnection();
			//Connection conn = DbcpJdbcUtil.getConnection();
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql="delete from student where stu_id='"+id+"';";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			//System.out.println("SUCCESS");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void delete_tea(String id) {
		try {
			//Connection conn = JdbcUtil.getConnection();
			//Connection conn = DbcpJdbcUtil.getConnection();
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql="delete from teacher where tea_id='"+id+"';";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			//System.out.println("SUCCESS");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void change_teacher(String id,String tea_name,String tea_sex,String tea_age,String tea_dep,String tea_username,String pass,String tea_email,String tea_cardid,String tea_code) {
		try {
			//Connection conn = JdbcUtil.getConnection();
			//Connection conn = DbcpJdbcUtil.getConnection();
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql="delete from teacher where tea_id='"+id+"';";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			//System.out.println("SUCCESS");
			String sql1="insert into teacher values('"+id+"','"+tea_name+"','"+tea_sex+"','"+tea_age+"','"+tea_dep+"','"+tea_username+"','"+pass+"','"+tea_email+"','"+tea_cardid+"','"+tea_code+"')";
			System.out.println(sql1);
			stmt.executeUpdate(sql1);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void change_stu(String id,String stu_name,String stu_sex,String stu_age,String stu_username,String stu_pro,String stu_grade,String pass,String stu_email,String stu_cardid,String stu_code) {
		try {
			//Connection conn = JdbcUtil.getConnection();
			//Connection conn = DbcpJdbcUtil.getConnection();
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql="delete from student where stu_id='"+id+"';";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			//System.out.println("SUCCESS");
			String sql1="insert into student values('"+id+"','"+stu_name+"','"+stu_sex+"','"+stu_age+"','"+stu_pro+"','"+stu_grade+"','"+stu_username+"','"+pass+"','"+stu_email+"','"+stu_cardid+"','"+stu_code+"')";
			System.out.println(sql1);
			stmt.executeUpdate(sql1);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
