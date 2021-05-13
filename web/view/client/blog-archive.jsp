<%-- 
    Document   : blog-archive
    Created on : Apr 28, 2021, 5:29:19 PM
    Author     : dochu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  
  <!-- catg header banner section -->
  <section id="aa-catg-head-banner">
   <img src="${url}/images/archive-banner.png" alt="fashion img">
   <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Tin tức</h2>
        <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}">Trang chủ</a></li>         
          <li style="color: #fff">Tin tức</li>
        </ol>
      </div>
     </div>
   </div>
  </section>
  <!-- / catg header banner section -->

  <!-- Blog Archive -->
  <section id="aa-blog-archive">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-blog-archive-area">
            <div class="row">
              <div class="col-md-9">
                <div class="aa-blog-content">
                  <div class="row">
                   
                   
                      <c:forEach items="${boardNews}" var="boardNews">
                          <div class="col-md-4 col-sm-4">
                      <article class="aa-blog-content-single">                        
                        <h4><a href="${pageContext.request.contextPath}/news-list-detail?id=${boardNews.id}">${boardNews.title}</a></h4>
                        <figure class="aa-blog-img">
                          <a href="${pageContext.request.contextPath}/news-list-detail?id=${boardNews.id}"><img src="${pageContext.request.contextPath}/view/client/assets/images/news/${boardNews.image_link}" alt="fashion img"></a>
                        </figure>
                        <p>${boardNews.content}</p>
                        <div class="aa-article-bottom">
                          <div class="aa-post-author">
                            Đăng bởi: <a href="#">${boardNews.author}</a>
                          </div>
                          <div class="aa-post-date">
                            ${boardNews.created}
                          </div>
                        </div>
                      </article>
                    </div>
                   </c:forEach>

                      
                  </div>
                </div>
                <!-- Blog Pagination -->
            
              </div>
            
           
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- / Blog Archive -->


  <!-- Subscribe section -->
 
  
  
  
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
