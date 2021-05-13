<%-- 
    Document   : newjsp
    Created on : Apr 25, 2021, 4:26:03 PM
    Author     : dochu
--%>
<%@page import="java.text.DecimalFormat"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="service.impl.ProductServiceImpl"%>
<%@page import="service.ProductService"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  <!-- / header section -->

  <!-- Start slider -->
   <jsp:include page = "./banner-slider/slider.jsp" flush = "true" />
  <!-- / slider -->
     <section id="aa-promo">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-promo-area">
            <div class="row">
              <!-- promo left -->
              <div class="col-md-5 no-padding">                
                <div class="aa-promo-left">
                  <div class="aa-promo-banner">                    
                    <img src="${url}/images/section1_tc.jpg" alt="dâu tây Đà Lạt">                    
                    <div class="aa-prom-content">
                      <span>Giảm giá 35%</span>
                      <h4>Dâu tây Đà Lạt</h4>                      
                    </div>
                  </div>
                </div>
              </div>
              <!-- promo right -->
              <div class="col-md-7 no-padding">
                <div class="aa-promo-right">
                  <div class="aa-single-promo-right">
                    <div class="aa-promo-banner">                      
                      <img src="${url}/images/section2_tc.jpg" alt="hạt tiêu daklak">                      
                      <div class="aa-prom-content">
                        <span>Sản Phẩm độc quyền</span>
                        <h4>Hạt tiêu DakLak</h4>                        
                      </div>
                    </div>
                  </div>
                  <div class="aa-single-promo-right">
                    <div class="aa-promo-banner">                      
                      <img src="${url}/images/section3_tc.jpg" alt="img">                      
                      <div class="aa-prom-content">
                        <span>Sản phẩm nhập khẩu</span>
                        <h4>Cherry Mỹ</h4>                        
                      </div>
                    </div>
                  </div>
                  <div class="aa-single-promo-right">
                    <div class="aa-promo-banner">                      
                      <img src="${url}/images/section4_tc.jpg" alt="img">                      
                      <div class="aa-prom-content">
                        <span>Giảm giá 25%</span>
                        <h4>Tinh Dầu Sả</h4>                        
                      </div>
                    </div>
                  </div>
                  <div class="aa-single-promo-right">
                    <div class="aa-promo-banner">                      
                      <img src="${url}/images/section5_tc.jpg" alt="img">                      
                      <div class="aa-prom-content">
                        <span>Sản phẩm độc quyền</span>
                        <h4>Mật ong rừng Tây Bắc</h4>                        
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
                   <section id="aa-product">
                        <div class="container">
                          <div class="row">
                            <div class="col-md-12">
                              <div class="row">
                                <div class="aa-product-area">
                                  <div class="aa-product-inner">
                         <ul class="nav nav-tabs aa-products-tab">
                    <li class="active"><a href="#raucu" data-toggle="tab">Rau Củ Quả</a></li>
                    <li><a href="#hat" data-toggle="tab">Các Loại Hạt</a></li>
                    <li><a href="#traicay" data-toggle="tab">Trái Cây </a></li>
                    <li><a href="#matong" data-toggle="tab">Mật Ong & Tinh Dầu</a></li>
                  </ul>
                       
                         <div class="tab-content">
                        <div class="tab-pane fade in active" id="raucu">
                            <ul class="aa-product-catg">
                                <c:forEach items="${products_raucu}" var="products_raucu">
                                    <li>
                                        <figure>
                                              <a class="aa-product-img" href="${pageContext.request.contextPath}/product-detail?id=${products_raucu.id}"><img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${products_raucu.image_link}" alt="polo shirt img"></a>
                                                <a class="aa-add-card-btn"href="${pageContext.request.contextPath}/add-cart?product-id=${products_raucu.id}"><span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng</a>
                                                <figcaption>
                                                 <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/product-detail?id=${products_raucu.id}">${products_raucu.name }</a></h4>
                                              <c:choose>
                                                  <c:when test="${products_raucu.discount==0}">
                                                  <span class="aa-product-price">${products_raucu.price} VNĐ</span>
                                                  </c:when>
                                                   <c:when test="${products_raucu.discount!=0}">
                                                      
                                                   <span class="aa-product-price">${products_raucu.price -products_raucu.price*products_raucu.discount/100}00VNĐ</span>    
                                                     <span class="aa-product-price"><del>${products_raucu.price} VNĐ</del></span>
                                                  </c:when>
                                              </c:choose>   
                                                  
                                           
                                            </figcaption>
                                        </figure>
                                                 <c:if test="${products_raucu.discount!=0}">
                                                     	<span class="aa-badge aa-sale">- ${products_raucu.discount}%</span>
                                                 </c:if>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                           <div class="tab-pane fade" id="hat">
                               <ul class="aa-product-catg">
                                   <c:forEach var="products_hat" items="${products_hat}">
                                       <li>
                                           <figure>
                                                <a class="aa-product-img" href="${pageContext.request.contextPath}/product-detail?id=${products_hat.id}"><img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${products_hat.image_link}" alt="polo shirt img"></a>
                                                <a class="aa-add-card-btn"href="${pageContext.request.contextPath}/add-cart?product-id=${products_hat.id}"><span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng</a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/product-detail?id=${products_hat.id}">${products_hat.name }</a></h4>
                                                    <c:choose>
                                                        <c:when test="${products_hat.discount==0}">
                                                             <span class="aa-product-price">${products_hat.price} VNĐ</span><span class="aa-product-price"></span>
                                                        </c:when>
                                                        <c:when test="${products_hat.discount!=0}" >
                                                             <span class="aa-product-price">${products_hat.price -products_hat.price*products_hat.discount/100}00VNĐ</span>    
                                                     <span class="aa-product-price"><del>${products_hat.price} VNĐ</del></span>
                                                        </c:when>     
                                                    </c:choose>
                                                </figcaption>
                                           </figure>
                                                    <c:if test="${products_hat.discount!=0}">
                                                        <span class="aa-badge aa-sale">- ${products_hat.discount}%</span>
                                                    </c:if>   
                                       </li>
                                   </c:forEach>
                               </ul>
                           </div>
                               <div class="tab-pane fade in active" id="traicay">
                                     <ul class="aa-product-catg">
                                         <c:forEach var="products_traicay"  items="${products_traicay}">
                                             <li>
                                                 <figure>
                                                      <a class="aa-product-img" href="${pageContext.request.contextPath}/product-detail?id=${products_traicay.id}"><img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${products_traicay.image_link}" alt="polo shirt img"></a>
                                                      <a class="aa-add-card-btn"href="${pageContext.request.contextPath}/add-cart?product-id=${products_traicay.id}"><span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng</a>
                                                 <figcaption>
                                                    <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/product-detail?id=${products_traicay.id}">${products_traicay.name }</a></h4>
                                                    <c:choose>
                                                        <c:when test="${products_traicay.discount==0}">
                                                             <span class="aa-product-price">${products_traicay.price} VNĐ</span><span class="aa-product-price"></span>
                                                        </c:when>
                                                        <c:when test="${products_traicay.discount!=0}" >
                                                             <span class="aa-product-price">${products_traicay.price -products_traicay.price*products_traicay.discount/100}00VNĐ</span>    
                                                     <span class="aa-product-price"><del>${products_traicay.price} VNĐ</del></span>
                                                        </c:when>     
                                                    </c:choose>
                                                </figcaption>
                                                 </figure>
                                                    <c:if test="${products_traicay.discount!=0}">
                                                        <span class="aa-badge aa-sale">- ${products_traicay.discount}%</span>
                                                    </c:if>   
                                             </li>
                                         </c:forEach>
                                     </ul>
                               </div>
                             <div class="tab-pane fade" id="matong">
                                     <ul class="aa-product-catg">
                                         <c:forEach var="products_matong"  items="${products_matong}">
                                             <li>
                                                 <figure>
                                                      <a class="aa-product-img" href="${pageContext.request.contextPath}/product-detail?id=${products_matong.id}"><img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${products_matong.image_link}" alt="polo shirt img"></a>
                                                      <a class="aa-add-card-btn"href="${pageContext.request.contextPath}/add-cart?product-id=${products_matong.id}"><span class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng</a>
                                                 <figcaption>
                                                    <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/product-detail?id=${products_matong.id}">${products_matong.name }</a></h4>
                                                    <c:choose>
                                                        <c:when test="${products_matong.discount==0}">
                                                             <span class="aa-product-price">${products_matong.price} VNĐ</span><span class="aa-product-price"></span>
                                                        </c:when>
                                                        <c:when test="${products_matong.discount!=0}" >
                                                             <span class="aa-product-price">${products_matong.price -products_matong.price*products_matong.discount/100}00VNĐ</span>    
                                                     <span class="aa-product-price"><del>${products_matong.price} VNĐ</del></span>
                                                        </c:when>     
                                                    </c:choose>
                                                </figcaption>
                                                 </figure>
                                                    <c:if test="${products_matong.discount!=0}">
                                                        <span class="aa-badge aa-sale">- ${products_matong.discount}%</span>
                                                    </c:if>   
                                             </li>
                                         </c:forEach>
                                     </ul>
                               </div>
                             
                         </div>
                               <div class="more-product">
                               <a class="aa-browse-btn" href="${pageContext.request.contextPath}/product">Xem Tất Cả Sản Phẩm <span class="fa fa-long-arrow-right"></span></a>
                                </div>        
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                   </section>
                            <!-- / Products section -->
                            <!-- banner section -->
                    <section id="aa-banner">
                      <div class="container">
                        <div class="row">
                          <div class="col-md-12">        
                            <div class="row">
                              <div class="aa-banner-area">
                              <a href="#"><img src="${url}/images/banner_tc.jpg" alt="fashion banner img"></a>
                            </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </section>   
              <section id="aa-popular-category">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="row">
            <div class="aa-popular-category-area">
              <!-- start prduct navigation -->
             <ul class="nav nav-tabs aa-products-tab">
                <li class="active"><a href="#sanphammoi" data-toggle="tab">Sản Phẩm Mới</a></li>
                <li><a href="#sanphambanchay" data-toggle="tab">Sản Phẩm Bán Chạ</a></li>
                <li><a href="#sanphamgiamgia" data-toggle="tab">Sản Phẩm Giảm Giá</a></li>                    
              </ul>
              <!-- Tab panes -->
              <div class="tab-content">
                <!-- Start men popular category -->
                <div class="tab-pane fade in active" id="sanphammoi">
                  <ul class="aa-product-catg aa-popular-slider">
                    <!-- start single product item -->
                    <c:forEach var="products_new" items="${products_new}" >
                         <li>
                      <figure>
                        <a class="aa-product-img" href="${pageContext.request.contextPath}/product-detail?id=${products_new.id}"><img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${products_new.image_link}" alt="polo shirt img"></a>
                        <a class="aa-add-card-btn"href="${pageContext.request.contextPath}/add-cart?product-id=${products_new.id}"><span class="fa fa-shopping-cart"></span>Add To Cart</a>
                         <figcaption>
                         <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/product-detail?id=${products_new.id}">${products_new.name }</a></h4>
                         <c:choose>
                         <c:when test="${products_new.discount==0}">
                            <span class="aa-product-price">${products_new.price} VNĐ</span><span class="aa-product-price"></span>
                         </c:when>
                          <c:when test="${products_new.discount!=0}" >
                              <span class="aa-product-price">${products_new.price -products_new.price*products_new.discount/100}00VNĐ</span>    
                            <span class="aa-product-price"><del>${products_new.price} VNĐ</del></span>
                           </c:when>  
                         </c:choose>
                         </figcaption>
                      </figure>                     
                         
                             <c:if test="${products_new.discount != 0}">
	                  	<!-- product badge -->
	                     <span class="aa-badge aa-sale">- ${products_new.discount}%</span>
	                  </c:if>
                      <!-- product badge -->
                    </li>     
                    </c:forEach>                                                                              
                  </ul>
                 
                </div>
                <!-- / popular product category -->
                
                <!-- start featured product category -->
                <div class="tab-pane fade" id="sanphambanchay">
                 <ul class="aa-product-catg aa-featured-slider">
                    <!-- start single product item -->        
                       <c:forEach var="products_banchay" items="${products_banchay}" >
                         <li>
                      <figure>
                        <a class="aa-product-img" href="${pageContext.request.contextPath}/product-detail?id=${products_banchay.id}"><img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${products_banchay.image_link}" alt="polo shirt img"></a>
                        <a class="aa-add-card-btn"href="${pageContext.request.contextPath}/add-cart?product-id=${products_banchay.id}"><span class="fa fa-shopping-cart"></span>Add To Cart</a>
                         <figcaption>
                         <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/product-detail?id=${products_banchay.id}">${products_banchay.name }</a></h4>
                         <c:choose>
                         <c:when test="${products_banchay.discount==0}">
                            <span class="aa-product-price">${products_banchay.price} VNĐ</span><span class="aa-product-price"></span>
                         </c:when>
                          <c:when test="${products_banchay.discount!=0}" >
                              <span class="aa-product-price">${products_banchay.price -products_banchay.price*products_banchay.discount/100}00VNĐ</span>    
                            <span class="aa-product-price"><del>${products_banchay.price} VNĐ</del></span>
                           </c:when>  
                         </c:choose>
                         </figcaption>
                      </figure>                     
                         
                             <c:if test="${products_banchay.discount != 0}">
	                  	<!-- product badge -->
	                     <span class="aa-badge aa-sale">- ${products_banchay.discount}%</span>
	                  </c:if>
                      <!-- product badge -->
                    </li>     
                    </c:forEach>                                                                            
                  </ul>
                 
                </div>
                <!-- / featured product category -->

                <!-- start latest product category -->
                <div class="tab-pane fade" id="sanphamgiamgia">
                  <ul class="aa-product-catg aa-latest-slider">
                   <c:forEach var="products_sale" items="${products_sale}" >
                         <li>
                      <figure>
                        <a class="aa-product-img" href="${pageContext.request.contextPath}/product-detail?id=${products_sale.id}"><img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${products_sale.image_link}" alt="polo shirt img"></a>
                        <a class="aa-add-card-btn"href="${pageContext.request.contextPath}/add-cart?product-id=${products_sale.id}"><span class="fa fa-shopping-cart"></span>Add To Cart</a>
                         <figcaption>
                         <h4 class="aa-product-title"><a href="${pageContext.request.contextPath}/product-detail?id=${products_sale.id}">${products_sale.name }</a></h4>
                         <c:choose>
                         <c:when test="${products_sale.discount==0}">
                            <span class="aa-product-price">${products_sale.price} VNĐ</span><span class="aa-product-price"></span>
                         </c:when>
                          <c:when test="${products_sale.discount!=0}" >
                              <span class="aa-product-price">${products_sale.price -products_sale.price*products_sale.discount/100}00VNĐ</span>    
                            <span class="aa-product-price"><del>${products_sale.price} VNĐ</del></span>
                           </c:when>  
                         </c:choose>
                         </figcaption>
                      </figure>                     
                         
                             <c:if test="${products_sale.discount != 0}">
	                  	<!-- product badge -->
	                     <span class="aa-badge aa-sale">- ${products_sale.discount}%</span>
	                  </c:if>
                      <!-- product badge -->
                    </li>     
                    </c:forEach>                
                                                                                             
                  </ul>
                 
                </div>
                <!-- / latest product category -->              
              </div>
              <div class="more-product">
                <a class="aa-browse-btn" href="${pageContext.request.contextPath}/product">Xem Tất Cả Sản Phẩm <span class="fa fa-long-arrow-right"></span></a>
             </div>
            </div>
          </div> 
        </div>
      </div>
    </div>
  </section>    
          <section id="aa-support">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-support-area">
            <!-- single support -->
            <div class="col-md-4 col-sm-4 col-xs-12">
              <div class="aa-support-single">
                <span class="fa fa-truck"></span>
                <h4>MIỄN PHÍ VẬN CHUYỂN</h4>
                <P>Chúng tôi đã áp dụng gói miễn phí vận chuyển cho đơn hàng trên 280.000VNĐ.</P>
              </div>
            </div>
            <!-- single support -->
            <div class="col-md-4 col-sm-4 col-xs-12">
              <div class="aa-support-single">
                <span class="fa fa-clock-o"></span>
                <h4>GIAO HÀNG NHANH</h4>
                <P>Chúng tôi đảm bảo hàng đến tay khách hàng nhanh và đảm bảo sản phẩm an toàn.</P>
              </div>
            </div>
            <!-- single support -->
            <div class="col-md-4 col-sm-4 col-xs-12">
              <div class="aa-support-single">
                <span class="fa fa-phone"></span>
                <h4>HỖ TRỢ 24/7</h4>
                <P>Hỗ trợ tư vấn và đặt hàng mọi lúc mọi nơi, đảm bảo thời gian cho khách hàng.</P>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>   
                            <section id="aa-testimonial">  
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-testimonial-area">
            <ul class="aa-testimonial-slider">
              <!-- single slide -->
              <li>
                <div class="aa-testimonial-single">
                <img class="aa-testimonial-img" src="${url}/images/avatar.jpg" alt="avatar 1">
                  <span class="fa fa-quote-left aa-testimonial-quote"></span>
                  <p>Tôi đã mua hàng ở cửa hàng khá nhiều lần rồi, và tôi cảm thấy sản phẩm của cửa hàng 
                    được giao khá nhanh và sản phẩm thì tốt.</p>
                  <div class="aa-testimonial-info">
                    <p>Ngọc Huy</p>
                    <span>Nhân viên kinh doanh</span>
                  </div>
                </div>
              </li>
              <!-- single slide -->
              <li>
                <div class="aa-testimonial-single">
                <img class="aa-testimonial-img" src="${url}/images/avater-2.jpg" alt="avatar 2">
                  <span class="fa fa-quote-left aa-testimonial-quote"></span>
                  <p> Về chất lượng của sản phẩm thì khỏi phải bàn, rau củ luôn tươi xanh nhìn rất thích. Tôi sẽ mua hàng ở đây thường xuyên<p>
                  <div class="aa-testimonial-info">
                    <p>Mỹ Tân</p>
                    <span>Diễn Viên</span>
                  </div>
                </div>
              </li>
               <!-- single slide -->
              <li>
                <div class="aa-testimonial-single">
                <img class="aa-testimonial-img" src="${url}/images/avatar-1.jpg" alt="avatar 3">
                  <span class="fa fa-quote-left aa-testimonial-quote"></span>
                  <p>Nhiều lần đi làm bận rộn, không có thời gian ra siêu thị nên tôi thường mua hàng online ở đây. Chất lượng sản phẩm và dịch vụ ở đây rất là tốt!</p>
                  <div class="aa-testimonial-info">
                    <p>Oanh Oanh</p>
                    <span>Sinh viên</span>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </section>
        <section id="aa-latest-blog">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="aa-latest-blog-area">
            <h2>Tin Tức</h2>
            <div class="row">
              <!-- single latest blog -->
              <c:forEach items="${boardnewsList}" var="boardnewsList" >
                <div class="col-md-4 col-sm-4">
                <div class="aa-latest-blog-single">
                  <figure class="aa-blog-img">                    
                    <a href="#"><img src="${url}/images/news/${boardnewsList.image_link}" alt="Tin tức ${boardnewsList.title}"></a>  
                      <figcaption class="aa-blog-img-caption">
                      <span href="#"><i class="fa fa-eye"></i>${boardnewsList.created}</span>
                    </figcaption>                          
                  </figure>
                  <div class="aa-blog-info">
                    <h3 class="aa-blog-title"><a href="#">${boardnewsList.title}</a></h3>
                    <p>${boardnewsList.content}</p> 
                    <a href="${pageContext.request.contextPath}/news-list-detail?id=${boardnewsList.id}" class="aa-read-mor-btn">Xem thêm<span class="fa fa-long-arrow-right"></span></a>
                  </div>
                </div>
              </div>
              </c:forEach>
  
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

