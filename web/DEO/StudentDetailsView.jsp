<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
  
    <jsp:include page="Menu.jsp"></jsp:include>
        <table border="1" height="100%" width="100%">  
        <tbody><tr>  
            <th colspan="2" height="30">Student Management System</th>  
        </tr>  
        <tr>  
            <td valign="top">Welcome, ${user.fname} ${sessionScope.user.lname}<br>  
              
            <c:if test="${empty requestScope.student }" var="flag">  
            <i>Sorry no student found with the sid : ${param.key }  
            </i></c:if><i>  
            <c:if test="${not flag }">  
             <table>  
              <tbody><tr><th>First Name : </th><td>${student.fname}</td></tr>  
              <tr><th>Last Name : </th><td>${student.lname}</td></tr>  
              <tr><th>DOB : </th><td>
                      <fmt:formatDate value="${student.dob }" pattern="dd-MM-yyyy"/></td></tr>  
              <tr><th>Email : </th><td>${student.email}</td></tr>  
              <tr><th>Mobile : </th><td>${student.mobile}</td></tr>  
             </tbody></table>  
            </c:if>  
              
            </i></td>  
        </tr>  
        <tr>  
            <th colspan="2" height="30">@ Copyrights AdvJava Class</th>  
        </tr>  
    </tbody></table>