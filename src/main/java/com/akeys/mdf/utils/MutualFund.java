package com.akeys.mdf.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MutualFund {

    public static void main(String[] args) {

	MutualFund mf = new MutualFund();
	Connection con = mf.createDbConnection();
	CreateUpadateDatabase.updateAMCData(con);
	try {
	    /*
	     * Statement stmt = con.createStatement(); ResultSet rs =
	     * stmt.executeQuery("SELECT * FROM SCHEMES;"); while(rs.next()){
	     * System.out.println(rs.getString(1)+"   "+rs.getString(2)); }
	     */
	} /*
	   * catch(SQLException e){ System.out.println("sss"+e);
	   * 
	   * }
	   */finally {
	    try {
		con.close();
	    } catch (SQLException e2) {
		System.out.println("Unable to close connection");
	    }
	}

    }

    private Connection createDbConnection() {
	Connection con = null;
	Properties info = new Properties();
	info.put("useSSL", false);
	info.put("user", "akhil");
	info.put("password", "root");

	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfirstapp?autoReconnect=true&useSSL=false",
		    "akhil", "root");
	} catch (ClassNotFoundException e) {
	    System.out.println("mysql driver Classs Not Found");
	} catch (SQLException e) {
	    System.out.println("Unable to connect to database");
	}
	return con;
    }

}
