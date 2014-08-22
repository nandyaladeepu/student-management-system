<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<c:url var="homeUrl" value="UserHomeView.jsp"></c:url>  
<c:url var="addStudentUrl" value="AddStudentForm.jsp"></c:url>  
<c:url var="searchStudentUrl" value="SearchStudentForm.jsp"></c:url>  
<c:url var="logoutUrl" value="logout"></c:url>  

<td width="110" valign="top">  
    <a href="${homeUrl }">Home</a><br>  
    <a href="${addStudentUrl}">Add Student</a><br>  
    <a href="${searchStudentUrl}">Search Student</a><br>  
    <a href="${logoutUrl}">Logout</a><br>  
</td>   