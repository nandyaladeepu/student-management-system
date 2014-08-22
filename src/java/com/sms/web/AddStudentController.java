package com.sms.web;  
  
import java.io.IOException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
import com.sms.service.StudentServices;  
import com.sms.Student;  
import com.sms.User;  
  
@WebServlet("/DEO/addStudent")  
public class AddStudentController extends HttpServlet {  
    private static final long serialVersionUID = 1L; 
    private StudentServices studentServices;  
      
    @Override  
    public void init() throws ServletException {  
        studentServices=new StudentServices();  
    }  
      
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        request.getRequestDispatcher("AddStudentForm.jsp").forward(request, response);  
    }  
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
          
        HttpSession session=request.getSession(false);  
        User user=(User)session.getAttribute("user");  
          
        Student student=new Student();  
          
        student.setFname(request.getParameter("fname"));  
        student.setLname(request.getParameter("lname"));  
        student.setEmail(request.getParameter("email"));  
        student.setMobile(request.getParameter("mobile"));  
          
        String dob_input=request.getParameter("dob");//dd-MM-yyyy  
        SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");  
        try{  
            Date dob=df.parse(dob_input);  
            student.setDob(dob);  
        }catch(Exception e){  
            throw new ServletException(e);  
        }  
          
        student.setInsertedOn(new Date());  
        student.setInsertedBy(user.getUname());  
          
        studentServices.create(student);  
          
        session.setAttribute("student", student);  
          
        String url="AddStudentSuccessView.jsp";  
        response.sendRedirect(url);  
    }  
}  