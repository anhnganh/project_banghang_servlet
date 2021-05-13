/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import java.util.List;
import model.User;
import service.UserService;

/**
 *
 * @author dochu
 */
public class UserServicesImpl implements UserService{
    UserDAO userDAO = new UserDAOImpl();
    @Override
    public void insert(User user) {
      //To change body of generated methods, choose Tools | Templates.
      userDAO.insert(user);
    }

    @Override
    public void edit(User newUser) {
        User oldUser = userDAO.get(newUser.getId());
        oldUser.setName(newUser.getName());
          oldUser.setEmail(newUser.getEmail());
            oldUser.setPhone(newUser.getPhone());
              oldUser.setUsername(newUser.getUsername());
                oldUser.setPassword(newUser.getPassword());
                  oldUser.setCreated(newUser.getCreated());
        userDAO.edit(oldUser);
    }

    @Override
    public void delete(int id) {
        //To change body of generated methods, choose Tools | Templates.
        userDAO.delete(id);
    }

    @Override
    public User get(int id) {
      return userDAO.get(id);   //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User get(String name) {
        return userDAO.get(name); ///To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAll() {
       return userDAO.getAll(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
