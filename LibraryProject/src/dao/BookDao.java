package dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.book;

public class BookDao  extends C3p0Connection{
		//向书表中插入新书
	public void Insert(book b)
		{
			try {
				Connection cn = null;
				Statement st = null;
				cn = getConnection();
				st = cn.createStatement();
				String sql = "insert into book(book_id,book_name,book_aut,book_intro,book_addr,book_ok,book_health,book_record,book_borrow_times,book_price,book_sort,book_state) values('"+b.getBook_id()+"','"+b.getBook_name()+"','"+b.getBook_aut()+"','"+b.getBook_intro()+"','"+b.getBook_addr()+"','"+b.getBook_ok()+"','"+b.getBook_health()+"','"+b.getBook_record()+"','"+b.getBook_borrow_times()+"','"+b.getBook_price()+"','"+b.getBook_sort()+"','"+b.getBook_state()+"')";
				boolean rs = st.execute(sql);
				System.out.println("SUCCESS");
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		//查询书表中的书
		public void select()
		{
			
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "select * from book";
				ResultSet rs = st.executeQuery(sql);
				while(rs.next())
				{
					System.out.println(rs.getInt("book_id")+" "+rs.getString("book_name")+" "+rs.getString("book_aut")+" "+rs.getString("book_intro")+" "+rs.getString("book_addr")+" "+rs.getString("book_ok")+" "+rs.getInt("book_health")+" "+rs.getString("book_record")+" "+rs.getInt("book_borrow_times")+" "+rs.getDouble("book_price")+" "+rs.getString("book_sort")+" "+rs.getInt("book_state"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
