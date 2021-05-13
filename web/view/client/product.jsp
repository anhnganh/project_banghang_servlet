<%-- 
    Document   : product
    Created on : Apr 25, 2021, 1:34:05 PM
    Author     : dochu
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
 
<!-- catg header banner section -->
  <section id="aa-catg-head-banner">
      <img src="${url}/images/banner-product.png" alt="fashion img">
   <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Fashion</h2>
        <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>         
          <li style="color:#fff">Danh sách sản phẩm</li>
        </ol>
      </div>
     </div>
   </div>
  </section>
  <!-- / catg header banner section -->

  <!-- product category -->
  <section id="aa-product-category">
    <div class="container">
      <div class="row">
        <div class="col-lg-9 col-md-9 col-sm-8 col-md-push-3">
          <div class="aa-product-catg-content">
            <div class="aa-product-catg-body">
              <ul class="aa-product-catg">
                  <c:if test="${empty productList}">
                      <p style="margin-left: 30px">Chưa có sản phẩm!</p>
                  </c:if>
                      <c:forEach items="${productList}" var="productList">
            
                    <li>
                      <figure>
                        <a class="aa-product-img" href="${pageContext.request.contextPath}/product-detail?id=${productList.id}"><img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${productList.image_link}" alt="${productList.name}"></a>
                        <a class="aa-add-card-btn"href="${pageContext.request.contextPath}/add-cart?product-id=${productList.id}"><span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng</a>
                        <figcaption>
                          <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/product-detail?id=${productList.id}">${productList.name}</a></h4>
                              <c:choose>
                                 <c:when test="${productList.discount==0}">
                                 <span class="aa-product-price">${productList.price} VNĐ</span>
                                 </c:when>
                                 <c:when test="${productList.discount!=0}">
                                 <span class="aa-product-price">${productList.price -productList.price*productList.discount/100}00VNĐ</span>    
                                 <span class="aa-product-price"><del>${productList.price} VNĐ</del></span>
                              </c:when>
                              </c:choose>
                          
                        </figcaption>
                      </figure>                          
                      <c:if test="${productList.discount!=0}">
                     	<span class="aa-badge aa-sale">- ${productList.discount}%</span>
                  </c:if>
                    </li>         
                      </c:forEach>
             
              </ul>
            </div>
          </div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-md-pull-9">
          <aside class="aa-sidebar">
            <!-- single sidebar -->
            <div class="aa-sidebar-widget">
              <h3>Danh mục</h3>
              <ul class="aa-catg-nav">
                  <c:forEach var="cateList" items="${cateList}" >
                      <li><a href="${pageContext.request.contextPath}/product-id?id=${cateList.id}">${cateList.name}</a></li>
                  </c:forEach>
              </ul>
            </div>
            <!-- single sidebar -->
           
            <!-- single sidebar -->
             <div class="aa-sidebar-widget">
              <h3>Sản phẩm gần đây</h3>
              <div class="aa-recently-views">
                <ul>
                    <c:forEach items="${productList}" var="productList" end="2">    
                   <li>
                    <a href="${pageContext.request.contextPath}/product-detail?id=${productList.id}" class="aa-cartbox-img"><img alt="img" src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${productList.image_link}"></a>
                    <div class="aa-cartbox-info">
                      <h4><a href="${pageContext.request.contextPath}/product-detail?id=${productList.id}">${productList.name }</a></h4>
                     <c:choose>
				<c:when test="${productList.discount == 0}">
	                       <p>${productList.price} VNĐ</p>
	              </c:when>
	                     <c:when test="${productList.discount!=0}">
                                 <span class="aa-product-price">${productList.price -productList.price*productList.discount/100}00VNĐ</span>    
                                 <span class="aa-product-price"><del>${productList.price} VNĐ</del></span>
                        </c:when>
	              </c:choose>
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
  </section>
  
  
  <!-- / product category -->
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