package dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.book;

public class BookDao  extends C3p0Connection{
		//������в�������
	public void Insert(book b)
		{
			try {
				Connection cn = null;
				Statement st = null;
				cn = getConnection();
				st = cn.createStatement();
				String sql = "insert into book(book_id,book_name,book_aut,book_intro,book_addr,book_ok,book_health,book_record,book_borrow_times,book_price,book_sort,book_state) values('"+b.getBook_id()+"','"+b.getBook_name()+"','"+b.getBook_aut()+"','"+b.getBook_intro()+"','"+b.getBook_addr()+"','"+b.getBook_ok()+"','"+b.getBook_health()+"','"+b.getBook_record()+"','"+b.getBook_borrow_times()+"','"+b.getBook_price()+"','"+b.getBook_sort()+"','"+b.getBook_state()+"')";
				st.executeUpdate(sql);
				System.out.println("SUCCESS");
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		//��ѯ����е���
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
		//ɾ��ָ��id����
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
		//�޸�ָ��id����
		public void change(book b)
		{
			
			try {
				Connection cn =null;
				cn = getConnection();
				Statement st = null;
				st = cn.createStatement();
				String sql = "update book set book_name = '"+b.getBook_name()+"',book_aut = '"+b.getBook_aut()+"',book_intro = '"+b.getBook_intro()+"',book_addr = '"+b.getBook_addr()+"',book_ok = '"+b.getBook_ok()+"',book_health = '"+b.getBook_health()+"',book_record = '"+b.getBook_record()+"',book_borrow_times = '"+b.getBook_borrow_times()+"',book_price ='"+b.getBook_price()+"',book_sort = '"+b.getBook_sort()+"',book_state = '"+b.getBook_state()+"' where book_id = '"+b.getBook_id()+"'";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void test()
		{
			BookDao bd = new BookDao();
			book b = new book();
			b.setBook_id(1);
			b.setBook_name("ʱ���ʷ");
			b.setBook_aut("ʷ�ٷһ���");
			b.setBook_intro("ΰ����鼮");
			b.setBook_addr("101��");
			b.setBook_ok("������ҵ��ѧ������");
			b.setBook_health(2);
			b.setBook_record("2018/12/21");
			b.setBook_borrow_times(3);
			b.setBook_price(23.5);
			b.setBook_sort("��ѧ");
			b.setBook_state(2 );
			//bd.Insert(b);
			bd.select();
			book b1 = new book();
			b1.setBook_id(8);
			System.out.println(b1.getBook_id());
			bd.delete(b1);
			bd.select();
			bd.change(b);
			bd.select();
		}
}
