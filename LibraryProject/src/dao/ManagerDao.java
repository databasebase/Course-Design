package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.entity.manager;
import com.entity.teacher;

public class ManagerDao {
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
	public static void view_man() {
		try {
			//Connection conn = JdbcUtil.getConnection();
			//Connection conn = DbcpJdbcUtil.getConnection();
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql="select * from manager";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("manager_id")+" "+rs.getString("manager_name")+" "+rs.getString("manager_age")+" "+rs.getString("manager_phone")+" "+rs.getString("manager_email")+" "+rs.getString("manager_cardid")+" "+rs.getString("manager_code")+" "+rs.getString("manager_username"));
			}
			//System.out.println("SUCCESS");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void Insert_man (manager m)
	{
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into manager(manager_id,manager_name,manager_age,manager_phone,manager_email,manager_cardid,manager_code,manager_username,manager_passwd) values('"+m.getManager_id()+"','"+m.getManager_name()+"','"+m.getManager_age()+"','"+m.getManager_phone()+"','"+m.getManager_email()+"','"+m.getManager_cardid()+"','"+m.getManager_code()+"','"+m.getManager_username()+"','"+m.getManager_passwd()+"')";
			stmt.executeUpdate(sql);
			System.out.println("Insert successfully");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void delete_man_id(manager m)
	{
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "delete from manager where manager_id = '"+m.getManager_id()+"'";
			stmt.executeUpdate(sql);
			System.out.println("delete successfully(id)");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void delete_man_username(manager m) {
		try {
			//Connection conn = JdbcUtil.getConnection();
			//Connection conn = DbcpJdbcUtil.getConnection();
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "delete from manager where manager_username = '"+m.getManager_username()+"'";
			stmt.executeUpdate(sql);
			System.out.println("delete successfully(username)");
		}catch(SQLException e)
		{
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
	public void change_man(manager m)
	{
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "update manager set manager_name = '"+m.getManager_name()+"',manager_age = '"+m.getManager_age()+"',manager_phone = '"+m.getManager_phone()+"',manager_email = '"+m.getManager_email()+"',manager_cardid = '"+m.getManager_cardid()+"',manager_code = '"+m.getManager_code()+"',manager_username = '"+m.getManager_username()+"',manager_passwd = '"+m.getManager_passwd()+"'";
			stmt.executeUpdate(sql);
			System.out.println("change successfully");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void sign_man()
	{
		try {
			System.out.println("Welcom to sign");
			System.out.println("Please input the username");
			Scanner m_username = new Scanner(System.in);
			manager m =new manager();
			String manager_username = m_username.nextLine();
			String sql = "select * from manager where manager_id = '"+manager_username+"'";
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()==true)
			{
				System.out.println("the username exist ,please input again or login directly");
			}
			else {
				System.out.println("the username is available");
				m.setManager_username(manager_username);
			}
			while(true)
			{
				System.out.println("Please input the password");
				Scanner m_passwd = new Scanner(System.in);
				String manager_passwd = m_passwd.nextLine();
				System.out.println("Please input the password agin");
				Scanner m_passwd2 = new Scanner(System.in);
				String manager_passwd2 = m_passwd2.nextLine();
				if(manager_passwd.equals(manager_passwd2))
				{
					System.out.println("input successfully");
					m.setManager_passwd(manager_passwd);
					break;
				}
				System.out.println("input unconformably,please input again");
			}
			System.out.println("Please input the name ");
			Scanner m_name = new Scanner(System.in);
			String manager_name = m_name.nextLine();
			m.setManager_name(manager_name);
			
			System.out.println("Please input the age");
			Scanner m_age = new Scanner(System.in);
			int manager_age = Integer.parseInt(m_age.nextLine());
			m.setManager_age(manager_age);
			
			System.out.println("Please input the phone");
			Scanner m_phone = new Scanner(System.in);
			String manager_phone = m_phone.nextLine();
			m.setManager_phone(manager_phone);
			
			while(true) {
				System.out.println("Please input the email");
				Scanner m_email = new Scanner(System.in);
				String manager_email = m_email.nextLine();
				String sql1 = "select * from manager where manager_email = '"+manager_email+"'";
				ResultSet rs1 =stmt.executeQuery(sql1);
				if(!checkEmail(manager_email))
				{
					System.out.println("The email is not available");
					continue;
				}
				if(rs1.next()==true)
				{
					System.out.println("email exists£¬please login or input again");
				}
				else {
					System.out.println("The email is available");
					m.setManager_email(manager_email);
					break;
				}
			}
				
			while(true){
				System.out.println("Please input the ID card");
				Scanner m_cardid = new Scanner(System.in);
				String manager_cardid = m_cardid.nextLine();
				String sql2 = "select * from manager where manager_cardid= '"+manager_cardid+"'";
				ResultSet rs2 =stmt.executeQuery(sql2);
				if(manager_cardid.length()!=18){	
					System.out.println("The ID card is not available, please input again");
					continue;
				}
				if(rs2.next()==true)
				{
					System.out.println("The ID card exists ,please login or input again");
				}
				else {
					System.out.println("The ID card is available");
					m.setManager_cardid(manager_cardid);
					break;
				}
			}
			
			System.out.println("Please input the code");
			Scanner m_code = new Scanner(System.in);
			String manager_code = m_code.nextLine();
			String sql3 = "select * from manager where manager_code= '"+manager_code+"'";
			ResultSet rs3 =stmt.executeQuery(sql3);
			if(rs3.next()==true)
			{
				System.out.println("The code exists ,please login or input again");
			}
			else {
				System.out.println("The code is available");
				m.setManager_code(manager_code);
			}
			
			System.out.println("sign successfully");
			ManagerDao md = new ManagerDao();
			md.Insert_man(m);
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//login
	public void login_man()
	{
		try {
			while(true)
			{
				int flag = 0;
				System.out.println("Please login");
				System.out.println("Please input the username");
				Scanner m_username = new Scanner(System.in);
				String manager_username = m_username.nextLine();	
				String sql = "select * from manager where manager_username = '"+manager_username+"'";
				Connection conn = C3p0Connection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next())
				{
					flag++;
				}
				System.out.println("flag is "+flag);
				
				
				System.out.println("Please input the password");
				Scanner m_passwd = new Scanner(System.in);
				String manager_passwd = m_passwd.nextLine();
				String sql1 = "select * from manager where manager_username ='"+manager_username+"' and manager_passwd = '"+manager_passwd+"'";
				Connection conn1 = C3p0Connection.getConnection();
				Statement stmt1 = conn.createStatement();
				ResultSet rs1 = stmt1.executeQuery(sql1);
				if(rs1.next())
				{
					flag++;
				}
				System.out.println("flag is "+flag);
				System.out.println("Please choose the verification mode");
				System.out.println("ID card  email  code (method of triads)");
				Scanner s_check = new Scanner(System.in);
				String check = s_check.nextLine();
				int check_flag = 0;
				if(check.equals("ID card"))
				{
					check_flag = 1;
				}
				if(check.equals("email"))
				{
					check_flag = 2;
				}
				if(check.equals("code"))
				{
					check_flag = 3;
				}
				switch (check_flag)
				{
				case 1:
					System.out.print("Your ID card is");
					Scanner m_cardid = new Scanner(System.in);
					String manager_cardid = m_cardid.nextLine();
					String sql2 = "select * from manager where manager_username ='"+manager_username+"' and manager_passwd = '"+manager_passwd+"' and manager_cardid= '"+manager_cardid+"'";
					Connection conn2 = C3p0Connection.getConnection();
					Statement stmt2 = conn.createStatement();
					ResultSet rs2 =stmt2.executeQuery(sql2);
					if(rs2.next())
					{
						flag++;
					}
					break;
				
				case 2:
					System.out.print("Your email is ");
					Scanner m_email = new Scanner(System.in);
					String manager_email = m_email.nextLine();
					String sql3 = "select * from manager where manager_username ='"+manager_username+"' and manager_passwd = '"+manager_passwd+"' and manager_email= '"+manager_email+"'";
					Connection conn3 = C3p0Connection.getConnection();
					Statement stmt3 = conn.createStatement();
					ResultSet rs3 = stmt3.executeQuery(sql3);
					if(rs3.next())
					{
						flag++;
					}
					break;
				
				case 3:
					System.out.print("Your code is ");
					Scanner m_code = new Scanner(System.in);
					String manager_code = m_code.nextLine();
					String sql4 =  "select * from manager where manager_username ='"+manager_username+"' and manager_passwd = '"+manager_passwd+"' and manager_code= '"+manager_code+"'";
					Connection conn4 = C3p0Connection.getConnection();
					Statement stmt4 = conn.createStatement();
					ResultSet rs4 = stmt4.executeQuery(sql4);
					if(rs4.next())
					{
						flag++;
					}
					break;
				default:
					break;
				}
				System.out.println("flag is "+flag);
				System.out.print("Please input the verification code ");
				String s = getStringRandom(6);
				System.out.println(s);
				Scanner s_random = new Scanner(System.in);
				String random = s_random.nextLine();
				if(s.equals(random))
				{
					flag++;
				}
				if(flag == 4)
				{
					System.out.println("Congratulation, login successfully");
					break;
				}
				else {
					System.out.println("flag is "+flag);
					System.out.println("Unfortunately ,please login again");
				}
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//check the email
	public static boolean checkEmail(String email) {
	    boolean flag = false;
	    try {
	        String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	        Pattern regex = Pattern.compile(check);
	        Matcher matcher = regex.matcher(email);
	        flag = matcher.matches();
	    } catch (Exception e) {
	        flag = false;
	    }
	    return flag;
	}
	
	//get the random
	public static String getStringRandom(int length) {
		String val = "";
		Random random = new Random();
		//length the sum of random number
		for(int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			//number or word
			if( "char".equalsIgnoreCase(charOrNum) ) {
				//Capital letter or small letter
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char)(random.nextInt(26) + temp);
			} else if( "num".equalsIgnoreCase(charOrNum) ) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	public void test() {
		login_man();
	
	}
}
