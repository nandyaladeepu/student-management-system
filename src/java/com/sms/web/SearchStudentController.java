/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.web;

  
import java.io.IOException;  
import java.util.Collection;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import com.sms.service.StudentServices;  
import com.sms.Student;  
  
@WebServlet(urlPatterns = "/DEO/searchStudent")  
public class SearchStudentController extends HttpServlet {  
      
    private StudentServices studentServices;  
  
    public void init() {  
        studentServices=new StudentServices();  
    }  
  
    @Override  
    public void service(HttpServletRequest req, HttpServletResponse res)  
            throws ServletException, IOException {  
  
            String criteria=req.getParameter("criteria");  
            String path="";  
              
            if (criteria.equals("SID")){  
                int sid = Integer.parseInt(req.getParameter("key"));  
  
                Student s=studentServices.findStudent(sid);  
                req.setAttribute("student", s);  
                path="StudentDetailsView.jsp";  
            }else{  
                String namePattern = req.getParameter("key");  
  
                Collection<Student> students=  
                        studentServices.findAllStudentsByName(namePattern);  
                  
                  
                req.getSession().setAttribute("students", students);  
                path="MultipleStudentDetailsView.jsp";  
            }  
            RequestDispatcher rd = req  
                    .getRequestDispatcher(path);  
  
            rd.forward(req, res);  
    }// service  
};// class  