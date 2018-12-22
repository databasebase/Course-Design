package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.entity.ColTeacher;

public class ColTeacherDao extends C3p0Connection{
	//insert a new collection to the AppTeacher table
	public void Insert(ColTeacher ct)
	{
		try {
			Connection cn = null;
			Statement st = null;
			cn = getConnection();
			st = cn.createStatement();
			String sql = "insert into col_teacher (tea_id,book_id,col_date,col_instr)values('"+ct.getTea_id()+"','"+ct.getBook_id()+"','"+ct.getCol_date()+"','"+ct.getCol_instr()+"')";
			st.executeUpdate(sql);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//select all collection from collection_teacher table
	public void select()
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "select * from col_teacher";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getInt("col_teacher_id")+" "+rs.getInt("tea_id")+" "+rs.getInt("book_id")+" "+rs.getString("col_date")+rs.getString("col_instr"));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//delete the collection table according the id
	public void delete(ColTeacher ct)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "delete from col_teacher where col_teacher_id = '"+ct.getCol_teacher_id()+"'";
			st.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//change the collection table
	public void change(ColTeacher ct)
	{
		try {
			Connection cn = null;
			cn = getConnection();
			Statement st = null;
			st = cn.createStatement();
			String sql = "update col_teacher set tea_id = '"+ct.getTea_id()+"',book_id = '"+ct.getBook_id()+"',col_date = '"+ct.getCol_date()+"'"+",col_instr='"+ct.getCol_instr()+"'";
			st.executeUpdate(sql);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//test
	public void test() {
		ColTeacherDao ctd = new ColTeacherDao();
		ColTeacher ct = new ColTeacher();
		ct.setBook_id(1);
		ct.setTea_id(1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date =new Date();
		ct.setCol_date(df.format(date));
		ctd.Insert(ct);
		ctd.select();
		System.out.println();
		ColTeacher ct1 = new ColTeacher();
		ct1.setCol_teacher_id(1);
		ctd.delete(ct1);
		ctd.select();
	}
}
