package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.AppStudent;
import com.entity.book;

public class BookDao  extends C3p0Connection{
		//向书表中插入新书
		public void Insert(int book_id,String book_name,String book_aut,String book_intro,String book_addr,String book_ok,int book_health,String book_record,int book_borrow_times,double book_price,String book_sort,int book_state)
		{
			try {
				Connection cn = null;
				Statement st = null;
				book b = new book();
				b.setBook_id(book_id);
				b.setBook_name(book_name);
				b.setBook_aut(book_aut);
				b.setBook_intro(book_intro);
				b.setBook_addr(book_addr);
				b.setBook_ok(book_ok);
				b.setBook_health(book_health);
				b.setBook_record(book_record);
				b.setBook_borrow_times(book_borrow_times);
				b.setBook_price(book_price);
				b.setBook_sort(book_sort);
				b.setBook_state(book_state);
				cn = getConnection();
				st = cn.createStatement();
				String sql = "insert into book (book_id,book_name,book_intro,book_addr,book_ok,book_health,book_record,book_borrow_times,book_price,book_sort,book_aut,book_state)values(book_id,book_name,book_intro,book_addr,book_ok,book_health,book_record,book_borrow_times,book_price,book_sort,book_aut,book_state)";
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
