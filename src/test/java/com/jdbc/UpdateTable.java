package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateTable {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
     Connection con=null;
     int result=0;
     
     try{
    	 Driver driver=new Driver();
    	 //STEP 1 REGISTER THE DATABASE
    	 DriverManager.registerDriver(driver);
    	 
    	 //step2 get the connection for the database
    	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");
    	 
    	 //step3 create statement
    	 Statement state = con.createStatement();
    	 String query = "insert into StudentInfo values('Omkar','online','java',5);";
    	 
    	 //update query
    	 result =state.executeUpdate(query);
     }
     catch(Exception e){
    	 
     }
     finally{
    	 if(result==1){
    		 System.out.println("Data inserted successfully");
    	 }
    	 else{
    		 System.out.println("data not inserted");
    		 
    		 //step 5 close the connection
    		 con.close();
    	 }
     }
	}

}
