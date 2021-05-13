/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Admin;

/**
 *
 * @author dochu
 */
public interface AdminDao {
    
    void insert(Admin admin);
    
    void delete(String id);
    
    void edit(Admin admin);
    
    Admin get(int id);
    
    Admin get(String id);
    
    List<Admin> getAll();
    
}
