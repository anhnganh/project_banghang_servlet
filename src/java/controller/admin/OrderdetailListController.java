/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Order;
import model.Ordered;
import model.Product;
import service.OrderedService;
import service.ProductService;
import service.impl.OrderedServiceImpl;
import service.impl.ProductServiceImpl;

/**
 *
 * @author dochu
 */
@WebServlet(name = "OrderdetailListController", urlPatterns = {"/admin/order/list-detail"})
public class OrderdetailListController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    ProductService productService = new ProductServiceImpl();
    OrderedService orderedService = new OrderedServiceImpl();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderdetailListController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderdetailListController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
       
        List<Ordered> orderedList = orderedService.getAll();
        request.setAttribute("orderedlist", orderedList);
        List<Product> products = new ArrayList<>();
        for(Ordered ordered: orderedList ){
            Product product = new Product();
            product=productService.get(Integer.parseInt(ordered.getProduct_id()));
            products.add(product);
            
        } 
        request.setAttribute("products", products);
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/show-orderdetail.jsp");
        rd.forward(request, response);
        
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
