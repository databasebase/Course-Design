package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.label;

public class labelDao {
	public void view() {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from label";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("label_id") + " " + rs.getString("label_name") + " "
						+ rs.getString("label_num"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(label l) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into label(label_name, label_num) values('" + l.getLabel_name() + "','"
					+ l.getLabel_num() + "')";
			stmt.executeUpdate(sql);
			System.out.println("Insert successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "delete from label where label_id='" + id + "';";
			stmt.executeUpdate(sql);
			System.out.println("Delete successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void change(label l) {
		try {
			Connection conn = C3p0Connection.getConnection();
			Statement stmt = conn.createStatement();
			stmt = conn.createStatement();
			String sql = "update label set label_name = '" + l.getLabel_name()
					+ "',label_num = '" + l.getLabel_num() + "' where label_id = '"+l.getLabel_id()+"';";
			stmt.executeUpdate(sql);
			System.out.println("Change successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
