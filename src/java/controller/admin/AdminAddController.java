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
import model.Admin;
import service.AdminService;
import service.impl.AdminServicesImpl;

/**
 *
 * @author dochu
 */
@WebServlet(name = "AdminAddController", urlPatterns = {"/admin/admin/add"})
public class AdminAddController extends HttpServlet {

   private static final long serialVersionUID = 1L; 
    AdminService adminService = new AdminServicesImpl();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminAddController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminAddController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/addadmin.jsp");
        rd.forward(request, response);
        
    }

    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String admin_username = request.getParameter("admin-username");
       String admin_password = request.getParameter("admin-password");
       String admin_name = request.getParameter("admin-name");
        Admin admin = new Admin();
        admin.setUsername(admin_username);
        admin.setPassword(admin_password);
        admin.setName(admin_name);
        adminService.insert(admin);
        response.sendRedirect(request.getContextPath() + "/admin/admin/list");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
