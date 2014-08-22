/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.service;

import java.util.Collection;  
  
import com.sms.dao.DAOFactory;  
import com.sms.Student;  
  
public class StudentServices {  
      
    public void create(Student s){  
        DAOFactory.getStudentDAO().save(s);  
    }  
    public Student findStudent(int sid){  
        return DAOFactory.getStudentDAO().getStudent(sid);  
    }  
    public Collection<Student> findAllStudentsByName(String namePattern){  
        return DAOFactory.getStudentDAO().getAllStudentsByName(namePattern);  
    }  
    public void update(Student s){  
        DAOFactory.getStudentDAO().update(s);  
    }  
}