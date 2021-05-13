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
@WebServlet(name = "ProductEditController", urlPatterns = {"/admin/product/edit"})
public class ProductEditController extends HttpServlet {

   private static final long serialVersionUID = 1L;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductEditController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductEditController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServicesImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Catalog> cateList = categoryService.getAll();
        request.setAttribute("catelist", cateList);
        
        String id = request.getParameter("id");
        Product product = productService.get(Integer.parseInt(id));
        request.setAttribute("product", product);
        
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/editproduct.jsp");
        rd.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      Product product = new Product();
        product.setId(request.getParameter("product-sku"));
        product.setCatalog_id(request.getParameter("product-cate"));
       product.setName(request.getParameter("product-name"));
       product.setPrice(request.getParameter("product-price"));
       product.setStatus(request.getParameter("product-status"));
       product.setDescription(request.getParameter("product-desc"));
       product.setContent(request.getParameter("product-content"));
       product.setDiscount(request.getParameter("product-discount"));
       product.setImage_link(request.getParameter("product-image"));
       product.setCreated(request.getParameter("product-day"));
       productService.insert(product);
        response.sendRedirect(request.getContextPath()+"/admin/product/list");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
