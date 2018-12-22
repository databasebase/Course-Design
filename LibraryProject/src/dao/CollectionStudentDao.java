package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.AppTeacher;
import com.entity.ColStudent;

public class CollectionStudentDao extends C3p0Connection{
	//insert a new collection to the ColStudent table
	public void Insert(ColStudent cs)
	{
		try {
			Connection cn = null;
			Statement st = null;
			cn = getConnection();
			st = cn.createStatement();
			String sql = "insert into col_student (stu_id,book_id,col_date,col_instr) values('"+cs.getStu_id()+"','"+cs.getBook_id()+"','"+cs.getCol_date()+"','"+cs.getCol_instr()+"')";
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
				System.out.println(rs.getInt("col_student_id")+" "+rs.getInt("stu_id")+" "+rs.getInt("book_id")+" "+rs.getString("col_date")+" "+rs.getString("col_instr"));
				
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//delete the collection table according the id
	public void delete(ColStudent cs)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "delete from col_student where col_student_id = '"+cs.getCol_student_id()+"'";
			st.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//change the collection table
	public void change(ColStudent cs)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "update col_student set stu_id = '"+cs.getStu_id()+"',book_id = '"+cs.getBook_id()+"',col_date = '"+cs.getCol_date()+"',col_instr ='"+cs.getCol_instr()+"'";
			st.executeUpdate(sql);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
