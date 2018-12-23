package dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.book;

public class BookDao  extends C3p0Connection{
		//insert the new book to book table
	public void Insert(book b)
		{
			try {
				Connection cn = null;
				Statement st = null;
				cn = getConnection();
				st = cn.createStatement();
				String sql = "insert into book(book_name,book_aut,book_intro,book_addr,book_ok,book_health,book_record,book_borrow_times,book_price,book_sort,book_state) values('"+b.getBook_name()+"','"+b.getBook_aut()+"','"+b.getBook_intro()+"','"+b.getBook_addr()+"','"+b.getBook_ok()+"','"+b.getBook_health()+"','"+b.getBook_record()+"','"+b.getBook_borrow_times()+"','"+b.getBook_price()+"','"+b.getBook_sort()+"','"+b.getBook_state()+"')";
				st.executeUpdate(sql);
				//System.out.println("SUCCESS");
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		//select all book from book table 
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
		//delete the book according the id
		public void delete(book b)
		{
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "delete from book where book_id ='"+b.getBook_id()+"'";
				st.executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//change the book_name from book table
		public void changebook_name(String book_name,int book_id)
		{
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update book set book_name = '"+book_name+"' where book_id = '"+book_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		//change the book_intro from book table
		public void changebook_intro(String book_intro,int book_id)
		{
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update book set book_intro = '"+book_intro+"' where book_id = '"+book_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		//change the book_addr from book table
		public void changebook_addr(String book_addr,int book_id)
		{
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update book set book_addr = '"+book_addr+"' where book_id = '"+book_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		//change the book_ok from book table
		public void changebook_ok(String book_ok,int book_id)
		{
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update book set book_ok = '"+book_ok+"' where book_id = '"+book_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}	
		//change the book_health from book table
		public void changebook_health(int book_health,int book_id)
		{
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update book set book_health = '"+book_health+"' where book_id = '"+book_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		//change the book_borrow_times from book table
		public void changebook_borrow_times(int book_borrow_times,int book_id)
		{
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update book set book_borrow_times = '"+book_borrow_times+"' where book_id = '"+book_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		//change the book_record from book table
		public void changebook_record(String book_record,int book_id)
		{
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update book set book_record = '"+book_record+"' where book_id = '"+book_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		//change the book_price from book table
		public void changebook_price(double book_price,int book_id)
		{
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update book set book_price = '"+book_price+"' where book_id = '"+book_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		//change the book_sort from book table
		public void changebook_sort(String book_sort,int book_id)
		{
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update book set book_sort = '"+book_sort+"' where book_id = '"+book_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		//change the book_aut from book table
		public void changebook_aut(String book_aut,int book_id)
		{
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update book set book_aut = '"+book_aut+"' where book_id = '"+book_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		//change the book_state from book table
		public void changebook_state(int book_state,int book_id)
		{
			try {
				Connection cn = null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update book set book_state = '"+book_state+"' where book_id = '"+book_id+"'";
				st.executeUpdate(sql);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

}
