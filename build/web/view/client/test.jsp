<%-- 
    Document   : test
    Created on : Apr 27, 2021, 6:36:28 PM
    Author     : dochu
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/client/assets" var="url"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form class="aa-login-form" method="post" action="${pageContext.request.contextPath}/register" >
                    <label for="">Họ tên<span>*</span></label>
                    <input type="text" placeholder="Name" name="name" required>   
                     <label for="">Email <span>*</span></label>
                    <input type="text" placeholder="useremail@gmail.com" name="email" required>
                    <label for="">Số điện thoại<span>*</span></label>
                    <input type="text" placeholder="Số điện thoại" name="phone" required>   
                     <label for="">Username<span>*</span></label>
                    <input type="text" placeholder="Username" name="username" required>
                    <label for="">Mật khẩu<span>*</span></label>  
                    <input type="password" placeholder="Password" name="password" required>     
                    <input type="date" style="display: none" placeholder="Password" name="created" id="the-date">             
                      
                    
		    <button type="reset" class="aa-browse-btn" value="Reset">Đặt lại</button>  
                      <button type="submit" class="aa-browse-btn">Đăng ký</button>                         
                  </form>
        <script>
		var date = new Date();
		
		var day = date.getDate();
		var month = date.getMonth() + 1;
		var year = date.getFullYear();
		
		if (month < 10) month = "0" + month;
		if (day < 10) day = "0" + day;
		
		var today = year + "-" + month + "-" + day;
		
		
		document.getElementById('the-date').value = today;
    </script>
    </body>
</html>
