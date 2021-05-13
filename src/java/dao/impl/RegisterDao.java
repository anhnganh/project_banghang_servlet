/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import jdbc.DBContext;
import model.User;

/**
 *
 * @author dochu
 */
public class RegisterDao {
    DBContext db = new  DBContext();
    Connection conn = db.getConnection();

    public boolean RegisterUser(User user){
        boolean set = false;
        try {
            String sql = "INSERT INTO users(name,email,phone,username,password) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, user.getName());
             ps.setString(2, user.getEmail());
             ps.setString(3, user.getPhone());
             ps.setString(4, user.getUsername());
             ps.setString(5, user.getPassword());
            
             ps.executeQuery();
             set=true;
        } catch (Exception e) {
        }
        return set;
    }
    public static void main(String[] args) {
        RegisterDao dao = new RegisterDao();
        User user = new User("as12", "das", "dasd", "dsad", "dasd", "2020-12-12");
        
        dao.RegisterUser(user);
        System.out.println(user);
    }
    
}
