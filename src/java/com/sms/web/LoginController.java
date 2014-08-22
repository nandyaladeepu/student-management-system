/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.web;

import java.io.IOException;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
import com.sms.service.UserServices;  
import com.sms.User;  
  
/** 
 * Servlet implementation class LoginServlet 
 */  
@WebServlet("/login")  
public class LoginController extends HttpServlet {  
         
    private UserServices userServices;  
  
    @Override  
    public void init() throws ServletException {  
        userServices=new UserServices();  
    }  
      
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.sendRedirect("LoginForm.html");  
    }  
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        String uname=request.getParameter("uname");  
        String pass=request.getParameter("pass");  
          
        User user=userServices.checkUserAuthentication(uname, pass);  
          
        if (user!=null){  
              
            HttpSession session=request.getSession();  
            session.setAttribute("user", user);  
              
            response.sendRedirect(  
            response.encodeURL(user.getUsertype().trim()+"/UserHomeView.jsp"));  
            return;  
        }  
          
        response.setContentType("text/html");  
        response.getWriter().println("Invalid username / password");  
          
        request.getRequestDispatcher("LoginForm.html")  
        .include(request, response);  
    }  
}  