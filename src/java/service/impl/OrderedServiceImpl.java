/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.OrderedDao;
import dao.impl.OrderedDaoImpl;
import java.util.List;
import model.Ordered;
import service.OrderedService;

/**
 *
 * @author dochu
 */
public class OrderedServiceImpl implements OrderedService{
    OrderedDao orderedDao = new OrderedDaoImpl();
    @Override
    public void insert(Ordered ordered) {
       orderedDao.insert(ordered);
    }

    @Override
    public void edit(Ordered ordered) {
        // TODO Auto-generated method stub
    }

    @Override
    public void delete(String id) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ordered get(int id) {
       return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ordered get(String name) {
       return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ordered> getAll() {
       return orderedDao.getAll(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
