<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
  
  
    <jsp:include page="Menu.jsp"></jsp:include>
    <c:remove var="student" scope="session"></c:remove>
    <table border="1" height="100%" width="100%">  
        <tbody>
            <tr>  
                <th colspan="2" height="30">Student Management System</th>  
            </tr>  
        <tr>  
            <td valign="top">Welcome, ${sessionScope.user.fname }  
                ${sessionScope.user.lname }<br> <br>  
                <br>  
                <center>  
                    The following details of the student <br> are saved successfully  
                    with the SID : <b>${sessionScope.student.sid }</b>  
                </center>  
                <br> 
                <br>
                First Name : ${student.fname }
                <br>
                Last Name :  ${student.lname }
                <br>
                DOB: <fmt:formatDate value="${student.dob}" pattern="dd-MM-yyyy"></fmt:formatDate>
                <br>
                Mobile :  ${student.mobile }
                <br>
                EmailID : ${student.email }  
            </td>  
        </tr>
        <tr>  
            <th colspan="2" height="30">@ Copyrights AdvJava Class</th>  
        </tr>  
    </tbody>
</table>