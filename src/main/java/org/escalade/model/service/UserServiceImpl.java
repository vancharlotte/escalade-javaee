package org.escalade.model.service;


import org.escalade.model.dao.UserDao;
import org.escalade.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User save(User user) {
        userDao.save(user);
        return user;
    }

    @Override
    public User update(User user) {
        userDao.update(user);
        return user;
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public User existUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User existEmail(String email) {
        return userDao.findByEmail(email);

    }


    @Override
    public void deleteById(int id) {
        userDao.findById(id);
    }

    public List<User> list() {
        return userDao.list();
    }

}