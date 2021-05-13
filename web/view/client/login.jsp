<%-- 
    Document   : login
    Created on : Apr 29, 2021, 4:31:34 PM
    Author     : dochu
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

  <!-- Start header section -->
  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
 <section id="aa-catg-head-banner">
  <img src="${pageContext.request.contextPath}/view/client/assets/images/archive-banner.png" alt="banner blog">
    <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Đăng nhập</h2>
        <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>                   
          <li style="color:#fff">Đăng nhập</li>
        </ol>
      </div>
     </div>
   </div>
  </section>

  <!-- / catg header banner section -->

 <!-- Cart view section -->
 <section id="aa-myaccount">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
        <div class="aa-myaccount-area">         
            <div class="row">
              <div class="col-md-8 col-md-push-2">
                <div class="aa-myaccount-login">
                <h4>Đăng nhập</h4>
                 <form class="aa-login-form" name="loginform" onsubmit="validate();" action="${pageContext.request.contextPath}/login" method="post">
                  <label for="">Username<span>*</span></label>
                   <input type="text" placeholder="Username" name="username">
                   <label for="">Mật khẩu<span>*</span></label>
                    <input type="password" placeholder="Password" name="password">
                    <p class="rememberme" style="display: block"><input type="checkbox" id="rememberme"> Ghi nhớ </p> 
     
                    <p style="color:red; display:block">
		                ${errorMsg}
		            </p>
		             <button type="submit" class="aa-browse-btn">Đăng nhập</button>
		                
                  </form>
                </div>
              </div>
            </div>          
         </div>
       </div>
     </div>
   </div>
 </section>
          
  <jsp:include page = "./footer/footer.jsp" flush = "true" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="${url}/js/bootstrap.js"></script>  
  <!-- SmartMenus jQuery plugin -->
  <!-- SmartMenus jQuery Bootstrap Addon -->
 <script type="text/javascript" src="${url}/js/jquery.smartmenus.bootstrap.js"></script>  
 <script type="text/javascript" src="js/jquery.smartmenus.js"></script>
  <!-- To Slider JS -->
  <script src="${url}/js/sequence.js"></script>
  <script src="${url}/js/sequence-theme.modern-slide-in.js"></script>  
  <!-- Product view slider -->
  <script type="text/javascript" src="${url}/js/jquery.simpleGallery.js"></script>
  <script type="text/javascript" src="${url}/js/jquery.simpleLens.js"></script>
  <!-- slick slider -->
  <script type="text/javascript" src="${url}/js/slick.js"></script>
  <!-- Price picker slider -->
  <script type="text/javascript" src="${url}/js/nouislider.js"></script>
  <script type="text/javascript" src="${url}/js/validate.js"></script>
  <!-- Custom js -->
  <script type="text/javascript" src="${url}/js/custom.js"></script>