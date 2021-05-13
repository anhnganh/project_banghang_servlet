/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Review;

/**
 *
 * @author dochu
 */
public interface ReviewService {
    void insert(Review review);

	void edit(Review review);

	void delete(int id);

	Review get(int id);
	
	Review get(String name);

        List<Review> getAll();
	
	List<Review> getReviewById(int id);
}
