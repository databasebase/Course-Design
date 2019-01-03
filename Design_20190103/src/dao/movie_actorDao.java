package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.movie_actor;

public class movie_actorDao {
	public void view() {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from movie_actor";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("movie_id") + " " + rs.getString("actor_id") + " "
						+ rs.getString("actor_pro"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(movie_actor ma) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into movie_actor(movie_id, actor_id, actor_pro) values('" + ma.getMovie_id() + "','" + ma.getActor_id() + "','"
					+ ma.getActor_pro() + "')";
			stmt.executeUpdate(sql);
			System.out.println("Insert successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int mid, int aid) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "delete from movie_actor where movie_id='"+mid+"' and actor_id='" + aid + "';";
			stmt.executeUpdate(sql);
			System.out.println("delete successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void change(movie_actor ma) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			stmt = conn.createStatement();
			String sql = "update movie_actor set actor_pro = '" + ma.getActor_pro() + "' where movie_id = '" +ma.getMovie_id() +"'and actor_id = '" +ma.getActor_id() +"'";
			stmt.executeUpdate(sql);
			System.out.println("change successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
