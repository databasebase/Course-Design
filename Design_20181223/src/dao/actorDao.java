package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.actor;

public class actorDao {
	public static void view() {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from actor";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("actor_id") + " " + rs.getString("actor_name") + " "
						+ rs.getString("actor_intro"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert(actor a) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into actor values('" + a.getActor_id() + "','" + a.getActor_name() + "','"
					+ a.getActor_intro() + "'";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(int id) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "delete from actor where actor_id='" + id + "';";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void change(actor a) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			stmt = conn.createStatement();
			String sql = "update actor set actor_id = '" + a.getActor_id() + "',actor_name = '" + a.getActor_name()
					+ "',actor_intro = '" + a.getActor_intro() + "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
