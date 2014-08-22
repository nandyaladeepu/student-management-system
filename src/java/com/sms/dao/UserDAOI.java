/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.dao;
import com.sms.User;
public interface UserDAOI {  
      
    boolean findUser(String un,String pwd);  
      
    User getUserDetails(String uname);  
}  