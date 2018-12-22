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
	//向老师表中插入新老师
	public void Insert (teacher t)
	{
		try {
			Connection cn = null;
			Statement st = null;
			cn = getConnection();
			st = cn.createStatement();
			String sql = "insert into teacher(tea_id,tea_name,tea_sex,tea_age,tea_dep,tea_username,tea_passwd,tea_email,tea_cardid,tea_code) values('"+t.getTea_id()+"','"+t.getTea_name()+"','"+t.getTea_sex()+"','"+t.getTea_age()+"','"+t.getTea_dep()+"','"+t.getTea_username()+"','"+t.getTea_passwd()+"','"+t.getTea_email()+"','"+t.getTea_cardid()+"','"+t.getTea_code()+"')";
			st.executeUpdate(sql);
			System.out.println("插入成功");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//查询老师表中的老师
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
				System.out.println(rs.getInt("tea_id")+" "+rs.getString("tea_name")+" "+rs.getString("tea_sex")+" "+rs.getInt("tea_age")+" "+rs.getString("tea_dep")+" "+rs.getString("tea_username")+" "+rs.getString("tea_email")+" "+rs.getString("tea_cardid")+" "+rs.getString("tea_code"));
			}
			System.out.println("查询成功");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//删除指定id的老师
	public void delete_id(teacher t)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "delete from teacher where tea_id = '"+t.getTea_id()+"'";
			st.executeUpdate(sql);
			System.out.println("删除成功(id)");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//删除指定username的老师
	public void delete_username(teacher t)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "delete from teacher where tea_username = '"+t.getTea_username()+"'";
			st.executeUpdate(sql);
			System.out.println("删除成功(username)");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//更改老师的表
	public void change(teacher t)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "update book set tea_name = '"+t.getTea_name()+"',tea_sex = '"+t.getTea_sex()+"',tea_age = '"+t.getTea_age()+"',tea_dep = '"+t.getTea_dep()+"',tea_username = '"+t.getTea_username()+"',tea_passwd = '"+t.getTea_passwd()+"',tea_email = '"+t.getTea_email()+"',tea_cardid = '"+t.getTea_cardid()+"',tea_code = '"+t.getTea_code()+"'";
			st.executeUpdate(sql);
			System.out.println("更改成功");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//注册
	public void sign()
	{
		try {
			System.out.println("欢迎注册");
			System.out.print("请输入用户名");
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
				System.out.println("用户名已存在，请登录或重新输入");
			}
			else {
				System.out.println("该用户名可用");
				t.setTea_username(teacher_username);
			}
			while(true)
			{
				System.out.println("请输入密码");
				Scanner s_passwd = new Scanner(System.in);
				String teacher_passwd = s_passwd.nextLine();
				System.out.println("请再次输入密码");
				Scanner s_passwd2 = new Scanner(System.in);
				String teacher_passwd2 = s_passwd2.nextLine();
				if(teacher_passwd.equals(teacher_passwd2))
				{
					System.out.println("输入成功");
					t.setTea_passwd(teacher_passwd);
					break;
				}
				System.out.println("两次输入不成功，请再次输入");
			}
			System.out.println("请输入您的性别");
			Scanner s_sex = new Scanner(System.in);
			String teacher_sex = s_sex.nextLine();
			t.setTea_sex(teacher_sex);
			
			System.out.println("请输入您的年龄");
			Scanner s_age = new Scanner(System.in);
			int teacher_age = Integer.parseInt(s_age.nextLine());
			t.setTea_age(teacher_age);
			
			System.out.println("请输入您的系别");
			Scanner s_dep = new Scanner(System.in);
			String teacher_dep = s_dep.nextLine();
			t.setTea_dep(teacher_dep);
			
			while(true) {
				System.out.println("请输入您的email");
				Scanner s_email = new Scanner(System.in);
				String teacher_email = s_email.nextLine();
				String sql1 = "select * from teacher where tea_email = '"+teacher_email+"'";
				ResultSet rs1 =st.executeQuery(sql1);
				if(!checkEmail(teacher_email))
				{
					System.out.println("该邮箱不符合正确形式");
					continue;
				}
				if(rs1.next()==true)
				{
					System.out.println("email已存在，请登录或重新输入");
				}
				else {
					System.out.println("该email可用");
					t.setTea_email(teacher_email);
					break;
				}
			}
				
			while(true){
				System.out.println("请输入您的身份证号");
				Scanner s_cardid = new Scanner(System.in);
				String teacher_cardid = s_cardid.nextLine();
				String sql2 = "select * from teacher where tea_cardid= '"+teacher_cardid+"'";
				ResultSet rs2 =st.executeQuery(sql2);
				if(teacher_cardid.length()!=18){	
					System.out.println("该身份证号不符，请重新输入");
					continue;
				}
				if(rs2.next()==true)
				{
					System.out.println("身份证号已存在，请登录或重新输入");
				}
				else {
					System.out.println("该身份证号可用");
					t.setTea_cardid(teacher_cardid);
					break;
				}
			}
			
			System.out.println("请输入您的条码号");
			Scanner s_code = new Scanner(System.in);
			String teacher_code = s_code.nextLine();
			String sql3 = "select * from teacher where tea_code= '"+teacher_code+"'";
			ResultSet rs3 =st.executeQuery(sql3);
			if(rs3.next()==true)
			{
				System.out.println("条形码已存在，请登录或重新输入");
			}
			else {
				System.out.println("该条码号可用");
				t.setTea_code(teacher_code);
			}
			
			System.out.println("注册成功");
			TeacherDao td = new TeacherDao();
			td.Insert(t);
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//登陆
	public void login()
	{
		try {
			while(true)
			{
				int flag = 0;
				System.out.println("请登录");
				System.out.println("请输入用户名");
				Scanner s_username = new Scanner(System.in);
				String teacher_username = s_username.nextLine();	
				String sql = "select * from teacher where tea_username = '"+teacher_username+"'";
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if(rs.next()==true)
				{
					flag++;
				}
				System.out.println("请输入密码");
				Scanner s_passwd = new Scanner(System.in);
				String teacher_passwd = s_passwd.nextLine();
				String sql1 = "select * from teacher where tea_username ='"+teacher_username+"',tea_passwd = '"+teacher_passwd+"'";
				ResultSet rs1 = st.executeQuery(sql1);
				if(rs.next() == true)
				{
					flag++;
				}
				System.out.println("请选择验证方式");
				System.out.println("身份证  邮箱  条形码三选一");
				Scanner s_check = new Scanner(System.in);
				String check = s_check.nextLine();
				int check_flag = 0;
				if(check.equals("身份证"))
				{
					check_flag = 1;
				}
				if(check.equals("邮箱"))
				{
					check_flag = 2;
				}
				if(check.equals("条形码"))
				{
					check_flag = 3;
				}
				switch (check_flag)
				{
				case 1:
					Scanner s_cardid = new Scanner(System.in);
					String teacher_cardid = s_cardid.nextLine();
					String sql2 = "select * from teacher where tea_username ='"+teacher_username+"',tea_passwd = '"+teacher_passwd+"',tea_cardid= '"+teacher_cardid+"'";
					ResultSet rs2 =st.executeQuery(sql2);
					if(rs2.next())
					{
						flag++;
					}
					break;
				
				case 2:
					Scanner s_email = new Scanner(System.in);
					String teacher_email = s_email.nextLine();
					String sql3 = "select * from teacher where tea_username ='"+teacher_username+"',tea_passwd = '"+teacher_passwd+"',tea_email= '"+teacher_email+"'";
					ResultSet rs3 = st.executeQuery(sql3);
					if(rs3.next())
					{
						flag++;
					}
					break;
				
				case 3:
					Scanner s_code = new Scanner(System.in);
					String teacher_code = s_code.nextLine();
					String sql4 =  "select * from teacher where tea_username ='"+teacher_username+"',tea_passwd = '"+teacher_passwd+"',tea_code= '"+teacher_code+"'";
					ResultSet rs4 = st.executeQuery(sql4);
					if(rs4.next())
					{
						flag++;
					}
					break;
				default:
					break;
				}
				System.out.println("请输入验证码");
				String s = getStringRandom(6);
				Scanner s_random = new Scanner(System.in);
				String random = s_random.nextLine();
				if(s.equals(random))
				{
					flag++;
				}
				if(flag == 4)
				{
					System.out.println("恭喜您，登录成功");
					break;
				}
				else {
					System.out.println("请重新输入");
				}
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//验证邮箱
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
	
	//生成随机验证码
	public static String getStringRandom(int length) {
		String val = "";
		Random random = new Random();
		//参数length，表示生成几位随机数
		for(int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			//输出字母还是数字
			if( "char".equalsIgnoreCase(charOrNum) ) {
				//输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char)(random.nextInt(26) + temp);
			} else if( "num".equalsIgnoreCase(charOrNum) ) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	public void test() {
		
	}
}
