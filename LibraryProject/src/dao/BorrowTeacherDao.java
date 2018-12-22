package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.BorrowTeacher;

public class BorrowTeacherDao extends C3p0Connection{
	//insert a new borrow to the BorrowTeacher table
	public void Insert(BorrowTeacher bt)
	{
		try {
			Connection cn = null;
			Statement st = null;
			cn = getConnection();
			st = cn.createStatement();
			String sql = "insert into borrow_teacher()";
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
