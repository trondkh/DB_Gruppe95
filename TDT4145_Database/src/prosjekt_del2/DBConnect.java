package prosjekt_del2;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Svein Erik
 */

import java.sql.*;
import java.util.Properties;

public class DBConnect {
	
    Connection conn;

    public DBConnect () {
    }
    public void connect() {
    	try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
		
            // Properties for user and password. Here the user and password are both 'paulr'
            Properties p = new Properties();
            p.put("user", "trondkh");
            p.put("password", "");           
            conn = DriverManager.getConnection("jdbc:mysql://mysql.stud.ntnu.no/trondkh_db95?autoReconnect=true&useSSL=false","trondkh","");
        } catch (Exception e)
    	{
        	System.out.println(e);
    	}
    }
    
    public static void main(String[] args) {
		DBConnect test = new DBConnect();
		test.connect();
		System.out.println("Success??");
	}
	
}
