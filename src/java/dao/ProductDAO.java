/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Product;

/**
 *
 * @author dochu
 */
public interface ProductDAO {
    void insert(Product product);
    void edit(Product product);
    void delete(String id);
    Product get(int id);
    Product get(String name);
    List<Product> getAll();
    List<Product> getProductById(int id);
    List<Product> search(String productName);
    
}
