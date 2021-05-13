/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Catalog;
import model.Product;
import service.CategoryService;
import service.ProductService;
import service.impl.CategoryServicesImpl;
import service.impl.ProductServiceImpl;

/**
 *
 * @author dochu
 */
@WebServlet(name = "ProductAddController", urlPatterns = {"/admin/product/add"})
public class ProductAddController extends HttpServlet {

    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServicesImpl();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        
        
    }

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Catalog> cateList = categoryService.getAll();
        request.setAttribute("catelist", cateList);
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/addproduct.jsp");
        rd.forward(request, response);
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=UTF-8");
       String product_cate = request.getParameter("product-cate");
        String product_name = request.getParameter("product-name");   
        String product_price = request.getParameter("product-price");
        String product_status = request.getParameter("product-status");
       String product_desc = request.getParameter("product-desc");
      String product_content = request.getParameter("product-concent");
     String product_discount = request.getParameter("product_discount");
      String product_image = request.getParameter("product-image");
      String product_day = request.getParameter("product-day");
      
       
        Product product = new Product();
         product.setCatalog_id(product_cate);
        product.setName(product_name);
         product.setPrice(product_price);
        product.setStatus(product_status);
       
        product.setDescription(product_desc);
        product.setContent(product_content);
         product.setDiscount(product_discount);
        product.setImage_link(product_image);
      product.setCreated(product_day);
        productService.insert(product); 
        response.sendRedirect(request.getContextPath()+"/admin/product/list");
        
    }

    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
