/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Transactions;

/**
 *
 * @author dochu
 */
public interface TransactionDao {
    void insert(Transactions transaction);
    
    void edit(Transactions admin);
    
    void delete(String id);
    
    Transactions get(int id);
    
    Transactions get(String name);
    
    List<Transactions> getAll();
}
