<jsp:include page="Menu.jsp"></jsp:include>
<table border="1" height="100%" width="100%">  
    <tbody>
        <tr>  
            <th colspan="2" height="30">Student Management System</th>  
        </tr>  
        <tr>  
            <td valign="top">
                Welcome, ${sessionScope.user.fname } ${sessionScope.user.lname }
                <br>  
                <form action="addStudent" method="post">  
                    <pre>
                        First Name : <input name="fname" type="text">  
                        Last Name : <input name="lname" type="text">  
                        DOB : <input name="dob" type="text"> (dd-MM-yyyy)  
                        Email : <input name="email" type="text">  
                        Mobile : <input name="mobile" type="text">  
                        <input value="Create" type="submit">  
                    </pre>  
                </form>  

            </td>  
        </tr>  
        <tr>  
            <th colspan="2" height="30">@ Copyrights AdvJava Class</th>  
        </tr>  
    </tbody>
</table>