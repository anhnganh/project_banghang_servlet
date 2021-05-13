<%-- 
    Document   : bottomHeader
    Created on : Apr 23, 2021, 11:34:33 AM
    Author     : dochu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/client/assets" var="url" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>

          <!-- start header bottom  -->
    <div class="aa-header-bottom">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="aa-header-bottom-area">
              <!-- logo  -->
              <div class="aa-logo">
                  <a href="${pageContext.request.contextPath}/"><img src="${url}/images/logo.png" alt="logo img" width="100%"></a> 
                
              </div>
                  
                  <div class="aa-shipping-box">
                  <a class="aa-shipping-boxsmall">
                      <span class="aa-shipping-boxsmall-icon fas fa-shipping-fast"></span>
                      <span class="aa-shipping-box-text">
                          <div class="aa-shipping-title">Miễn phí vận chuyển</div>
                      <div class="">Khu vực TP Ha Noi</div>
                      </span>
                      
                  </a>
                  <a class="aa-shipping-boxsmall">
                      <span class="aa-shipping-boxsmall-icon fas fa-phone"></span>
                      <span class="aa-shipping-box-text">
                          <div class="aa-shipping-title">Hỗ trợ: 0901588662</div>
                          <div class="">Tư vấn 24/7 miễn phí</div>
                      </span>
                      
                  </a>
                  <a class="aa-shipping-boxsmall">
                      <span class="aa-shipping-boxsmall-icon fas fa-shipping-fast"></span>
                      <span class="aa-shipping-box-text">
                          <div class="aa-shipping-title">Giao hàng toàn quốc</div>
                      <div class="">Đảm bảo uy tín, chất lượng</div>
                      </span>
                      
                  </a>
              </div>
              <!-- / logo  -->
               <!-- cart box -->
                <div class="aa-cartbox">
                <a class="aa-cart-link" href="${pageContext.request.contextPath}/cart">
                  <span class="fas fa-cart-arrow-down"></span>
                  <span class="aa-cart-title">GIỎ HÀNG</span>
                 
                  <c:if test="${length_order != NULL}">
                  	<span class="aa-cart-notify">${length_order}</span>
                  </c:if>
                  

                </a>
                <div class="aa-cartbox-summary">
                 
                  <ul class="scroll-product">
                      <c:forEach var="item" items="${order.items}">
                          <li>
                         <a class="aa-cartbox-img" href="${pageContext.request.contextPath}/cart"><img src="${pageContext.request.contextPath}/view/client/assets/images/products/img-test/${item.product.image_link}" alt="img"></a>
                        <div class="aa-cartbox-info">
                        <h4><a href="${pageContext.request.contextPath}/cart">${item.product.name}</a></h4>
                        <p>${item.qty} x ${item.product.price * (1-((item.product.discount)/100))}00 VNĐ</p>
                      </div>
                    </li>
                      </c:forEach>         
                  </ul>
                  <div class="total-detailproduct">
                  		<span class="aa-cartbox-total-title">
                        <b>Tổng:</b>
                      </span>
                      <span class="aa-cartbox-total-price">
                        ${sumprice}000 VNĐ
                      </span>
                  </div>
                  <a class="aa-cartbox-checkout aa-primary-btn" href="${pageContext.request.contextPath}/cart">Chi tiết</a>
                  <a class="aa-cartbox-checkout aa-primary-btn" href="${pageContext.request.contextPath}/checkout">Thanh toán</a>
             
             
                </div>
              </div>
            
            
            </div>
              <!-- / cart box -->
            
             
          </div>
        </div>
      </div>
    </div>

