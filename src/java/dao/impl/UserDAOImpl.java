/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.UserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import model.User;

/**
 *
 * @author dochu
 */
public class UserDAOImpl extends DBContext implements UserDAO{

    @Override
    public void insert(User user) {
      String sql = "INSERT INTO users(name,email,phone,username,password,created) VALUES (?,?,?,?,?,?) ";
      DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, user.getName());
             ps.setString(2, user.getEmail());
             ps.setString(3, user.getPhone());
             ps.setString(4, user.getUsername());
             ps.setString(5, user.getPassword());
           
             ps.executeQuery();
             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(User user) {
        String sql = "UPDATE users SET name=?,email=?, phone=?,username=?, password=? where id =? ";
          DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, user.getName());
             ps.setString(2, user.getEmail());
             ps.setString(3, user.getPhone());
             ps.setString(4, user.getUsername());
             ps.setString(5, user.getPassword());
            
             ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id=?";
       DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User get(String name) {
       return null;
    }

    @Override
    public User get(int id) {
        User user = new User();
        String sql = "SELECT * FROM users WHERE id=?";
          DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
              
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
       List<User> list = new ArrayList<User>();
       String sql = "select*from users";
        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return list;
    }
    
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();
        List<User> list = userDAO.getAll();
        for(User u:list){
            System.out.println(u);
        }
    }
    
}
