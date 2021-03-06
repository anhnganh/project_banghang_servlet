/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import dao.AdminLoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;

/**
 *
 * @author dochu
 */
@WebServlet(name = "AdminLoginController", urlPatterns = {"/admin/login"})
public class AdminLoginController extends HttpServlet {

    public AdminLoginController() {
        super();
    }
    
    private static final long serialVersionUID = 1L;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminLoginController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminLoginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/login.jsp");
        rd.forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String username = request.getParameter("admin-username");
       String password = request.getParameter("admin-password");
        Admin admin = new Admin();
        admin.setName(request.getParameter("name"));
       if(AdminLoginDao.CheckAdminLogin(username, password)){
           HttpSession session = request.getSession();
           session.setAttribute("admin-username", username);
           session.setAttribute("admin-password", password);
           response.sendRedirect(request.getContextPath()+ "/admin/homepage");
       }else{
           request.setAttribute("errorMessage", "T??i kho???n ????ng nh???p ho???c m???t kh???u sai!!!");
           RequestDispatcher rd = request.getRequestDispatcher("/view/admin/login.jsp");
        rd.forward(request, response);
       }
        
       
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
