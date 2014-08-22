/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.dao;

import java.sql.*;  
import java.util.*;  
import java.io.*;  
  
public class DBConnectionFactory {  
  
    private static String url;  
    private static Driver d;  
    private static Properties p;  
      
    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            Connection c = DriverManager.
                    getConnection("jdbc:oracle:thin:@localhost:1521:xe ",
                                  "krishna",
                                  "krishna");
            return c;
        }
        catch(Exception e){  
            e.printStackTrace();  
            throw new RuntimeException( "Failed to load DBConnectionFactory");
        }
    }  
}  