/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.CategoryDAO;
import dao.impl.CategoryDAOImpl;
import java.util.List;
import model.Catalog;
import service.CategoryService;

/**
 *
 * @author dochu
 */
public class CategoryServicesImpl implements CategoryService{
    CategoryDAO categoryDAO = new CategoryDAOImpl();
        
    @Override
    public void insert(Catalog category) {
       categoryDAO.insert(category);
    }

    @Override
    public void edit(Catalog newCategory) {
       Catalog oldCatalog = categoryDAO.get(newCategory.getId());
       oldCatalog.setName(newCategory.getName());
       oldCatalog.setParent_id(newCategory.getParent_id());
       categoryDAO.update(newCategory);
       
    }

    @Override
    public Catalog get(int id) {
       return categoryDAO.get(id);
    }

    @Override
    public Catalog get(String name) {
       return categoryDAO.get(name);
    }

    @Override
    public List<Catalog> getAll() {
     return categoryDAO.getAll();
    }

    @Override
    public void delete(String id) {
        categoryDAO.delete(id);
    }

    @Override
    public List<Catalog> getCateByProduct(int id) {
       return categoryDAO.getAll();
    }
    
}
