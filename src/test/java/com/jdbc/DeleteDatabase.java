package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DeleteDatabase {

	public static void main(String[] args) throws SQLException {
		  Connection con=null;
		     
		  
		     
		     
		    	 Driver driver=new Driver();
		    	 //STEP 1 REGISTER THE DATABASE
		    	 DriverManager.registerDriver(driver);
		    	 
		    	 //step2 get the connection for the database
		    	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");
		    	 
		    	 //step3 create statement
		    	 Statement state = con.createStatement();
		    	 String query = "delete from StudentInfo where sname='Akilesh';";
		    	 
		    	 //step 4 update query
		    	 state.executeUpdate(query);
		    	 System.out.println("Data is deleted");

	}

}
