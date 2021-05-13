/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.ProductDAO;
import dao.impl.ProductDAOImpl;
import java.util.List;
import model.Product;
import service.ProductService;

/**
 *
 * @author dochu
 */
public class ProductServiceImpl implements ProductService{
    ProductDAO productDAO =new ProductDAOImpl();
    @Override
    public void insert(Product product) {
      productDAO.insert(product);
    }

    @Override
    public void edit(Product newproduct) {
       Product oldProduct = productDAO.get(Integer.parseInt(newproduct.getId()));
       oldProduct.setName(newproduct.getName());
       oldProduct.setCatalog_id(newproduct.getCatalog_id());
       oldProduct.setStatus(newproduct.getStatus());
       oldProduct.setPrice(newproduct.getPrice());
       oldProduct.setDescription(newproduct.getDescription());
       oldProduct.setContent(newproduct.getContent());
       oldProduct.setDiscount(newproduct.getDiscount());
       oldProduct.setImage_link(newproduct.getImage_link());
       oldProduct.setCreated(newproduct.getCreated());
       productDAO.edit(oldProduct);
        
    }

    @Override
    public void delete(String id) {
       productDAO.delete(id);
    }

    @Override
    public Product get(int id) {
       return productDAO.get(id);
    }

    @Override
    public Product get(String name) {
        return productDAO.get(name);
    }

    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public List<Product> getProductById(int id) {
     return productDAO.getProductById(id);
    }

    @Override
    public List<Product> searchByName(String productName) {
      return productDAO.search(productName);
    }

    @Override
    public List<Product> getProductByIdCate(int idCate) {
        return null;
    }
    public static void main(String[] args) {
     ProductService ps = new ProductServiceImpl();
       List<Product> list = ps.getAll();
       for(Product p: list){
           System.out.println(p);
       }
    }
}
