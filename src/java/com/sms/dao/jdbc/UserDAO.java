/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.dao.jdbc;
import com.sms.*;
import com.sms.dao.*;
import java.sql.*;  
  
public class UserDAO implements UserDAOI {  
      
    public boolean findUser(String un, String pwd) {  
        
  
        Connection con = null;  
        try {  
            con = DBConnectionFactory.getConnection();  
           String sql = "select count(uname) from user_details"
                   + " where uname='"+un+"' and pass='"+pwd+"'";  
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();  
            rs.next();
            int count = rs.getInt(1);  
            return (count == 1);  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                con.close();  
            } catch (SQLException e) { 
                e.printStackTrace();
            }  
        }// finally  
        return false;  
    }  
  
    @Override  
    public User getUserDetails(String uname) {  
        Connection con=null;  
        try{  
            con=DBConnectionFactory.getConnection();  
            Statement st=con.createStatement();  
            String sql="select fname, lname, email, mobile, usertype " +  
                    "from user_details " +  
                    "where uname='"+uname+"'";  
            ResultSet rs=st.executeQuery(sql);  
            if(rs.next()){  
                User u=new User();  
                u.setUname(uname);  
                u.setFname(rs.getString(1));  
                u.setLname(rs.getString(2));  
                u.setEmail(rs.getString(3));  
                u.setMobile(rs.getString(4));  
                u.setUsertype(rs.getString(5));  
                  
                return u;  
            }  
        }catch (SQLException e) {  
            e.printStackTrace();  
        }finally{  
            try{con.close();}  
            catch (SQLException e) {e.printStackTrace();}  
        }  
        return null;  
    }  
}  