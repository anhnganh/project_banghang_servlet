/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Catalog;
import service.CategoryService;
import service.impl.CategoryServicesImpl;

/**
 *
 * @author dochu
 */
@WebServlet(name = "CategoryAddController", urlPatterns = {"/admin/cate/add"})
public class CategoryAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    CategoryService categoryService = new CategoryServicesImpl();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CategoryAddController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CategoryAddController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/addcate.jsp");
        rd.forward(request, response);
                
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String cate_name = request.getParameter("cate-name");
        String cate_parent_id = request.getParameter("parent-id");
        Catalog catalog = new Catalog();
        catalog.setName(cate_name);
        catalog.setParent_id(cate_parent_id);
        categoryService.insert(catalog);
        
      response.sendRedirect(request.getContextPath() + "/admin/cate/list");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
