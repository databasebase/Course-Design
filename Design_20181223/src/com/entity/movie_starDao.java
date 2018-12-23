package com.entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.C3p0Connection;

public class movie_starDao {
	public static void view() {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from movies_star";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("movie_id") + " " + rs.getString("user_id") + " "
						+ rs.getString("star") );

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert(movies_star ms) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into movies_star values('" + ms.getMovie_id() + "','" + ms.getUser_id() + "','"
					+ ms.getStar() + "'";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(int mid, int uid) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "delete from movies_star where movie_id='" + mid + "' and user_id='" + uid + "';";
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void change(movies_star ms) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			stmt = conn.createStatement();
			String sql = "update movies_star set movie_id = '" + ms.getMovie_id() + "',user_id = '" + ms.getUser_id()
					+ "',star = '" + ms.getStar() + "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
