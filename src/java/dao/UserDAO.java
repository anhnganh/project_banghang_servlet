/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.User;

/**
 *
 * @author dochu
 */
public interface UserDAO {
    void insert(User user);
    
    void edit(User user);
 
    void delete(int id);
  
    User get(String name);
  
    User get(int id);
  
    List<User> getAll();
    
}
