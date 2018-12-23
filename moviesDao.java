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
				System.out.println(rs.getString("mov_id") + " " + rs.getString("mov_name") + " "
						+ rs.getString("mov_intro")+ " "+ rs.getString("mov_time")+ " "
						+ rs.getString("mov_cou")+ " "+ rs.getString("mov_la")+ " "+ rs.getString("mov_rel"));
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
			String sql = "delete from movies where mov_id='" + id + "';";
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
			String sql = "update movies set mov_id = '" + m.getMov_id() + "',mov_name = '" + m.getMov_name()
					+ "',mov_intro = '" + m.getMov_intro() + "',mov_time = '" + m.getMov_time()
					+ "',mov_cou = '" + m.getMov_cou()+ "',mov_la = '" + m.getMov_la()+ "',mov_rel = '" + m.getMov_rel()+ "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
