package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Connection implements ConnectRelease {
	private static ComboPooledDataSource dSource = null;
	static {
		try {
			dSource = new ComboPooledDataSource();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			return dSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public void release(Connection connection, PreparedStatement statement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			resultSet = null;
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			statement = null;
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			connection = null;
		}
	}

}