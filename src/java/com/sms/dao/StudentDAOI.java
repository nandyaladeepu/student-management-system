/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.dao;

import java.util.Collection;  
  
import com.sms.Student;  
  
public interface StudentDAOI {  
      
    void save(Student s);  
    Student getStudent(int sid);  
    Collection<Student> getAllStudentsByName(String namePattern);  
    void update(Student s);  
} 
