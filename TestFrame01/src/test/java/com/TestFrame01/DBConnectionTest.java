package com.TestFrame01;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import com.util.DBConnection;

public class DBConnectionTest {

	public static void main(String[] args) throws SQLException {
		DBConnection dbConnection=new DBConnection();
		//Connection mConnect=dbConnection.GetConnection();
		
		//Search
		//Statement statement =mConnect.createStatement();
        
        //Create table
        String sql="create table mark_users(id int primary key,name varchar(20));";
        //statement.execute(sql);
        dbConnection.executeSql(sql);
        
        //Add
        sql="insert into mark_users values(1,'bill');";
        //statement.executeUpdate(sql);
        dbConnection.executeUpdate(sql);
        
        //Update
        sql="update mark_users set name='mark';";
        //statement.executeUpdate(sql);
        dbConnection.executeUpdate(sql);
        
        //Search
        sql ="SELECT * FROM mark_users;";
        //ResultSet result = statement.executeQuery(sql);
        //if(result.first()) {
        //	String name=result.getString("name");
        //	System.out.println(name);
        //}
        
        //Delete
        sql="drop table mark_users;";
        //statement.executeUpdate(sql);
        dbConnection.executeUpdate(sql);
        
        //statement.close();

	}

}
