package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.movies;

public class moviesDao {
	public static void view() {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from movies";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("movie_id") + " " + rs.getString("movie_name") + " "
						+ rs.getString("movie_intro")+ " "+ rs.getString("movie_time")+ " "
						+ rs.getString("movie_cou")+ " "+ rs.getString("movie_la")+ " "+ rs.getString("movie_rel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert(movies m) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into movies values('" + m.getMov_id() + "','" + m.getMov_name() + "','"
					+ m.getMov_intro() + "','" + m.getMov_time()+ "','" + m.getMov_cou()+ "','" 
					+ m.getMov_la()+ "','" + m.getMov_rel()+ "'";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(int id) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "delete from movies where movie_id='" + id + "';";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void change(movies m) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			stmt = conn.createStatement();
			String sql = "update movies set movie_id = '" + m.getMov_id() + "',movie_name = '" + m.getMov_name()
					+ "',movie_intro = '" + m.getMov_intro() + "',movie_time = '" + m.getMov_time()
					+ "',movie_cou = '" + m.getMov_cou()+ "',movie_la = '" + m.getMov_la()+ "',movie_rel = '" + m.getMov_rel()+ "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
