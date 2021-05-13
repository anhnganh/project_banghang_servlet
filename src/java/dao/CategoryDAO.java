/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Catalog;

/**
 *
 * @author dochu
 */
public interface CategoryDAO {
    
    void insert(Catalog category);
    
    void update(Catalog category);
    
    void delete(String  id);
    
    Catalog get(int id);
    
    Catalog get(String name);
    
    List<Catalog> getAll();
    
    List<Catalog> getCateByProduct(int id);
    
}
