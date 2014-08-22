/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.service;
import com.sms.dao.*;
import com.sms.*;
public class UserServices {  
      
    public User checkUserAuthentication(String uname, String pass){  
          
        UserDAOI udao=DAOFactory.getUserDAO();  
        if (udao.findUser(uname, pass)){  
            return udao.getUserDetails(uname);  
        }  
        return null;  
    }  
} 