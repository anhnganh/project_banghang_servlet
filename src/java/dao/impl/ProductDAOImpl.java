/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ProductDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import model.Product;

/**
 *
 * @author dochu
 */
public class ProductDAOImpl extends DBContext implements ProductDAO{

    @Override
    public void insert(Product product) {
        String sql="INSERT INTO product(catalog_id,name,price,status, description,content,discount,image_link,created) VALUES (?,?,?,?,?,?,?,?,?)";
         DBContext db = new DBContext();
         Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getCatalog_id());
            ps.setString(2, product.getName());
            ps.setString(3, product.getPrice());
            ps.setString(4, product.getStatus());
            ps.setString(5, product.getDescription());
            ps.setString(6, product.getContent());
            ps.setString(7, product.getDiscount());
            ps.setString(8, product.getImage_link());
            ps.setString(9, product.getCreated());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Product product) {
      String sql ="UPDATE product SET catalog_id=?, name=?,price=?, status=? , description=? ,content=? ,discount=? ,image_link=? ,created=? where id =? ";
       DBContext db = new DBContext();
         Connection conn = db.getConnection();
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getCatalog_id());
            ps.setString(2, product.getName());
            ps.setString(3, product.getPrice());
            ps.setString(4, product.getStatus());
            ps.setString(5, product.getDescription());
            ps.setString(6, product.getContent());
            ps.setString(7, product.getDiscount());
            ps.setString(8, product.getImage_link());
            ps.setString(9, product.getCreated());
            ps.setString(10,product.getId() );
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql="DELETE FROM product where id=?";
        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public Product get(int id) {
        String sql ="SELECT*FROM product WHERE id=?";
        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Product product  = new Product();
                product.setId(rs.getString("id"));
                product.setCatalog_id(rs.getString("catalog_id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getString("price"));
                product.setStatus(rs.getString("status"));
                product.setDescription(rs.getString("description"));
                product.setContent(rs.getString("content"));
                product.setDiscount(rs.getString("discount"));
                product.setImage_link(rs.getString("image_link"));
                product.setCreated(rs.getString("created"));
                return product;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product get(String name) {
       return null;
        
    }

    @Override
    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String sql ="SELECT*FROM product";
         DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Product product  = new Product();
                product.setId(rs.getString("id"));
                product.setCatalog_id(rs.getString("catalog_id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getString("price"));
                product.setStatus(rs.getString("status"));
                product.setDescription(rs.getString("description"));
                product.setContent(rs.getString("content"));
                product.setDiscount(rs.getString("discount"));
                product.setImage_link(rs.getString("image_link"));
                product.setCreated(rs.getString("created"));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> getProductById(int id) {
        List<Product> list = new ArrayList<>();
        String sql ="SELECT*FROM product WHERE catalog_id=?";
         DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Product product  = new Product();
                product.setId(rs.getString("id"));
                product.setCatalog_id(rs.getString("catalog_id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getString("price"));
                product.setStatus(rs.getString("status"));
                product.setDescription(rs.getString("description"));
                product.setContent(rs.getString("content"));
                product.setDiscount(rs.getString("discount"));
                product.setImage_link(rs.getString("image_link"));
                product.setCreated(rs.getString("created"));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }

    @Override
    public List<Product> search(String productName) {
         List<Product> list = new ArrayList<>();
        String sql ="SELECT*FROM product WHERE name like ?";
         DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+productName+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 Product product  = new Product();
                product.setId(rs.getString("id"));
                product.setCatalog_id(rs.getString("catalog_id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getString("price"));
                product.setStatus(rs.getString("status"));
                product.setDescription(rs.getString("description"));
                product.setContent(rs.getString("content"));
                product.setDiscount(rs.getString("discount"));
                product.setImage_link(rs.getString("image_link"));
                product.setCreated(rs.getString("created"));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        ProductDAO pd = new ProductDAOImpl();
        List<Product> list = pd.search("rau");
       for(Product p1:list){
            System.out.println(p1);
       }
       
        
    }
}
