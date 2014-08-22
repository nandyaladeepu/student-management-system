/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.dao.jdbc;

import java.sql.Connection;  
import java.sql.Date;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.util.ArrayList;  
import java.util.Collection;  
  
import com.sms.*;
import com.sms.dao.*;
  
public class StudentDAO implements StudentDAOI {  
  
    @Override  
    public void save(Student s) {  
        String sql = "insert into student_details"  
                + "(fname, lname, dob, email, mobile, inserted_by, inserted_on) "  
                + "values(?,?,?,?,?,?,?)";  
  
        Connection con = null;  
        try {  
            con = DBConnectionFactory.getConnection();  
            PreparedStatement ps = con.prepareStatement(sql,  
                    Statement.RETURN_GENERATED_KEYS);  
  
            ps.setString(1, s.getFname());  
            ps.setString(2, s.getLname());  
            ps.setDate(3, new Date(s.getDob().getTime()));  
            ps.setString(4, s.getEmail());  
            ps.setString(5, s.getMobile());  
            ps.setString(6, s.getInsertedBy());  
            ps.setDate(7, new Date(s.getInsertedOn().getTime()));  
            ps.executeUpdate();  
  
            ResultSet rs = ps.getGeneratedKeys();  
            rs.next();  
            s.setSid(rs.getInt(1));  
  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                con.close();  
            } catch (SQLException e) {  
            }  
        }// finally  
    }  
  
    @Override  
    public Student getStudent(int sid) {  
        String sql = "select fname, lname, dob, email, mobile, inserted_by, inserted_on, updated_by, updated_on " +  
                "from student_details where sid="+ sid;  
        Connection con = null;  
        try {  
            con = DBConnectionFactory.getConnection();  
  
            Statement st = con.createStatement();  
            ResultSet rs = st.executeQuery(sql);  
            if (rs.next()) {  
                Student s = new Student();  
                s.setSid(sid);  
                s.setFname(rs.getString(1));  
                s.setLname(rs.getString(2));  
                s.setDob(rs.getDate(3));  
                s.setEmail(rs.getString(4));  
                s.setMobile(rs.getString(5));  
                s.setInsertedBy(rs.getString(6));  
                s.setInsertedOn(rs.getDate(7));  
                s.setUpdatedBy(rs.getString(8));  
                s.setUpdatedOn(rs.getDate(9));  
                return s;  
            }// if  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                con.close();  
            } catch (SQLException e) {  
            }  
        }// finally  
        return null;  
    }  
  
    @Override  
    public Collection<Student> getAllStudentsByName(String namePattern) {  
        namePattern="%"+namePattern+"%";  
        String sql = "select fname, lname, dob, email, mobile, inserted_by, inserted_on, updated_by, updated_on, sid " +  
                "from student_details " +  
                "where fname like '"+namePattern+"' or lname like '"+namePattern+"'" ;  
        Connection con = null;  
        try {  
            con = DBConnectionFactory.getConnection();  
  
            Statement st = con.createStatement();  
            ResultSet rs = st.executeQuery(sql);  
            Collection<Student> students=new ArrayList<Student>();  
            while (rs.next()) {  
                Student s = new Student();  
                s.setFname(rs.getString(1));  
                s.setLname(rs.getString(2));  
                s.setDob(rs.getDate(3));  
                s.setEmail(rs.getString(4));  
                s.setMobile(rs.getString(5));  
                s.setInsertedBy(rs.getString(6));  
                s.setInsertedOn(rs.getDate(7));  
                s.setUpdatedBy(rs.getString(8));  
                s.setUpdatedOn(rs.getDate(9));  
                s.setSid(rs.getInt(10));  
                students.add(s);  
            }// while  
            return students;  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                con.close();  
            } catch (SQLException e) {  
            }  
        }// finally  
        return null;  
    }  
  
    @Override  
    public void update(Student s) {  
        String sql = "update student_details set "  
                + "fname=?, lname=?, dob=?, email=?, mobile=?, updated_by=?, update_on=? "  
                + "where sid=?";  
  
        Connection con = null;  
        try {  
            con = DBConnectionFactory.getConnection();  
            PreparedStatement ps = con.prepareStatement(sql,  
                    Statement.RETURN_GENERATED_KEYS);  
  
            ps.setString(1, s.getFname());  
            ps.setString(2, s.getLname());  
            ps.setDate(3, new Date(s.getDob().getTime()));  
            ps.setString(4, s.getEmail());  
            ps.setString(5, s.getMobile());  
            ps.setString(6, s.getUpdatedBy());  
            ps.setDate(7, new Date(s.getUpdatedOn().getTime()));  
            ps.setInt(8, s.getSid());  
            ps.executeUpdate();  
              
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                con.close();  
            } catch (SQLException e) {  
            }  
        }// finally  
    }  
}  