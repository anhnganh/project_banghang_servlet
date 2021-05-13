/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.CategoryDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import model.Catalog;

/**
 *
 * @author dochu
 */
public class CategoryDAOImpl extends DBContext implements CategoryDAO{

    @Override
    public void insert(Catalog category) {
      String sql="INSERT INTO catalog(name, parent_id) VALUES (?,?) ";
       DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setString(2, category.getParent_id());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void update(Catalog category) {
       String sql = "UPDATE catalog INTO name=?,parent_id=? WHERE id=? ";
        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setString(2, category.getParent_id());
            ps.setInt(3, category.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        System.out.println("id"+id);
       String sql ="DELETE FROM catalog WHERE id=?";
       DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Catalog get(int id) {
        String sql = "select*from catalog where id=?";
        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Catalog ca = new Catalog();
                ca.setId(rs.getInt("id"));
                ca.setName(rs.getString("name"));
                ca.setParent_id(rs.getString("parent_id"));
                return ca;
                
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public Catalog get(String name) {
      return null;
    }

    @Override
    public List<Catalog> getAll() {
       List<Catalog> list = new ArrayList<>();
       String sql ="select*from catalog";
        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
             PreparedStatement ps =conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 Catalog ca = new Catalog();
                ca.setId(rs.getInt("id"));
                ca.setName(rs.getString("name"));
                ca.setParent_id(rs.getString("parent_id"));
                list.add(ca);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return list;
    }

    @Override
    public List<Catalog> getCateByProduct(int id) {
      List<Catalog> list = new ArrayList<>();
       String sql ="select catalog.name from catalog,product where catalog.id = product.catalog_id and product.id = ? ";
       DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
             PreparedStatement ps =conn.prepareStatement(sql);
             ps.setInt(1, id);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 Catalog ca = new Catalog();
                 ca.setName(rs.getString("name"));
                 list.add(ca);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return list;
    }
    
}
