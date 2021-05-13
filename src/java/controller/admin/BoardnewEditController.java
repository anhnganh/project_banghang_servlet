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
@WebServlet(name = "BoardnewEditController", urlPatterns = {"/admin/new/edit"})
public class BoardnewEditController extends HttpServlet {
    
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
            out.println("<title>Servlet BoardnewEditController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BoardnewEditController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Boardnew boardnew = boardnewService.get(Integer.parseInt(id));
        request.setAttribute("boardnew", boardnew);
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/editboarnew.jsp");
        rd.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Boardnew boardnew  = new Boardnew();
        boardnew.setId(request.getParameter("new-id"));
        boardnew.setTitle(request.getParameter("new-title"));
         boardnew.setContent(request.getParameter("new-content"));
         boardnew.setImage_link(request.getParameter("new-image_link"));
         boardnew.setAuthor(request.getParameter("new-author"));
         boardnew.setCreated(request.getParameter("new-created"));
         boardnewService.edit(boardnew);
         response.sendRedirect(request.getContextPath()+"/admin/new/list");
         
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
