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
import model.Boardnew;
import model.Product;
import service.BoardnewService;
import service.ProductService;
import service.impl.BoardnewServicesImpl;
import service.impl.ProductServiceImpl;

/**
 *
 * @author dochu
 */
@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ProductService productService = new ProductServiceImpl();
        BoardnewService boardnewService = new BoardnewServicesImpl();
         DecimalFormat df  = new DecimalFormat("#.000");
  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Boardnew> boardnewsList = boardnewService.getAll();
        request.setAttribute("boardnewsList", boardnewsList);
        //product rau cu qua
        List<Product> products_raucu = productService.getProductById(1);
        request.setAttribute("products_raucu", products_raucu);
      
        // product hat
        List<Product> products_hat = productService.getProductById(2);
        request.setAttribute("products_hat", products_hat);
        // product traicay
        List<Product> products_traicay = productService.getProductById(3);
        request.setAttribute("products_traicay",  products_traicay);
        // product mat ong
         List<Product> products_matong = productService.getProductById(4);
        request.setAttribute("products_matong",  products_matong);
        // product moi
         List<Product> products_new = productService.getProductById(5);
        request.setAttribute("products_new", products_new);
        // product ban chay
         List<Product> products_banchay = productService.getProductById(6);
        request.setAttribute("products_banchay",  products_banchay);
        // all product
       List<Product> productList = productService.getAll();
		request.setAttribute("productlist", productList);	
		//Giá giảm
		List<Product> productsList1 = new ArrayList<Product>();
		request.setAttribute("productlist1", productsList1);
        // giam gia
        List<Product> products_sale = productService.getProductById(7);
        request.setAttribute("products_sale",  products_sale);
        request.getRequestDispatcher("/view/client/index.jsp").forward(request, response);
        
    }

  
    
}
    
