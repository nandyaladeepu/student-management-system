/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.dao;

import com.sms.dao.jdbc.StudentDAO;  
import com.sms.dao.jdbc.UserDAO;  
  
public class DAOFactory {  
  
    private static UserDAOI udao;  
    private static StudentDAOI sdao;  
    static {  
        udao=new UserDAO();  
        sdao=new StudentDAO();  
    }  
      
    public static UserDAOI getUserDAO(){  
        return udao;  
    }  
    public static StudentDAOI getStudentDAO(){  
        return sdao;  
    }  
}  