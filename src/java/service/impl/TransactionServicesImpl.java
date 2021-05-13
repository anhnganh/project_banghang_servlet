/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.TransactionDao;
import dao.impl.TransactionDaoImpl;
import java.util.List;
import model.Transactions;
import service.TransactionService;

/**
 *
 * @author dochu
 */
public class TransactionServicesImpl implements TransactionService{
    TransactionDao transactionDao = new TransactionDaoImpl();
            
    @Override
    public void insert(Transactions transaction) {
        transactionDao.insert(transaction);
    }

    @Override
    public void edit(Transactions transaction) {
        Transactions oldTransactions =transactionDao.get(transaction.getId());
        oldTransactions.setUser_name(transaction.getUser_name());
         oldTransactions.setUser_email(transaction.getUser_email());
         oldTransactions.setUser_phone(transaction.getUser_phone());
         oldTransactions.setAddress(transaction.getAddress());
         oldTransactions.setMessage(transaction.getMessage());
         oldTransactions.setAmount(transaction.getAmount());
         oldTransactions.setPayment(transaction.getPayment());
         oldTransactions.setStatus(transaction.getStatus());
         transactionDao.edit(transaction);
    }

    @Override
    public void delete(String id) {
         //To change body of generated methods, choose Tools | Templates.
         transactionDao.delete(id);
    }

    @Override
    public Transactions get(int id) {
        //To change body of generated methods, choose Tools | Templates.
      return  transactionDao.get(id);
        }

    @Override
    public Transactions get(String name) {
        //To change body of generated methods, choose Tools | Templates.
        return transactionDao.get(name);
    }

    @Override
    public List<Transactions> getAll() {
        //To change body of generated methods, choose Tools | Templates.
        return transactionDao.getAll();
    }
    
}
