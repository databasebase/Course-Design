package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.entity.*;


public class usersDao {
	public static void View() {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from users";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("user_id") + " " + rs.getString("user_name") + " "+ rs.getString("user_sex") + " " + rs.getString("user_age") + " " + rs.getString("user_email")+ " " + rs.getString("user_cardid")+ " " + rs.getString("user_code"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void Insert(users u) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into users values('" + u.getUser_id() + "','" + u.getUser_name() + "','" + u.getUser_sex()
					+ "','" + u.getUser_age()+"','"+u.getUser_email()+"','"+u.getUser_cardid()+"','"+u.getUser_code()+"'";
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
			String sql = "delete from users where user_id='" + id + "';";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Change(users u) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			stmt = conn.createStatement();
			String sql = "update book set user_id = '" + u.getUser_id() + "',user_name = '" + u.getUser_name()
					+ "',user_sex = '" + u.getUser_age() + "',user_age='"+u.getUser_age()+"',user_email='"+u.getUser_email()+"',user_cardid='"+u.getUser_cardid()+"',user_code='"+u.getUser_code()+"'";
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
			Scanner u_username = new Scanner(System.in);
			users u =new users();
			String user_name = u_username.nextLine();
			String sql = "select * from users where user_name = '"+user_name+"'";
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
				u.setUser_name(user_name);
			}
			while(true)
			{
				System.out.println("Please input the password");
				Scanner s_passwd = new Scanner(System.in);
				String user_passwd = s_passwd.nextLine();
				System.out.println("Please input the password again");
				Scanner s_passwd2 = new Scanner(System.in);
				String user_passwd2 = s_passwd2.nextLine();
				if(user_passwd.equals(user_passwd2))
				{
					System.out.println("input successfully");
					u.setUser_password(user_passwd);
					break;
				}
				System.out.println("input unconformably,please input again");
			}
			System.out.println("Please input the sex ");
			Scanner s_sex = new Scanner(System.in);
			String user_sex = s_sex.nextLine();
			u.setUser_sex(user_sex);
			
			System.out.println("Please input the age");
			Scanner s_age = new Scanner(System.in);
			int user_age = Integer.parseInt(s_age.nextLine());
			u.setUser_age(user_age);
			
			
			while(true) {
				System.out.println("Please input the email");
				Scanner s_email = new Scanner(System.in);
				String user_email = s_email.nextLine();
				String sql1 = "select * from users where user_email = '"+user_email+"'";
				ResultSet rs1 =st.executeQuery(sql1);
				if(!checkEmail(user_email))
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
					u.setUser_email(user_email);;
					break;
				}
			}
				
			while(true){
				System.out.println("Please input the ID card");
				Scanner s_cardid = new Scanner(System.in);
				String user_cardid = s_cardid.nextLine();
				String sql2 = "select * from users where user_cardid= '"+user_cardid+"'";
				ResultSet rs2 =st.executeQuery(sql2);
				if(user_cardid.length()!=18){	
					System.out.println("The ID card is not available, please input again");
					continue;
				}
				if(rs2.next()==true)
				{
					System.out.println("The ID card exists ,please login or input again");
				}
				else {
					System.out.println("The ID card is available");
					u.setUser_cardid(user_cardid);
					break;
				}
			}
			
			System.out.println("Please input the code");
			Scanner s_code = new Scanner(System.in);
			String user_code = s_code.nextLine();
			String sql3 = "select * from users where user_code= '"+user_code+"'";
			ResultSet rs3 =st.executeQuery(sql3);
			if(rs3.next()==true)
			{
				System.out.println("The code exists ,please login or input again");
			}
			else {
				System.out.println("The code is available");
				u.setUser_code(user_code);
			}
			
			System.out.println("sign successfully");
			usersDao ud = new usersDao();
			ud.Insert(u);
			
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
				String user_name = s_username.nextLine();	
				String sql = "select * from student where user_name = '"+user_name+"'";
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
				String user_passwd = s_passwd.nextLine();
				String sql1 = "select * from users where user_name ='"+user_name+"' and user_password = '"+user_passwd+"'";
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
					String user_cardid = s_cardid.nextLine();
					String sql2 = "select * from users where user_name ='"+user_name+"' and stu_password = '"+user_passwd+"' and user_cardid= '"+user_cardid+"'";
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
					String user_email = s_email.nextLine();
					String sql3 = "select * from users where user_name ='"+user_name+"' and user_password = '"+user_passwd+"' and user_email= '"+user_email+"'";
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
					String user_code = s_code.nextLine();
					String sql4 =  "select * from users where user_name ='"+user_name+"' and user_password = '"+user_passwd+"' and user_code= '"+user_code+"'";
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
