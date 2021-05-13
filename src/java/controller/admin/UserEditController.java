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
import model.User;
import service.UserService;
import service.impl.UserServicesImpl;

/**
 *
 * @author dochu
 */
@WebServlet(name = "UserEditController", urlPatterns = {"/admin/user/edit"})
public class UserEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
  UserService userService = new UserServicesImpl();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserEditController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserEditController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int user_id = Integer.parseInt(request.getParameter("user-id"));
           User user = userService.get(user_id);
           request.setAttribute("user", user);
           RequestDispatcher rd = request.getRequestDispatcher("/view/admin/edituser.jsp");
           rd.forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int user_id = Integer.parseInt(request.getParameter("user_id"));
       String user_name = request.getParameter("user_name");
       String user_email = request.getParameter("user_email");
       String user_phone = request.getParameter("user_phone");
       String user_username = request.getParameter("user_username");
       String user_password = request.getParameter("user_password");
       User user = new User();
       user.setId(user_id);
       user.setName(user_name);
       user.setEmail(user_email);
       user.setPhone(user_phone);
       user.setUsername(user_name);
       user.setPassword(user_password);
       userService.edit(user);
       response.sendRedirect(request.getContextPath()+"/admin/user/list");
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
