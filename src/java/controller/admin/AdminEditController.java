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
@WebServlet(name = "AdminEditController", urlPatterns = {"/admin/admin/edit"})
public class AdminEditController extends HttpServlet {
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
            out.println("<title>Servlet AdminEditController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminEditController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String id  = request.getParameter("id");
        Admin admin = adminService.get(Integer.parseInt(id));
        request.setAttribute("admin", admin);
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/editadmin.jsp");
        rd.forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         int admin_id = Integer.parseInt(request.getParameter("id"));
        String admin_username = request.getParameter("username");
        String admin_password = request.getParameter("password");
        String admin_name = request.getParameter("name");
        Admin admin = new Admin();
        admin.setId(admin_id);
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
