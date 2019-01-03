package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.movie_star;

public class movie_starDao {
	public void view() {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from movie_star";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("movie_id") + " " + rs.getString("user_id") + " "
						+ rs.getString("star") );

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(movie_star ms) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into movie_star values('" + ms.getMovie_id() + "','" + ms.getUser_id() + "','"
					+ ms.getStar() + "')";
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
			String sql = "delete from movie_star where movie_id='" + mid + "' and user_id='" + uid + "';";
			stmt.executeUpdate(sql);
			System.out.println("delete successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void change(movie_star ms) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			stmt = conn.createStatement();
			String sql = "update movie_star set star = '" + ms.getStar() + "'where user_id = '" + ms.getUser_id()+"' and movie_id = '" + ms.getMovie_id() + "';";
			stmt.executeUpdate(sql);
			System.out.println("change successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
