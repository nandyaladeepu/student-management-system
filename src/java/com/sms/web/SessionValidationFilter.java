/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.web;
import java.io.IOException;  
  
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.annotation.WebFilter;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
import com.sms.User;  
  
@WebFilter(urlPatterns="/DEO/*")  
public class SessionValidationFilter implements Filter {  
  
    @Override  
    public void destroy() {}  
  
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException {  
          
        HttpServletRequest hreq=(HttpServletRequest)request;  
        HttpServletResponse hres=(HttpServletResponse)response;  
          
        HttpSession session=hreq.getSession(false);  
          
        if (session==null){  
            response.setContentType("text/html");  
            response.getWriter()  
            .println("Plz login before accessing the services");  
              
            hres.setHeader("refresh",   
                    "5;URL="+hreq.getContextPath()+"/LoginForm.html");  
              
            return;  
        }  
        User user=(User)session.getAttribute("user");  
        if (user==null){  
            response.setContentType("text/html");  
            response.getWriter().println("Plz login before accessing the services");  
            hres.setHeader("refresh",   
                    "5;URL="+hreq.getContextPath()+"/LoginForm.html");  
              
            return;  
        }  
        chain.doFilter(request, response);  
    }  
  
    @Override  
    public void init(FilterConfig arg0) throws ServletException {  
    }  
  
}  