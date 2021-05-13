/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Admin;

/**
 *
 * @author dochu
 */
public interface AdminService {
    void insert(Admin admin); 
 
	void edit(Admin admin); 

	void delete(String id); 
 
	Admin get(int id); 
	 
	Admin get(String name); 
 
	   List<Admin> getAll(); 
}
