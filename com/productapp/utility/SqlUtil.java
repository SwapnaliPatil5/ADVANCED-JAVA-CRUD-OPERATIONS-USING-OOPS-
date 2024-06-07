package com.productapp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtil {

	final static String DB_NAME = "cdac_java";
    final static String DB_USER = "root";
     final static String DB_PASSWORD = "cdac";
     final static String DB_URL = "jdbc:mysql://localhost:3306/"+DB_NAME;
     final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
       static Statement stmt;
       static Connection conn;
       
      public static void connectDb() throws ClassNotFoundException, SQLException {
    	   Class.forName(JDBC_DRIVER);  //register driver
          conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);  //conncetion
            stmt = conn.createStatement();     //statement is ready            
       }
       
      public  static int insert(String qry) throws SQLException {
    	   int result = -1;
    	   if(qry!="") {
    		 result = stmt.executeUpdate(qry);
    	   }
    	   return result;
       }
      public  static int update(String qry) throws SQLException {
    	   int result = -1;
    	   if(qry!="") {
    		 result = stmt.executeUpdate(qry);
    	   }
    	   return result;
       }
      public  static int delete(String qry) throws SQLException {
    	   int result = -1;
    	   if(qry!="") {
    		 result = stmt.executeUpdate(qry);
    	   }
    	   return result;
       }
       public static ResultSet fetch(String qry) throws SQLException {
    	   ResultSet rs = null;
    	   if(qry!="") {
    		 rs = stmt.executeQuery(qry);
    	   }
    	   return rs;
       }
       
       public static void close() throws SQLException {
    	   if(stmt!=null && conn!=null) {
    		   stmt.close();
    		   conn.close();
    	   }
       }
       
     
}
