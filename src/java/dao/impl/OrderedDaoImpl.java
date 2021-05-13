/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.OrderedDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import model.Ordered;

/**
 *
 * @author dochu
 */
public class OrderedDaoImpl extends DBContext implements OrderedDao{

    @Override
    public void insert(Ordered ordered) {
       String sql ="INSERT INTO ordered(product_id, transaction_id,qty) VALUES (?, ?, ?) ";
       DBContext db = new DBContext();
         Connection conn = db.getConnection();
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setInt(1,Integer.parseInt( ordered.getProduct_id()));
             ps.setInt(2, Integer.parseInt(ordered.getTransaction_id()));
              ps.setInt(3 ,ordered.getQty());
              ps.executeUpdate();
         } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Ordered ordered) {
      //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ordered get(int id) {
       return null;
    }

    @Override
    public Ordered get(String name) {
    return null;
    }
    @Override
    public List<Ordered> getAll() {
        List<Ordered> list = new ArrayList<>();
        String sql = "select*from ordered";
         DBContext db = new DBContext();
         Connection conn = db.getConnection();
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                Ordered ordered = new Ordered();
                ordered.setId(rs.getString("id"));
		ordered.setProduct_id(rs.getString("product_id"));
		ordered.setTransaction_id(rs.getString("transaction_id"));
		ordered.setQty(Integer.parseInt(rs.getString("qty")));
		list.add(ordered);
             }
        } catch (Exception e) {
        e.printStackTrace();
        }
        return list;
    }
    
}
