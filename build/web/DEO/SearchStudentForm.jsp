<!-- SearchStudentForm.html -->  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
 
  
    <jsp:include page="Menu.jsp"></jsp:include>
    <table border="1" height="100%" width="100%">  
        <tbody><tr>  
            <th colspan="2" height="30">Student Management System</th>  
        </tr>  
        <tr>  
            <td valign="top">  
                        Welcome, ${sessionScope.user.fname } ${sessionScope.user.lname }<br>  
            <c:url var="searchStudentUrl" value="searchStudent"> </c:url> 
                <form action="${searchStudentUrl}" method="post">  
                    <pre>Value : <input name="key" type="text">  
Criteria : <select name="criteria">  
<option>SID</option>  
<option>Name</option>  
</select>  
<input value="Search" type="submit">  
</pre>  
  
                </form>  
            </td>  
        </tr>  
        <tr>  
            <th colspan="2" height="30">@ Copyrights AdvJava Class</th>  
        </tr>  
    </tbody></table>  