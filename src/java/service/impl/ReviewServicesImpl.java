/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.ReviewDao;
import dao.impl.ReviewDaoImpl;
import java.util.List;
import model.Review;
import service.ReviewService;

/**
 *
 * @author dochu
 */
public class ReviewServicesImpl implements ReviewService{
    
    ReviewDao reviewDao = new ReviewDaoImpl();
    @Override
    public void insert(Review review) {
         //To change body of generated methods, choose Tools | Templates.
         reviewDao.insert(review);
    }

    @Override
    public void edit(Review review) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
       //To change body of generated methods, choose Tools | Templates.
       reviewDao.delete(id);
    }

    @Override
    public Review get(int id) {
        //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    @Override
    public Review get(String name) {
         //To change body of generated methods, choose Tools | Templates.
         return null;
    }

    @Override
    public List<Review> getAll() {
        //To change body of generated methods, choose Tools | Templates.
        return reviewDao.getAll();
    }

    @Override
    public List<Review> getReviewById(int id) {
        //To change body of generated methods, choose Tools | Templates.
        return reviewDao.getReviewById(id);
    }
    
}
