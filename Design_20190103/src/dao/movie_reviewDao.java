package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.movie_review;

public class movie_reviewDao {
	public void view() {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from movies_review";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("mov_id") + " " + rs.getString("user_id")+ " " + rs.getString("mov_time")+ " " + rs.getString("mov_lik") + " " + rs.getString("mov_review"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(movie_review mr) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into movies_review values('" + mr.getMovie_id() + "','" + mr.getUser_id()+ "','" + mr.getMovie_time()+ "','" + mr.getMovie_lik() + "', '" + mr.getMovie_review() +"')";
			stmt.executeUpdate(sql);
			System.out.println("Insert successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int mid, int uid) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "delete from movies_review where mov_id='"+mid+"' and user_id='" + uid + "';";
			stmt.executeUpdate(sql);
			System.out.println("delete successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void change(movie_review mr) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			stmt = conn.createStatement();
			String sql = "update movies_review set mov_time = '" + mr.getMovie_time()+ "',mov_lik = '" + mr.getMovie_lik() + "',mov_review = '" + mr.getMovie_review() + "' where mov_id = '" + mr.getMovie_id() + "' and user_id = '" +mr.getUser_id() +"'";
			stmt.executeUpdate(sql);
			System.out.println("change successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
