/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import model.Ordered;
import model.Transactions;
import service.OrderedService;
import service.TransactionService;
import service.impl.OrderedServiceImpl;
import service.impl.TransactionServicesImpl;

/**
 *
 * @author dochu
 */
@WebServlet(name = "TransactionController", urlPatterns = {"/transaction"})
public class TransactionController extends HttpServlet {

    TransactionService transactionService = new TransactionServicesImpl();
    OrderedService orderedService = new OrderedServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/checkout.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String tr_usersession = req.getParameter("transaction_usersession");
        String tr_username = req.getParameter("transaction_name");
        String tr_usermail = req.getParameter("transaction_email");
        String tr_userphone = req.getParameter("transaction_phone");
        String tr_useraddress = req.getParameter("transaction_address");
        String tr_usermess = req.getParameter("transaction_mess");
        String tr_amount = req.getParameter("transaction_amount");
        String tr_payment = req.getParameter("transaction_payment");
        String tr_created = req.getParameter("transaction_created");

        Transactions transaction = new Transactions();
        transaction.setUser_session(tr_usersession);
        transaction.setUser_name(tr_username);
        transaction.setUser_email(tr_usermail);
        transaction.setUser_phone(tr_userphone);
        transaction.setAddress(tr_useraddress);
        transaction.setMessage(tr_usermess);
        transaction.setAmount(tr_amount);
        transaction.setPayment(tr_payment);
        transaction.setCreated(tr_created);

        transactionService.insert(transaction);

        int maxid = 0;
        List<Transactions> transactions = transactionService.getAll();
        if (transactions.size() == 0) {
            maxid = 0;
        } else {
            for (Transactions transactions2 : transactions) {
                if (transactions2.getId() >= maxid) {
                    maxid = transactions2.getId();
                }
            }
        }
        HttpSession session = req.getSession(true);
        Order order = (Order) session.getAttribute("order");
        List<Item> listItems = order.getItems();
        for (Item item : listItems) {
            Ordered ordered = new Ordered();
            ordered.setProduct_id(item.getProduct().getId());
            ordered.setQty(item.getQty());
            ordered.setTransaction_id(String.valueOf(maxid));
            orderedService.insert(ordered);
        }
        if (session != null) {
            session.removeAttribute("order"); //remove session
            session.removeAttribute("sumprice"); //remove session
            session.removeAttribute("length_order"); //remove session
        }
        resp.sendRedirect(req.getContextPath() + "/checkout");

    }

}
