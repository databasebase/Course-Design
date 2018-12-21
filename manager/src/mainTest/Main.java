package mainTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.C3p0Connection;
import dao.manager;

public class Main {
	public static void main(String[] args)
	{
		manager a=new manager();
		a.view_man();
	}
}
