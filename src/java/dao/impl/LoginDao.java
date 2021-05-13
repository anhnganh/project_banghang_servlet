/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jdbc.DBContext;
import model.User;

/**
 *
 * @author dochu
 */
public class LoginDao {
    DBContext db = new DBContext();
    Connection conn = db.getConnection();
    public User checkLogin(String username, String password){
        try {
            String sql = "Select*from users where username=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User user = new User(rs.getString(1), rs.getString(2));
                return user;
            }
            
        } catch (Exception e) {
            e.printStackTrace();    
        }
        return null;
    }
    
}
