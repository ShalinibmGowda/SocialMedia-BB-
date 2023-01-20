package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class BioBook {

	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		
		Driver driver= new Driver();
		
		//step1 register the database
		DriverManager.registerDriver(driver);
		
		//step2 get connection for the database
		con= DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		
		//step3 issue create statement
		 Statement state = con.createStatement();
		 String query= "insert into project values('TY_BioBook_03','Shalini','21/12/2022','BioBook','created',4);";
		 
		 //step4 execute query
		   state.executeUpdate(query);
		 System.out.println("Data is updated");

	}

}
