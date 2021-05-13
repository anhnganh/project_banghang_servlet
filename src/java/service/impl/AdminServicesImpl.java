/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import java.util.List;
import model.Admin;
import service.AdminService;

/**
 *
 * @author dochu
 */
public class AdminServicesImpl implements AdminService{
    AdminDao adminDao = new AdminDaoImpl();
    
    @Override
    public void insert(Admin admin) {
       adminDao.insert(admin);
    }

    @Override
    public void edit(Admin newAdmin) {
        Admin oldAdmin = adminDao.get(newAdmin.getId());
       
        oldAdmin.setUsername(newAdmin.getUsername());
        oldAdmin.setPassword(newAdmin.getPassword());
         oldAdmin.setName(newAdmin.getName());
         adminDao.edit(oldAdmin);
     }

    @Override
    public void delete(String id) {
        adminDao.delete(id);
    }

    @Override
    public Admin get(int id) {
    return adminDao.get(id);
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Admin get(String name) {
        return adminDao.get(name);
    }

    @Override
    public List<Admin> getAll() {
        return adminDao.getAll();
    }
    
    
}
