package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.entity.teacher;

public class TeacherDao extends C3p0Connection{
	//Insert the new teacher to the table
	public void Insert (teacher t)
	{
		try {
			Connection cn = null;
			Statement st = null;
			cn = getConnection();
			st = cn.createStatement();
			String sql = "insert into teacher(tea_name,tea_sex,tea_age,tea_dep,tea_username,tea_passwd,tea_email,tea_cardid,tea_code,tea_left_borrow,tea_left_applicate) values('"+t.getTea_name()+"','"+t.getTea_sex()+"','"+t.getTea_age()+"','"+t.getTea_dep()+"','"+t.getTea_username()+"','"+t.getTea_passwd()+"','"+t.getTea_email()+"','"+t.getTea_cardid()+"','"+t.getTea_code()+"','"+t.getTea_left_borrow()+"','"+t.getTea_left_applicate()+"')";
			st.executeUpdate(sql);
			System.out.println("Insert successfully");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//select teacher from the table
	public void select()
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "select * from teacher";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("tea_id")+" "+rs.getString("tea_name")+" "+rs.getString("tea_sex")+" "+rs.getInt("tea_age")+" "+rs.getString("tea_dep")+" "+rs.getString("tea_username")+" "+rs.getString("tea_email")+" "+rs.getString("tea_cardid")+" "+rs.getString("tea_code")+" "+rs.getInt("tea_left_borrow")+" "+rs.getInt("tea_left_applicate"));
			}
			System.out.println("select successfully");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//delete the teacher according the id
	public void delete_id(teacher t)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "delete from teacher where tea_id = '"+t.getTea_id()+"'";
			st.executeUpdate(sql);
			System.out.println("delete successfully(id)");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//delete the teacher according the username
	public void delete_username(teacher t)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "delete from teacher where tea_username = '"+t.getTea_username()+"'";
			st.executeUpdate(sql);
			System.out.println("delete successfully(username)");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//change the teacher name from teacher table
		public void changetea_name(String teacher_name,int tea_id)
		{
			try {
				Connection cn = null;
				cn = C3p0Connection.getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update teacher set tea_name = '"+teacher_name+"' where tea_id = '"+tea_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

		//change the teacher sex from teacher table
		public void changetea_sex(String teacher_sex,int tea_id)
		{
			try {
				Connection cn = null;
				cn = C3p0Connection.getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update teacher set tea_sex = '"+teacher_sex+"' where tea_id = '"+tea_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

		//change the teacher age from teacher table
		public void changetea_age(int teacher_age,int tea_id)
		{
			try {
				Connection cn = null;
				cn = C3p0Connection.getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update teacher set tea_age = '"+teacher_age+"' where tea_id = '"+tea_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

		//change the teacher dep from teacher table
		public void changetea_dep(String teacher_dep,int tea_id)
		{
			try {
				Connection cn = null;
				cn = C3p0Connection.getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update teacher set tea_pro = '"+teacher_dep+"' where tea_id = '"+tea_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

		//change the teacher username from teacher table
		public void changetea_username(String teacher_username,int tea_id)
		{
			try {
				Connection cn = null;
				cn = C3p0Connection.getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update teacher set tea_username = '"+teacher_username+"' where tea_id = '"+tea_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

		//change the teacher passwd from teachertable
		public void changetea_passwd(String teacher_passwd,int tea_id)
		{
			try {
				Connection cn = null;
				cn = C3p0Connection.getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update teacher set tea_passwd = '"+teacher_passwd+"' where tea_id = '"+tea_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

		//change the teacher email from teacher table
		public void changetea_email(String teacher_email,int tea_id)
		{
			try {
				Connection cn = null;
				cn = C3p0Connection.getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update teacher set tea_email = '"+teacher_email+"' where tea_id = '"+tea_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

		//change the teacher cardid from teacher table
		public void changetea_cardid(String teacher_cardid,int tea_id)
		{
			try {
				Connection cn = null;
				cn = C3p0Connection.getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update teacher set tea_cardid = '"+teacher_cardid+"' where tea_id = '"+tea_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

		//change the teacher code from teacher table
		public void changetea_code(String teacher_code,int tea_id)
		{
			try {
				Connection cn = null;
				cn = C3p0Connection.getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update teacher set tea_code = '"+teacher_code+"' where tea_id = '"+tea_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

		//change the teacher left borrow from teacher table
		public void changetea_left_borrow(int teacher_left_borrow,int tea_id)
		{
			try {
				Connection cn = null;
				cn = C3p0Connection.getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update teacher set tea_left_borrow = '"+teacher_left_borrow+"' where tea_id = '"+tea_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		//change the teacher left applicate from teacher table
		public void changetea_left_applicate(int teacher_left_applicate,int tea_id)
		{
			try {
				Connection cn = null;
				cn = C3p0Connection.getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update teacher set tea_left_applicate = '"+teacher_left_applicate+"' where tea_id = '"+tea_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	//sign
	public void sign()
	{
		try {
			System.out.println("Welcom to sign");
			System.out.println("Please input the username");
			Scanner s_username = new Scanner(System.in);
			teacher t =new teacher();
			String teacher_username = s_username.nextLine();
			String sql = "select * from teacher where tea_id = '"+teacher_username+"'";
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()==true)
			{
				System.out.println("the username exist ,please input again or login directly");
			}
			else {
				System.out.println("the username is available");
				t.setTea_username(teacher_username);
			}
			while(true)
			{
				System.out.println("Please input the password");
				Scanner s_passwd = new Scanner(System.in);
				String teacher_passwd = s_passwd.nextLine();
				System.out.println("Please input the password agin");
				Scanner s_passwd2 = new Scanner(System.in);
				String teacher_passwd2 = s_passwd2.nextLine();
				if(teacher_passwd.equals(teacher_passwd2))
				{
					System.out.println("input successfully");
					t.setTea_passwd(teacher_passwd);
					break;
				}
				System.out.println("input unconformably,please input again");
			}
			System.out.println("Please input the sex ");
			Scanner s_sex = new Scanner(System.in);
			String teacher_sex = s_sex.nextLine();
			t.setTea_sex(teacher_sex);
			
			System.out.println("Please input the age");
			Scanner s_age = new Scanner(System.in);
			int teacher_age = Integer.parseInt(s_age.nextLine());
			t.setTea_age(teacher_age);
			
			System.out.println("Please input the deperation");
			Scanner s_dep = new Scanner(System.in);
			String teacher_dep = s_dep.nextLine();
			t.setTea_dep(teacher_dep);
			System.out.println("Please input the realname");
			Scanner s_name = new Scanner(System.in);
			String teacher_name = s_name.nextLine();
			t.setTea_name(teacher_name);
			while(true) {
				System.out.println("Please input the email");
				Scanner s_email = new Scanner(System.in);
				String teacher_email = s_email.nextLine();
				String sql1 = "select * from teacher where tea_email = '"+teacher_email+"'";
				ResultSet rs1 =st.executeQuery(sql1);
				if(!checkEmail(teacher_email))
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
					t.setTea_email(teacher_email);
					break;
				}
			}
				
			while(true){
				System.out.println("Please input the ID card");
				Scanner s_cardid = new Scanner(System.in);
				String teacher_cardid = s_cardid.nextLine();
				String sql2 = "select * from teacher where tea_cardid= '"+teacher_cardid+"'";
				ResultSet rs2 =st.executeQuery(sql2);
				if(teacher_cardid.length()!=18){	
					System.out.println("The ID card is not available, please input again");
					continue;
				}
				if(rs2.next()==true)
				{
					System.out.println("The ID card exists ,please login or input again");
				}
				else {
					System.out.println("The ID card is available");
					t.setTea_cardid(teacher_cardid);
					break;
				}
			}
			
			System.out.println("Please input the code");
			Scanner s_code = new Scanner(System.in);
			String teacher_code = s_code.nextLine();
			String sql3 = "select * from teacher where tea_code= '"+teacher_code+"'";
			ResultSet rs3 =st.executeQuery(sql3);
			if(rs3.next()==true)
			{
				System.out.println("The code exists ,please login or input again");
			}
			else {
				System.out.println("The code is available");
				t.setTea_code(teacher_code);
			}
			
			System.out.println("sign successfully");
			TeacherDao td = new TeacherDao();
			td.Insert(t);
			
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
				String teacher_username = s_username.nextLine();	
				String sql = "select * from teacher where tea_username = '"+teacher_username+"'";
				Connection cn = null;
				cn = getConnection();
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
				String teacher_passwd = s_passwd.nextLine();
				String sql1 = "select * from teacher where tea_username ='"+teacher_username+"' and tea_passwd = '"+teacher_passwd+"'";
				Connection cn1 = null;
				cn1 = getConnection();
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
					String teacher_cardid = s_cardid.nextLine();
					String sql2 = "select * from teacher where tea_username ='"+teacher_username+"' and tea_passwd = '"+teacher_passwd+"' and tea_cardid= '"+teacher_cardid+"'";
					Connection cn2 = null;
					cn2 = getConnection();
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
					String teacher_email = s_email.nextLine();
					String sql3 = "select * from teacher where tea_username ='"+teacher_username+"' and tea_passwd = '"+teacher_passwd+"' and tea_email= '"+teacher_email+"'";
					Connection cn3 = null;
					cn3 = getConnection();
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
					String teacher_code = s_code.nextLine();
					String sql4 =  "select * from teacher where tea_username ='"+teacher_username+"' and tea_passwd = '"+teacher_passwd+"' and tea_code= '"+teacher_code+"'";
					Connection cn4 = null;
					cn4 = getConnection();
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
	public void test() {
		//sign();
		login();
	}
}
