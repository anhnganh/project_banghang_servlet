<%-- 
    Document   : product-detail
    Created on : Apr 25, 2021, 12:29:14 PM
    Author     : dochu
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  
  <section id="aa-catg-head-banner">
      <img src="${pageContext.request.contextPath}/view/client/assets/images/banner-product.png" alt="banner sản phẩm">
   <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Chi tiết sản phẩm</h2>
        <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}">Trang chủ</a></li>         
          <li><a href="${pageContext.request.contextPath}/view/client/product">Sản phẩm</a></li>
           <li style="color:#fff">${detail_product.name }</li>
        </ol>
      </div>
     </div>
   </div>
  </section>
  <!-- / catg header banner section -->

  <!-- product category -->
  <section id="aa-product-details">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-product-details-area">
            <div class="aa-product-details-content">
              <div class="row">
                <!-- Modal view slider -->
                 <div class="col-md-5 col-sm-5 col-xs-12">                              
                  <div class="aa-product-view-slider">                                
                    <div id="demo-1" class="simpleLens-gallery-container">
                      <div class="simpleLens-container">
                          <div class="simpleLens-big-image-container"><a data-lens-image="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${detail_product.image_link}" class="simpleLens-lens-image"><img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${detail_product.image_link}" class="simpleLens-big-image"></a></div>
                      </div>
                    
                    </div>
                  </div>
                </div>
                <!-- Modal view content -->
                <div class="col-md-7 col-sm-7 col-xs-12">
                  <div class="aa-product-view-content">
                    <h3>${detail_product.name}</h3>
                    <div class="aa-price-block">
                    <c:choose>
                         <c:when test="${detail_product.discount==0}">
                            <span class="aa-product-price">${detail_product.price} VNĐ</span>
                            </c:when>
                           <c:when test="${detail_product.discount!=0}">
                                 <span class="aa-product-price">${detail_product.price -detail_product.price*detail_product.discount/100}00VNĐ</span>    
                                 <span class="aa-product-price"><del>${detail_product.price} VNĐ</del></span>
                           </c:when>
                           </c:choose>   
                      <p class="aa-product-avilability"> <span>Tình trạng</span>
                          <c:choose>
                          <c:when test="${detail_product.status == 1}">
                              <c:out value="Con hang" />
                          </c:when>
                           <c:when test="${detail_product.status !=1}">
                              <c:out value="Het hang" />
                          </c:when>
                          </c:choose>
                      </p>
                    </div>
                    <p> ${detail_product.description}</p>
                    
                    
                    <div class="aa-prod-quantity">
                      <p class="aa-prod-category">
                           <strong>Danh mục</strong>
                          <c:forEach items="${name_cate_of_product}" var="name_cate">
                          <li><a href="product.jsp">${name_cate.name}</a></li>
                          </c:forEach>
                      </p>
                    </div>
                     <div class="aa-prod-view-bottom">
                      <a class="aa-add-to-cart-btn" href="${pageContext.request.contextPath}/add-cart?product-id=${detail_product.id}">Thêm vào giỏ hàng</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
                      
                    
                    
            <div class="aa-product-details-bottom">
              <ul class="nav nav-tabs" id="myTab2">
                <li><a href="#description" data-toggle="tab">Mô tả</a></li>
                <li><a href="#review" data-toggle="tab">Đánh giá</a></li>                
              </ul>

              <!-- Tab panes -->
              <div class="tab-content">
                <div class="tab-pane fade in active" id="description">
                  <p>${detail_product.content} </p>
               
                </div>
                  
                  
                <div class="tab-pane fade" id="review">
                 <div class="aa-product-review-area">
                   <ul class="aa-review-nav">
                        <c:forEach items="${reviewsById}" var="review" >
                     <li>
                        <div class="media">
                          <div class="media-body">
                            <h4 class="media-heading"><strong>${review.name}</strong> - ${review.created} <span></span></h4>
                            <div class="aa-product-rating">
                              <span class="fa fa-star"></span>
                              <span class="fa fa-star"></span>
                              <span class="fa fa-star"></span>
                              <span class="fa fa-star"></span>
                              <span class="fa fa-star"></span>
                            </div>
                            <p>${review.concent}</p>
                          </div>
                        </div>
                      </li>
                      </c:forEach>
                   </ul>
                   <h4>Thêm đánh giá</h4>
                  
                   <!-- review form -->
                   <form action="${pageContext.request.contextPath}/review?id=${detail_product.id}" class="aa-review-form" method="post" >
                       <div class="form-group">
                        <label for="name">Tên</label>
                        <input type="text" class="form-control" id="name" placeholder="Name" name="name">
                      </div>  
                      <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" placeholder="example@gmail.com" name="email">
                      </div>
                      <div class="form-group">
                        <label for="message">Đánh giá của bạn</label>
                        <textarea class="form-control" rows="3" id="content" name="content"></textarea>
                      </div>

                      <button type="submit" class="btn btn-default aa-review-submit">Gửi</button>
                   </form>
                 </div>
                </div>            
              </div>
            </div>
            <!-- Related product -->
            <div class="aa-product-related-item">
              <h3>Sản phẩm liên quan</h3>
              <ul class="aa-product-catg aa-related-item-slider">
               <!-- start single product item -->
               <c:forEach var="productById" items="${productById}">
                    <li>
                  <figure>
                    <a class="aa-product-img" href="${pageContext.request.contextPath}/product-detail?id=${productById.id}"><img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${productById.image_link}" alt="polo shirt img"></a>
                    <a class="aa-add-card-btn"href="#"><span class="fa fa-shopping-cart"></span>Add To Cart</a>
                     <figcaption>
                      <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/product-detail?id=${productById.id}">${productById.name}</a></h4>
                       <c:choose>
                         <c:when test="${productById.discount==0}">
                            <span class="aa-product-price">${productById.price} VNĐ</span>
                            </c:when>
                           <c:when test="${productById.discount!=0}">
                                 <span class="aa-product-price">${productById.price -productById.price*productById.discount/100}00VNĐ</span>    
                                 <span class="aa-product-price"><del>${productById.price} VNĐ</del></span>
                           </c:when>
                           </c:choose>   
                    </figcaption>
                  </figure>                     
                  
                  <!-- product badge -->
                  <c:if test="${productById.discount!=0}">
                     	<span class="aa-badge aa-sale">- ${productById.discount}%</span>
                  </c:if>
                </li>        
               </c:forEach>
                
              </ul>
                           
              
             
            </div>  
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- / product category -->

  <!-- footer -->  
  
  
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