/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Item;
import model.Order;

/**
 *
 * @author dochu
 */
@WebServlet(name = "UpdateCartController", urlPatterns = {"/cart-update"})
public class UpdateCartController extends HttpServlet {
    
    DecimalFormat df = new DecimalFormat();
    private static final long serialVersionUID = 1L;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() + "/cart");
		dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession();
		Order order = (Order) session.getAttribute("order");
		List<Item> listItems = order.getItems();
		order.setSumPrice(0);
		for(Item item: listItems)
		{
			item.setQty(Integer.parseInt(request.getParameter(item.getProduct().getId())));
			item.setPrice((Double.parseDouble(item.getProduct().getPrice()) - Double.parseDouble(item.getProduct().getPrice())*(Double.parseDouble(item.getProduct().getDiscount())/100))*Double.parseDouble(request.getParameter(item.getProduct().getId())));
			order.setSumPrice(order.getSumPrice() + item.getPrice());
		}
		order.setItems(listItems);
		session.setAttribute("order", order);
		session.setAttribute("sumprice", df.format(order.getSumPrice()));
		response.sendRedirect(request.getContextPath() + "/cart");
   
    }

  

}
