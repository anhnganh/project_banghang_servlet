/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Review;
import service.ReviewService;
import service.impl.ReviewServicesImpl;

/**
 *
 * @author dochu
 */
@WebServlet(name = "ReviewClientController", urlPatterns = {"/review"})
public class ReviewClientController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    ReviewService reviewService = new ReviewServicesImpl();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        RequestDispatcher rd = request.getRequestDispatcher(request.getContentType()+"/product-detail?id=" + request.getParameter("id"));
        rd.forward(request, response);
    }

   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
   
        String id = request.getParameter("id");
        System.out.println("thử:" + id);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String content = request.getParameter("content");
        long millis=System.currentTimeMillis();  
	java.sql.Date date=new java.sql.Date(millis);  
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	String today = df.format(date);
        Review review = new Review();
        review.setName(name);
        review.setEmail(email);
        review.setProduct_id(id);
        review.setConcent(content);
        review.setCreated(content);
        System.out.println("thử toString"+ review);
        reviewService.insert(review);
        response.sendRedirect(request.getContextPath()+ "/product-detail?id=" + id );
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
