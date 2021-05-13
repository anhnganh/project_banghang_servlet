<%-- 
    Document   : blog-single
    Created on : Apr 29, 2021, 1:44:48 AM
    Author     : dochu
--%>

<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  
  <section id="aa-catg-head-banner">
   <img src="${pageContext.request.contextPath}/view/client/assets/images/blog-banner.png" alt="banner blog">
   <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Chi tiết bài viết</h2>
        <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>
          <li style="color:#fff">Bài viết</li>
        </ol>
      </div>
     </div>
   </div>
  </section>
  
  <section id="aa-blog-archive">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-blog-archive-area">
            <div class="row">
              <div class="col-md-9">
                <!-- Blog details -->
                <div class="aa-blog-content aa-blog-details">
                  <article class="aa-blog-content-single">                        
                    <h2><a href="#">${boardnew.title}</a></h2>
                     <div class="aa-article-bottom">
                      <div class="aa-post-author">
                        Đăng bởi: <a href="#">${boardnew.author}</a>
                      </div>
                      <div class="aa-post-date">
                        ${boardnew.created}
                      </div>
                    </div>
                    <figure class="aa-blog-img">
                      <a href="#"><img src="${pageContext.request.contextPath}/view/client/assets/images/news/${boardnew.image_link}" alt="fashion img"></a>
                    </figure>
                    <p>${boardnew.content}</p>
                    <div class="blog-single-bottom">
                      <div class="row">
                        
                        <div class="col-md-4 col-sm-6 col-xs-12">
                          <div class="blog-single-social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-linkedin"></i></a>
                            <a href="#"><i class="fa fa-google-plus"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                          </div>
                        </div>
                      </div>
                    </div>
                   
                  </article>
                  <!-- Blog Comment threats -->
                  <div class="aa-blog-comment-threat">
                    <h3>Comments </h3>
                    <div class="comments">
                      <ul class="commentlist">
                          <li>
                               <c:forEach var="reviewList" items="${reviewList}">
                                   <div class="media">
                                     <div class="media-body">    
                                         <h4 class="author-name">${reviewList.name}</h4>
                                           <span class="comments-date">${reviewList.created} </span>
                                           <p>${reviewList.concent}</p>
                                     </div>
                                     </div>
                               </c:forEach>
                          </li>
                        
                      </ul>
                    </div>
  
                  </div>
                  <!-- blog comments form -->
                  <div id="respond">
                    <h3 class="reply-title">Leave a Comment</h3>
                    <form id="commentform">
                      <p class="comment-notes">
                        Your email address will not be published. Required fields are marked <span class="required">*</span>
                      </p>
                      <p class="comment-form-author">
                        <label for="author">Name <span class="required">*</span></label>
                        <input type="text" name="author" value="" size="30" required="required">
                      </p>
                      <p class="comment-form-email">
                        <label for="email">Email <span class="required">*</span></label>
                        <input type="email" name="email" value="" aria-required="true" required="required">
                      </p>
                      <p class="comment-form-url">
                        <label for="url">Website</label>
                        <input type="url" name="url" value="">
                      </p>
                      <p class="comment-form-comment">
                        <label for="comment">Comment</label>
                        <textarea name="comment" cols="45" rows="8" aria-required="true" required="required"></textarea>
                      </p>
                      
                      <p class="form-submit">
                        <input type="submit" name="submit" class="aa-browse-btn" value="Post Comment">
                      </p>        
                    </form>
                  </div>
                </div>
              </div>

              <!-- blog sidebar -->
              <div class="col-md-3">
                <aside class="aa-blog-sidebar">
                 
                  <div class="aa-sidebar-widget">
                    <h3>Danh mục</h3>
                    <c:forEach var="catalogList" items="${catalogList}">
                        <ul>  <li><a href="${pageContext.request.contextPath}/product-id?id=${catalogList.id}">${catalogList.name}</a></li></ul>
                    </c:forEach>
                  </div>
                  <div class="aa-sidebar-widget">
                    <h3>Bài đăng gần đây</h3>
                    <div class="aa-recently-views">
                      <ul>
                          <c:forEach var="boardnew" items="${boardnewsList}">
                              <li>
                                <a class="aa-cartbox-img" href="${pageContext.request.contextPath}/view/client/news-list-detail?id=${boardnew.id}"><img src="${pageContext.request.contextPath}/view/client/assets/images/news/${boardnew.image_link}" alt="img bài viết"></a>
                          <div class="aa-cartbox-info">
                            <h4><a href="${pageContext.request.contextPath}/view/client/news-list-detail?id=${boardnew.id}"><b>${boardnew.title }</b></a></h4>
                            <p>${boardnew.created }</p>
                          </div>     
                              </li>
                          </c:forEach>
                        
                        
                      </ul>
                    </div>                            
                  </div>
                </aside>
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