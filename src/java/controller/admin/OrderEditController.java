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
import model.Transactions;
import service.TransactionService;
import service.impl.TransactionServicesImpl;

/**
 *
 * @author dochu
 */
@WebServlet(name = "OrderEditController", urlPatterns = {"/admin/order/edit"})
public class OrderEditController extends HttpServlet {

    private static final long serialVersionUID = 1L;    
    TransactionService transactionService = new TransactionServicesImpl();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderEditController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderEditController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String id = request.getParameter("id");
        Transactions transactions = transactionService.get(Integer.parseInt(id));
       request.setAttribute("order", transactions);
        RequestDispatcher rd = request.getRequestDispatcher("/view/admin/editorder.jsp");
       rd.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Transactions transactions = new Transactions();
        transactions.setId(Integer.parseInt(request.getParameter("order-id")));
         transactions.setUser_name(request.getParameter("order-name"));
         transactions.setUser_email(request.getParameter("order-mail"));
         transactions.setUser_phone(request.getParameter("order-phone"));
         transactions.setAddress(request.getParameter("order-address"));
          transactions.setMessage(request.getParameter("order-mess"));
           transactions.setAmount(request.getParameter("order-amount"));
           transactions.setPayment(request.getParameter("order-payment"));
            transactions.setStatus(request.getParameter("order-status"));
           transactionService.edit(transactions);
           response.sendRedirect(request.getContextPath()+"/admin/order/list");
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
