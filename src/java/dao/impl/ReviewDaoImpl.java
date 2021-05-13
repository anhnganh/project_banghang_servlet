/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ProductDAO;
import dao.ReviewDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;
import model.Product;
import model.Review;
import service.ReviewService;
import service.impl.ReviewServicesImpl;

/**
 *
 * @author dochu
 */
public class ReviewDaoImpl extends DBContext implements ReviewDao{

    @Override
    public void insert(Review review) {
       String sql ="INSERT INTO review(product_id,  name, email, content, created) VALUES (?, ?, ?, ?, ?)";
       DBContext db = new DBContext();
       Connection conn = db.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, review.getProduct_id());
            ps.setString(2, review.getName());
            ps.setString(3, review.getEmail());
            ps.setString(4, review.getConcent());
            ps.setString(5, review.getCreated());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Review review) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(int id) {
       String sql = "delete from review where id=?";
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
    public Review get(int id) {
     return null;
    }

    @Override
    public Review get(String name) {
        return null;
    }

    @Override
    public List<Review> getAll() {
       List<Review> list = new ArrayList<>();
       String sql = "select*from review";
       DBContext db = new DBContext();
       Connection conn = db.getConnection();
        try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 Review review = new Review();
                 review.setId(rs.getString("id"));
                 review.setProduct_id(rs.getString("product_id"));
                 review.setName(rs.getString("name"));
		review.setEmail(rs.getString("email"));
		review.setConcent(rs.getString("content"));
        	review.setCreated(rs.getString("created"));
		list.add(review);
             }
        } catch (Exception e) {
        }
       return list;
    }

    @Override
    public List<Review> getReviewById(int id) {
        List<Review> list = new ArrayList<>();
       String sql = "select*from review where id=?";
       DBContext db = new DBContext();
       Connection conn = db.getConnection();
        try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setInt(1, id);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 Review review = new Review();
                 review.setId(rs.getString("id"));
                 review.setProduct_id(rs.getString("product_id"));
                 review.setName(rs.getString("name"));
		review.setEmail(rs.getString("email"));
		review.setConcent(rs.getString("content"));
        	review.setCreated(rs.getString("created"));
		list.add(review);
             }
        } catch (Exception e) {
        }
       return list;
    }
    public static void main(String[] args) {
        ReviewService pd = new ReviewServicesImpl();
        List<Review> list = pd.getAll();
        for(Review r : list){
            System.out.println(r);
        }
        
    }
}
