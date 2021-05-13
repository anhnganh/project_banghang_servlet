/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.AdminDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import model.Admin;

/**
 *
 * @author dochu
 */
public class AdminDaoImpl extends DBContext implements AdminDao{

    @Override
    public void insert(Admin admin) {
       String sql ="INSERT INTO admin(username,password,name) VALUES (?,?,?)";
         DBContext db = new DBContext();
         Connection conn = db.getConnection();
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, admin.getUsername()); 
            ps.setString(2, admin.getPassword()); 
	  ps.setString(3, admin.getName()); 
	  ps.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void delete(String id) {
      String sql = "Delete from admin where id=?";
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
    public void edit(Admin admin) {
        String sql = "Update admin set username =?, password =?, name =? where id=?";
         DBContext db = new DBContext();
       Connection conn = db.getConnection();
        try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, admin.getUsername()); 
            ps.setString(2, admin.getPassword()); 
	  ps.setString(3, admin.getName()); 
           ps.setInt(4, admin.getId()); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Admin get(int id) {
        String sql ="select*From admin where id=?";
        DBContext db = new DBContext();
       Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
		admin.setPassword(rs.getString("password"));
		admin.setName(rs.getString("name"));
                return admin;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Admin get(String id) {
       return null;
    }

    @Override
    public List<Admin> getAll() {
       List<Admin> list = new ArrayList<>();
        String sql ="select*from admin";
        DBContext db = new DBContext();
       Connection conn = db.getConnection();
        try {
             PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
		admin.setPassword(rs.getString("password"));
		admin.setName(rs.getString("name"));
                list.add(admin);
            }
        } catch (Exception e) {
        }
       
       return list;   
       
    }
    
}
