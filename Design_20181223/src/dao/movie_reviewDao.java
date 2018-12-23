package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.movies_review;

public class movie_reviewDao {
	public static void view() {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from movies_review";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("movie_id") + " " + rs.getString("user_id")+ " " + rs.getString("movie_time")+ " " + rs.getString("movie_lik"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert(movies_review mr) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into movies_review values('" + mr.getMovie_id() + "','" + mr.getUser_id()+ "','" + mr.getMovie_time()+ "','" + mr.getMovie_lik() + "'";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(int mid, int uid) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "delete from movies_review where movie_id='"+mid+"' and user_id='" + uid + "';";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void change(movies_review mr) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			stmt = conn.createStatement();
			String sql = "update movies_review set movie_id = '" + mr.getMovie_id() + "',user_id = '" + mr.getUser_id()+ "',movie_time = '" + mr.getMovie_time()+ "',movie_lik = '" + mr.getMovie_lik() + "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
