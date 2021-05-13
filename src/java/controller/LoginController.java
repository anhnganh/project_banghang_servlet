/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author dochu
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
       
        
         
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       RequestDispatcher rd = request.getRequestDispatcher("/view/client/login.jsp");
       rd.forward(request, response);
          
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        LoginDao loginDao = new LoginDao();
        try {
            User u = loginDao.checkLogin(username, password);
            if(u !=null){
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                response.sendRedirect(request.getContextPath() + "/");
            }else{
                request.setAttribute("errorMsg", "Tài khoản đăng nhập hoặc mật khẩu sai!");
                RequestDispatcher rd = request.getRequestDispatcher("/view/client/login.jsp");
                rd.forward(request, response);
                       
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
