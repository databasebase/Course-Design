package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.entity.ColStudent;

public class ColStudentDao extends C3p0Connection{
	//insert a new collection to the ColStudenttable
	public void Insert(ColStudent ct)
	{
		try {
			Connection cn = null;
			Statement st = null;
			cn = getConnection();
			st = cn.createStatement();
			String sql = "insert into col_student (stu_id,book_id,col_date,col_instr)values('"+ct.getStu_id()+"','"+ct.getBook_id()+"','"+ct.getCol_date()+"','"+ct.getCol_instr()+"')";
			st.executeUpdate(sql);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//select all collection from collection_student table
	public void select()
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "select * from col_student";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getInt("col_student_id")+" "+rs.getInt("stu_id")+" "+rs.getInt("book_id")+" "+rs.getString("col_date")+rs.getString("col_instr"));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//delete the collection table according the id
	public void delete(ColStudent ct)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "delete from col_student where col_student_id = '"+ct.getCol_student_id()+"'";
			st.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//change the student_id from collection table
	public void changestu_id(int student_id,int col_student_id)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "update col_student set stu_id = '"+student_id+"' where col_student_id = '"+col_student_id+"'";
			st.executeUpdate(sql);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//change the book_id from collection table
		public void changebook_id(int book_id,int col_student_id)
		{
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update col_student set book_id = '"+book_id+"' where col_student_id = '"+col_student_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		//change the col_date from collection table
		public void changecol_date(String col_date,int col_student_id)
		{
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update col_student set col_date = '"+col_date+"' where col_student_id = '"+col_student_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		//change the col_instr from collection table
				public void changecol_instr(String col_instr,int col_student_id)
				{
					try {
						Connection cn = null;
						cn = getConnection();
						Statement st = null;
						st = cn.createStatement();
						String sql = "update col_student set col_instr= '"+col_instr+"' where col_student_id = '"+col_student_id+"'";
						st.executeUpdate(sql);
					}catch(SQLException e)
					{
						e.printStackTrace();
					}
				}
				


	//test
	public void test() {
		ColStudentDao ctd = new ColStudentDao();
		ColStudent ct = new ColStudent();
		ct.setBook_id(1);
		ct.setStu_id(1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date =new Date();
		ct.setCol_date(df.format(date));
		ctd.Insert(ct);
		ctd.select();
		System.out.println();
		ColStudent ct1 = new ColStudent();
		ct1.setCol_student_id(1);
		ctd.delete(ct1);
		ctd.select();
	}
}
