package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class DBConnection {
	private Connection conn = null;
	private Statement stmt = null;

	private Connection GetConnection() {
		try {
			//Sql Server
			//String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			//String dbURL = "jdbc:sqlserver://nltc189;instanceName=tog; DatabaseName=autotest";
			
			String driverName = "com.mysql.cj.jdbc.Driver";
			String dbURL = "jdbc:mysql://localhost:3306/xietong";
			
			String userName = "root";
			String userPwd = "";

			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("Connection Successful!");
		} catch (Exception e) {
			System.out.println("Connection error!");
		}
		return conn;
	}

	public void executeUpdate(String sql) {
		try {
			conn = GetConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("modify database error!");
		} finally {
			closeConn(stmt, conn);
		}
	}
	
	public void executeSql(String sql) {
		try {
			conn = GetConnection();
			stmt = conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println("modify database error!");
		} finally {
			closeConn(stmt, conn);
		}
	}

	public void closeConn(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("close database error");
		}
	}

	public void closeConn(Statement stmt, Connection conn) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("close database error");
		}
	}

	public void closeConn(ResultSet rs) {
		try {

			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("close database error");
		}
	}
}
