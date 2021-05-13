/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Catalog;
import model.Product;
import model.Review;
import service.CategoryService;
import service.ProductService;
import service.ReviewService;
import service.impl.CategoryServicesImpl;
import service.impl.ProductServiceImpl;
import service.impl.ReviewServicesImpl;

/**
 *
 * @author dochu
 */
@WebServlet(name = "ProductDetailController", urlPatterns = {"/product-detail"})
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   CategoryService cateService = new CategoryServicesImpl();
	   ProductService productService = new ProductServiceImpl();
	   ReviewService reviewService = new ReviewServicesImpl();
	   DecimalFormat df = new DecimalFormat("#.000");
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        String id = request.getParameter("id");
        Product detail_product = productService.get(Integer.parseInt(id));
        request.setAttribute("detail_product", detail_product);
        
        List<Catalog> name_cate_of_product = cateService.getCateByProduct(Integer.parseInt(id));
        request.setAttribute("name_cate_of_product", name_cate_of_product);
        
        List<Review> reviewsById = reviewService.getReviewById(Integer.parseInt(id));
        request.setAttribute("reviewsById", reviewsById);
        
     String idCate = detail_product.getCatalog_id();
      List<Product> productlistCate = productService.getProductById(Integer.parseInt(idCate));
      request.setAttribute("productById",productlistCate ); 
        
        //product-detail
       
        
        RequestDispatcher rd = request.getRequestDispatcher("/view/client/product-detail.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
