<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
  
  
    <c:import url="Menu.jsp">  
            </c:import><table border="1" height="100%" width="100%">  
        <tbody><tr>  
            <th colspan="2" height="30">Student Management System</th>  
        </tr>  
        <tr>  
            <td valign="top">Welcome, ${user.fname} ${sessionScope.user.lname}<br>  
                <br> <c:choose>  
                    <c:when test="${empty sessionScope.students }">  
                        <i>Sorry no student found with the name like : ${param.key }   
                    </i></c:when><i>  
                    <c:otherwise>  
                        <c:if test="${empty param.pageNo }" var="flag">  
                                <c:set var="perPageRecords" value="2" scope="session">  
                                <c:set var="pageNo" value="1">  
                            </c:set></c:set></c:if><c:if test="${not flag }">  
                                <c:set var="pageNo" value="${param.pageNo }">  
                            </c:set></c:if><c:set var="begin" value="${(pageNo-1) * perPageRecords }">  
                            <c:forEach items="${students }" var="student" begin="${begin}" end="${begin+(perPageRecords-1) }">  
                            </c:forEach>
                            </c:set>
                        <table>  
                            <tbody><tr>  
                                <th>SID</th>  
                                <th>FirstName</th>  
                                <th>LastName</th>  
                                <th></th>  
                            </tr>  
  
                              
                              
                            <tr bgcolor="#00ffff">  
                                    <td>${student.sid }</td>  
                                    <td>${student.fname }</td>  
                                    <td>${student.lname }</td>  
                                    <td>  
<c:url var="searchStudentUrl" value="searchStudent">  
        <c:param name="criteria" value="SID">  
        <c:param name="key" value="${student.sid }">  
</c:param></c:param></c:url>   
                                    <a href="${searchStudentUrl }">More Details</a></td>  
                                </tr>  
                              
                            <tr>  
                                <td colspan="4">  
                                <b>Page No : ${pageNo }</b> |   
                                <c:if test="${pageNo != 1 }">  
                                        <c:url var="previousUrl" value="MultipleStudentDetailsView.jsp">  
                                            <c:param name="pageNo" value="${pageNo-1}">  
                                        </c:param></c:url>  
                                        <a href="${previousUrl }">< Previous</a> |   
                                </c:if>   
                                  
                                <c:if test="${fn:length(students) >  (begin+(perPageRecords-1))}">    
                                    <c:url var="nextUrl" value="MultipleStudentDetailsView.jsp">  
                                        <c:param name="pageNo" value="${pageNo+1}">  
                                    </c:param></c:url>   
                                    <a href="${nextUrl }">Next ></a>  
                                </c:if>  
                                  
                                </td>  
                            </tr>  
                        </tbody></table>  
                    </c:otherwise>  
                </i></c:choose>
               <i> <br>  
            <br>  
  
  
  
            </i></td>  
        </tr>  
        <tr>  
            <th colspan="2" height="30">@ Copyrights AdvJava Class</th>  
        </tr>  
    </tbody></table>  
  