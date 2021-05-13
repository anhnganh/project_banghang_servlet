/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Boardnew;

/**
 *
 * @author dochu
 */
public interface BoardnewDao {
    
    void insert(Boardnew boardnew);
    
    void edit(Boardnew boardnew);
    
    void delete(int id);
    
    Boardnew get(int id);
    
    Boardnew get(String name);
    
    List<Boardnew> getAll();
    
}
