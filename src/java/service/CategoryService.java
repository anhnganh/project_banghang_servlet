/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Catalog;

/**
 *
 * @author dochu
 */
public interface CategoryService {
    	void insert(Catalog category);

	void edit(Catalog category);

	Catalog get(int id);
	
	Catalog get(String name);

	   List<Catalog> getAll();

	void delete(String id);
	
	List<Catalog> getCateByProduct(int id);
}
