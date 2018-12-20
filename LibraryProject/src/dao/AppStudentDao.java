package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.AppStudent;

public class AppStudentDao extends C3p0Connection{
	//学生提交申请
	public void Insert(int app_student_id,int stu_id,int book_id,String app_date)
	{
		try {
			Connection cn = null;
			Statement st = null;
			AppStudent as = new AppStudent();
			as.setApp_student_id(app_student_id);
			as.setStu_id(stu_id);
			as.setBook_id(book_id);
			as.setApp_date(app_date);
			cn = getConnection();
			st = cn.createStatement();
			String sql = "insert into app_student (app_student_id,stu_id,book_id,app_date)values(app_student_id,stu_id,book_id,app_date)";
			boolean rs = st.execute(sql);
			System.out.println("SUCCESS");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
