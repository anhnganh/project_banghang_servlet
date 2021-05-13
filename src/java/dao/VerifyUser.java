/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jdbc.DBContext;

/**
 *
 * @author dochu
 */
public class VerifyUser {
    public VerifyUser(String username){
        try {
            String sql = "select *from users where username=?";
             DBContext db = new DBContext();
             Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, username);
             ResultSet rs = ps.executeQuery();
             String usernameCounter;
             while(rs.next()){
                 usernameCounter = rs.getString("username");
                 if(usernameCounter.equals(username)){
                       System.out.println("Username already exists");
                 }else{
                        System.out.println("Username is available");
                 }
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
