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
import model.Boardnew;
import service.BoardnewService;
import service.impl.BoardnewServicesImpl;

/**
 *
 * @author dochu
 */
@WebServlet(name = "BoardnewAddController", urlPatterns = {"/admin/new/add"})
public class BoardnewAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    BoardnewService boardnewService = new BoardnewServicesImpl();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BoardnewAddController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BoardnewAddController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/addboardnew.jsp");
        rd.forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String new_title = request.getParameter("new-title");
        String new_content = request.getParameter("new-content");
        String new_image_link = request.getParameter("new-image_link");
        String new_author = request.getParameter("new-author");
        String new_created = request.getParameter("new-created");
        Boardnew boardnew = new Boardnew();
        boardnew.setTitle(new_title);
        boardnew.setContent(new_content);
        boardnew.setImage_link(new_image_link);
        boardnew.setAuthor(new_author);
        boardnew.setCreated(new_created);
        boardnewService.insert(boardnew);
        response.sendRedirect(request.getContextPath()+"/admin/new/list");
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
