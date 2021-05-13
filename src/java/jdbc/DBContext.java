
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP OMEN 15T
 */
public class DBContext {
    private static Connection conn;
    
    public Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=webbanhang";
            String user="sa";
            String password="123456";
            conn=DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi roi do "  + e.getMessage() );
        }
        return conn;
    }
    public static void main(String[] args) {
       DBContext db = new DBContext();
        Connection conn = db.getConnection();
        System.out.println(conn);
    }
}
