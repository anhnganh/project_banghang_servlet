/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.BoardnewDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import model.Boardnew;

/**
 *
 * @author dochu
 */
public class BoardnewDaoImpl extends DBContext implements BoardnewDao{

    @Override
    public void insert(Boardnew boardnew) {
       String sql ="INSERT INTO boardnew(title, content,image_link, author, created) VALUES (?, ?, ?, ?, ?)";
       DBContext db = new DBContext();
       Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,boardnew.getTitle());
            ps.setString(2, boardnew.getContent());
            ps.setString(3,boardnew.getImage_link());
            ps.setString(4,boardnew.getAuthor());
            ps.setString(5,boardnew.getCreated());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Boardnew boardnew) {
       String sql = "update boardnew set title=?,content=?,image_link=?,author=?,created=? WHERE id=? ";
       DBContext db = new DBContext();
       Connection conn = db.getConnection();
        try {
             PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,boardnew.getTitle());
            ps.setString(2, boardnew.getContent());
            ps.setString(3,boardnew.getImage_link());
            ps.setString(4,boardnew.getAuthor());
            ps.setString(5,boardnew.getCreated());
             ps.setString(6,boardnew.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

    @Override
    public void delete(int id) {
       String sql ="DELETE FROM boardnew WHERE id =? ";
       DBContext db = new DBContext();
       Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boardnew get(int id) {
        String sql = "select*from boardnew where id=? ";
        DBContext db = new DBContext();
       Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Boardnew boardnew = new Boardnew();
                
		boardnew.setId(rs.getString("id"));
		boardnew.setTitle(rs.getString("title"));
		boardnew.setContent(rs.getString("content"));
		boardnew.setImage_link(rs.getString("image_link"));
		boardnew.setAuthor(rs.getString("author"));
		boardnew.setCreated(rs.getString("created"));
		return boardnew;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public Boardnew get(String name) {
       return null;
    }

    @Override
    public List<Boardnew> getAll() {
      List<Boardnew> list = new ArrayList<>();
      String sql="select*from boardnew";
       DBContext db = new DBContext();
       Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Boardnew boardnew = new Boardnew();
                
		boardnew.setId(rs.getString("id"));
		boardnew.setTitle(rs.getString("title"));
		boardnew.setContent(rs.getString("content"));
		boardnew.setImage_link(rs.getString("image_link"));
		boardnew.setAuthor(rs.getString("author"));
		boardnew.setCreated(rs.getString("created"));
                list.add(boardnew);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      
       return list; 
    }
    
}
