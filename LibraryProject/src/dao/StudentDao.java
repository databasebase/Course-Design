package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.entity.book;
import com.entity.student;

public class StudentDao {
	public static void View() {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from student";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("stu_id") + " " + rs.getString("stu_name") + " "
						+ rs.getString("stu_sex") + " " + rs.getString("stu_age") + " " + rs.getString("stu_pro") + " "
						+ rs.getString("stu_grade") + " " + rs.getString("stu_username") + " "
						+ rs.getString("stu_email") + " " + rs.getString("stu_cardid") + " "
						+ rs.getString("stu_code"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void Insert(student stu) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into student values('" + stu.getStu_name() + "','" + stu.getStu_sex() + "','" + stu.getStu_age()
					+ "','" + stu.getStu_pro()+ "','" + stu.getStu_grade() + "','" + stu.getStu_username() + "','" + stu.getStu_passwd() + "','"
					+ stu.getStu_email() + "','" + stu.getStu_cardid() + "','" + stu.getStu_code() + "')";
			stmt.executeUpdate(sql);
			// System.out.println("SUCCESS");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(int id) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "delete from student where stu_id='" + id + "';";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Change(student stu) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			stmt = conn.createStatement();
			String sql = "update book set stu_id = '" + stu.getStu_id() + "',stu_name = '" + stu.getStu_name()
					+ "',stu_sex = '" + stu.getStu_sex() + "',stu_age = '" + stu.getStu_age() + "',stu_pro = '"
					+ stu.getStu_pro() + "',stu_grade= '" + stu.getStu_grade() + "',stu_username = '"
					+ stu.getStu_username()+ "',stu_email = '" + stu.getStu_email() + "',stu_cardid ='"
					+ stu.getStu_cardid() + "',stu_code = '" + stu.getStu_code() + "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sign()
	{
		try {
			System.out.println("Welcom to sign");
			System.out.println("Please input the username");
			Scanner s_username = new Scanner(System.in);
			student stu =new student();
			String student_username = s_username.nextLine();
			String sql = "select * from student where stu_id = '"+student_username+"'";
			Connection cn = C3p0Connection.getConnection();
			Statement st = null;
			st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()==true)
			{
				System.out.println("the username exist ,please input again or login directly");
			}
			else {
				System.out.println("the username is available");
				stu.setStu_username(student_username);
			}
			while(true)
			{
				System.out.println("Please input the password");
				Scanner s_passwd = new Scanner(System.in);
				String student_passwd = s_passwd.nextLine();
				System.out.println("Please input the password agin");
				Scanner s_passwd2 = new Scanner(System.in);
				String student_passwd2 = s_passwd2.nextLine();
				if(student_passwd.equals(student_passwd2))
				{
					System.out.println("input successfully");
					stu.setStu_passwd(student_passwd);
					break;
				}
				System.out.println("input unconformably,please input again");
			}
			System.out.println("Please input the sex ");
			Scanner s_sex = new Scanner(System.in);
			String student_sex = s_sex.nextLine();
			stu.setStu_sex(student_sex);
			
			System.out.println("Please input the age");
			Scanner s_age = new Scanner(System.in);
			int student_age = Integer.parseInt(s_age.nextLine());
			stu.setStu_age(student_age);
			
			System.out.println("Please input the pro");
			Scanner s_pro = new Scanner(System.in);
			String student_pro = s_pro.nextLine();
			stu.setStu_pro(student_pro);
			
			System.out.println("Please input the grade");
			Scanner s_grade = new Scanner(System.in);
			String student_grade = s_grade.nextLine();
			stu.setStu_grade(Integer.valueOf(student_grade));
			
			System.out.println("Please input the username");
			Scanner s_name = new Scanner(System.in);
			String student_name = s_name.nextLine();
			stu.setStu_username(student_name);
			while(true) {
				System.out.println("Please input the email");
				Scanner s_email = new Scanner(System.in);
				String student_email = s_email.nextLine();
				String sql1 = "select * from student where stu_email = '"+student_email+"'";
				ResultSet rs1 =st.executeQuery(sql1);
				if(!checkEmail(student_email))
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
					stu.setStu_email(student_email);;
					break;
				}
			}
				
			while(true){
				System.out.println("Please input the ID card");
				Scanner s_cardid = new Scanner(System.in);
				String student_cardid = s_cardid.nextLine();
				String sql2 = "select * from student where stu_cardid= '"+student_cardid+"'";
				ResultSet rs2 =st.executeQuery(sql2);
				if(student_cardid.length()!=18){	
					System.out.println("The ID card is not available, please input again");
					continue;
				}
				if(rs2.next()==true)
				{
					System.out.println("The ID card exists ,please login or input again");
				}
				else {
					System.out.println("The ID card is available");
					stu.setStu_cardid(student_cardid);
					break;
				}
			}
			
			System.out.println("Please input the code");
			Scanner s_code = new Scanner(System.in);
			String student_code = s_code.nextLine();
			String sql3 = "select * from student where stu_code= '"+student_code+"'";
			ResultSet rs3 =st.executeQuery(sql3);
			if(rs3.next()==true)
			{
				System.out.println("The code exists ,please login or input again");
			}
			else {
				System.out.println("The code is available");
				stu.setStu_code(student_code);
			}
			
			System.out.println("sign successfully");
			StudentDao sd = new StudentDao();
			sd.Insert(stu);
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//login
	public void login()
	{
		try {
			while(true)
			{
				int flag = 0;
				System.out.println("Please login");
				System.out.println("Please input the username");
				Scanner s_username = new Scanner(System.in);
				String student_username = s_username.nextLine();	
				String sql = "select * from student where stu_username = '"+student_username+"'";
				Connection cn = C3p0Connection.getConnection();
				Statement st = null;
				st = cn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if(rs.next())
				{
					flag++;
				}
				System.out.println("flag is "+flag);
				
				
				System.out.println("Please input the password");
				Scanner s_passwd = new Scanner(System.in);
				String student_passwd = s_passwd.nextLine();
				String sql1 = "select * from student where stu_username ='"+student_username+"' and stu_passwd = '"+student_passwd+"'";
				Connection cn1 = C3p0Connection.getConnection();
				Statement st1 = null;
				st1 = cn.createStatement();
				ResultSet rs1 = st1.executeQuery(sql1);
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
					Scanner s_cardid = new Scanner(System.in);
					String student_cardid = s_cardid.nextLine();
					String sql2 = "select * from student where stu_username ='"+student_username+"' and stu_passwd = '"+student_passwd+"' and stu_cardid= '"+student_cardid+"'";
					Connection cn2 = C3p0Connection.getConnection();
					Statement st2 = null;
					st2 = cn2.createStatement();
					ResultSet rs2 =st2.executeQuery(sql2);
					if(rs2.next())
					{
						flag++;
					}
					break;
				
				case 2:
					System.out.print("Your email is ");
					Scanner s_email = new Scanner(System.in);
					String student_email = s_email.nextLine();
					String sql3 = "select * from student where stu_username ='"+student_username+"' and stu_passwd = '"+student_passwd+"' and stu_email= '"+student_email+"'";
					Connection cn3 = C3p0Connection.getConnection();
					Statement st3 = null;
					st3 = cn.createStatement();
					ResultSet rs3 = st3.executeQuery(sql3);
					if(rs3.next())
					{
						flag++;
					}
					break;
				
				case 3:
					System.out.print("Your code is ");
					Scanner s_code = new Scanner(System.in);
					String student_code = s_code.nextLine();
					String sql4 =  "select * from student where stu_username ='"+student_username+"' and stu_passwd = '"+student_passwd+"' and stu_code= '"+student_code+"'";
					Connection cn4 = C3p0Connection.getConnection();
					Statement st4 = null;
					st4 = cn.createStatement();
					ResultSet rs4 = st4.executeQuery(sql4);
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

}
