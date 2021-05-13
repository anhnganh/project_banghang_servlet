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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Catalog;
import model.Product;
import service.BoardnewService;
import service.CategoryService;
import service.ProductService;
import service.impl.BoardnewServicesImpl;
import service.impl.CategoryServicesImpl;
import service.impl.ProductServiceImpl;

/**
 *
 * @author dochu
 */
@WebServlet(name = "ProductListClientController", urlPatterns = {"/product"})
public class ProductListClientController extends HttpServlet {
        ProductService productService = new ProductServiceImpl();
        BoardnewService boardnewService = new BoardnewServicesImpl();
        CategoryService categoryService  = new CategoryServicesImpl();
        DecimalFormat df  = new DecimalFormat("#.000");
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Catalog> cateList = categoryService.getAll();
        request.setAttribute("cateList", cateList);
        List<Product> productList = productService.getAll();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("/view/client/product.jsp").forward(request, response);
        
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
