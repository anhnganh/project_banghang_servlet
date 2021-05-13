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
@WebServlet(name = "CategoryEditController", urlPatterns = {"/admin/cate/edit"})
public class CategoryEditController extends HttpServlet {

   private static final long serialVersionUID = 1L;
	   CategoryService cateService = new CategoryServicesImpl();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CategoryEditController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CategoryEditController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Catalog catalog = cateService.get(Integer.parseInt(id));
        request.setAttribute("catelist", catalog);
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/editcate.jsp");
        rd.forward(request, response);
                
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Catalog catalog = new Catalog();
        catalog.setName(request.getParameter("name"));
        catalog.setParent_id(request.getParameter("parent-id"));
        catalog.setId(Integer.parseInt(request.getParameter("id")));
        cateService.edit(catalog);
        response.sendRedirect(request.getContextPath()+"/admin/cate/list");
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
