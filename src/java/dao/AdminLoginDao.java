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
import model.Admin;

/**
 *
 * @author dochu
 */
public class AdminLoginDao {
    public static boolean CheckAdminLogin(String username, String password){
        boolean exist =false;
        try {
            String sql ="select*from admin where username=? and password=? ";
            DBContext db = new DBContext();
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            exist = rs.next();
            Admin ad = new Admin();
            String name = rs.getString("name");
            ad.setName(name);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return exist;
    }
    
}
