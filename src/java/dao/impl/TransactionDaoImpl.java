/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.TransactionDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import model.Transactions;

/**
 *
 * @author dochu
 */
public class TransactionDaoImpl extends DBContext implements TransactionDao{

    @Override
    public void insert(Transactions transaction) {
        String sql = "INSERT INTO transactions(user_session,user_name,user_mail,user_phone,address,message,amount,payment,created) VALUES (?,?,?,?,?,?,?,?,?) ";
        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, transaction.getUser_session());
            ps.setString(2, transaction.getUser_name());
            ps.setString(3, transaction.getUser_email());
            ps.setString(4, transaction.getUser_phone());
            ps.setString(5, transaction.getAddress());
            ps.setString(6, transaction.getMessage());
            ps.setString(7, transaction.getAmount());
            ps.setString(8, transaction.getPayment());
            ps.setString(9, transaction.getCreated());
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
            
    }

    @Override
    public void edit(Transactions transaction) {
       String sql = "update transactions set user_name =?, user_mail =?, user_phone =?, address= ?,message=?,amount=?, payment=?, status=? where id=? ";
        DBContext db = new DBContext();
        Connection conn = db.getConnection();
        try {
             PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, transaction.getUser_name());
            ps.setString(2, transaction.getUser_email());
            ps.setString(3, transaction.getUser_phone());
            ps.setString(4, transaction.getAddress());
            ps.setString(5, transaction.getMessage());
            ps.setString(6, transaction.getAmount());
            ps.setInt(7, Integer.parseInt(transaction.getPayment()));
            ps.setString(8, transaction.getCreated());
            ps.setInt(9,transaction.getId());
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
       String sql ="delete from transactions where id=? ";
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
    public Transactions get(int id) {
       String sql = "select*from transactions where id=?";
        DBContext db = new DBContext();
       Connection conn = db.getConnection();
        try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setInt(1, id);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 Transactions transaction = new Transactions();
                transaction.setId(rs.getInt("id"));
		transaction.setUser_session(rs.getString("user_session"));
		transaction.setUser_name(rs.getString("user_name"));
		transaction.setUser_email(rs.getString("user_mail"));
		transaction.setUser_phone(rs.getString("user_phone"));
		transaction.setAddress(rs.getString("address"));
		transaction.setMessage(rs.getString("message"));
		transaction.setAmount(rs.getString("amount"));
		transaction.setPayment(rs.getString("payment"));
		transaction.setCreated(rs.getString("created"));
		return transaction;
             }
        } catch (Exception e) {
        e.printStackTrace();
        }
        return null;
    }

    @Override
    public Transactions get(String name) {
       return null;
    }

    @Override
    public List<Transactions> getAll() {
        List<Transactions> list = new ArrayList<>();
        String sql = "select*from transactions";
         DBContext db = new DBContext();
       Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 Transactions transaction = new Transactions();
                transaction.setId(rs.getInt("id"));
		transaction.setUser_session(rs.getString("user_session"));
		transaction.setUser_name(rs.getString("user_name"));
		transaction.setUser_email(rs.getString("user_mail"));
		transaction.setUser_phone(rs.getString("user_phone"));
		transaction.setAddress(rs.getString("address"));
		transaction.setMessage(rs.getString("message"));
		transaction.setAmount(rs.getString("amount"));
		transaction.setPayment(rs.getString("payment"));
		transaction.setCreated(rs.getString("created"));
                list.add(transaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
