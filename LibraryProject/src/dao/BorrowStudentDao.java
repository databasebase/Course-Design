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
	
	//change the borrow table
	public void change(BorrowStudent bt)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "update borrow_student set borrow_student_id = '"+bt.getBorrow_student_id()+"',tea_id = '"+bt.getStu_id()+"',book_id = '"+bt.getBook_id()+"',borrow_date='"+bt.getBorrow_date()+"'";
			st.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//test
	public void test() {
		BorrowTeacherDao btd = new BorrowTeacherDao();
		BorrowTeacher bt = new BorrowTeacher();
		bt.setBook_id(1);
		bt.setTea_id(1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date =new Date();
		bt.setBorrow_date(df.format(date));
		btd.Insert(bt);
		btd.select();
		System.out.println("1");
		BorrowTeacher bt1 = new BorrowTeacher();
		bt1.setBorrow_teacher_id(1);
		bt1.setBook_id(1);
		bt1.setTea_id(2);
		bt1.setBorrow_date(df.format(date));
		btd.change(bt1);
		btd.select();
		System.out.println("2");
		btd.delete(bt1);
		btd.select();
	}
}