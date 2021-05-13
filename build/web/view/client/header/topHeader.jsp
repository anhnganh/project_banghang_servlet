<%-- 
    Document   : topHeader
    Created on : Apr 23, 2021, 11:18:39 AM
    Author     : dochu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/client/assets" var="url" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="aa-header-top">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="aa-header-top-area">
              <!-- start header top left -->
              <div class="aa-header-top-left">
                  <div class="cellphone hidden-xs">
                  <p><span class="fas fa-home"></span>Website bán hàng nông sản</p>
                </div>
                <!-- start language -->
                <div class="aa-language">
                  <div class="dropdown">
                     <a class="btn dropdown-toggle" href="#" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                      <img src="${url}/img/flag/vietnam.png" alt="english flag" >Việt Nam
                    </a>
                   
                  </div>
                </div>
                
              </div>
              <!-- / header top left -->
              <div class="aa-header-top-right">
                <ul class="aa-head-top-nav-right">
                    
                    <c:if test="${sessionScope.user!=null}">
                        	<a><strong>Chào </strong> ${user }</a>
                        <li class="hidden-xs"><a href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
                    </c:if>
                            <c:if test="${sessionScope.user==null}">
                             <li class="hidden-xs"><a href="${pageContext.request.contextPath}/register">Đăng kí</a></li>
                             <li><a href="${pageContext.request.contextPath}/login" data-toggle="modal" >Đăng nhập</a></li>
                    </c:if>
                  
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    </body>
</html>
