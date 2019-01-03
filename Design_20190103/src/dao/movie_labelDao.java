package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.movie_label;

public class movie_labelDao {
	public  void view() {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from movie_label";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("mov_id") + " " + rs.getString("label_id"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public  void insert(movie_label ml) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into movie_label(mov_id, label_id) values('" + ml.getMovie_id() + "','" + ml.getLabel_id() + "')";
			stmt.executeUpdate(sql);
			System.out.println("Insert successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public  void delete(int mid, int lid) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "delete from movie_label where mov_id='"+mid+"' and label_id='" + lid + "';";
			stmt.executeUpdate(sql);
			System.out.println("delete successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void change(movie_label ml) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			stmt = conn.createStatement();
			String sql = "update movie_label set movie_id = '" + ml.getMovie_id() + "',actor_name = '" + ml.getLabel_id() + "'";
			stmt.executeUpdate(sql);
			System.out.println("change successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
