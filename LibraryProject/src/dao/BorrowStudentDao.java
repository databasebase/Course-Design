package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.entity.BorrowStudent;
import com.entity.BorrowTeacher;

public class BorrowStudentDao extends C3p0Connection{
	//insert a new borrow to the BorrowTeacher table
	public void Insert(BorrowStudent bt)
	{
		try {
			Connection cn = null;
			Statement st = null;
			cn = getConnection();
			st = cn.createStatement();
			String sql = "insert into borrow_student(stu_id,book_id,borrow_date)values('"+bt.getStu_id()+"','"+bt.getBook_id()+"','"+bt.getBorrow_date()+"')";
			st.executeUpdate(sql);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//select all borrow record from borrow table
	public void select()
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "select * from borrow_student";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getInt("borrow_student_id")+" "+rs.getInt("stu_id")+" "+rs.getInt("book_id")+" "+rs.getString("borrow_date"));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//delete the borrow record according the id
	public void delete (BorrowStudent bt)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "delete from borrow_student where borrow_student_id = '"+bt.getBorrow_student_id()+"'";
			st.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//change the student_id from borrow table
			public void changestu_id(int student_id,int borrow_student_id)
			{
				try {
					Connection cn = null;
					cn = getConnection();
					Statement st = null;
					st = cn.createStatement();
					String sql = "update borrow_student set stu_id = '"+student_id+"' where borrow_student_id = '"+borrow_student_id+"'";
					st.executeUpdate(sql);
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			//change the book_id from borrow table
				public void changebook_id(int book_id,int borrow_student_id)
				{
					try {
						Connection cn = null;
						cn = getConnection();
						Statement st = null;
						st = cn.createStatement();
						String sql = "update borrow_student set book_id = '"+book_id+"' where borrow_student_id = '"+borrow_student_id+"'";
						st.executeUpdate(sql);
					}catch(SQLException e)
					{
						e.printStackTrace();
					}
				}
				
				//change the borrow_date from borrow table
				public void changeborrow_date(String borrow_date,int borrow_student_id)
				{
					try {
						Connection cn = null;
						cn = getConnection();
						Statement st = null;
						st = cn.createStatement();
						String sql = "update borrow_student set borrow_date = '"+borrow_date+"' where borrow_student_id = '"+borrow_student_id+"'";
						st.executeUpdate(sql);
					}catch(SQLException e)
					{
						e.printStackTrace();
					}
				}

}
