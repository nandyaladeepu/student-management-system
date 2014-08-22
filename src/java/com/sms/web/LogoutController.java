/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.web;
import java.io.IOException;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
@WebServlet("/DEO/logout")  
public class LogoutController extends HttpServlet {  
      
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        HttpSession session=request.getSession(false);  
  
        session.invalidate();  
        Cookie cs[]=request.getCookies();  
        if (cs!=null){  
            for (Cookie c: cs){  
                c.setMaxAge(0);  
                response.addCookie(c);  
            }  
        }  
          
        response.sendRedirect(  
                request.getContextPath()+"/LoginForm.html");  
    }  
}  