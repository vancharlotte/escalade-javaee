package org.escalade.model.dao;

import org.escalade.model.entity.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    void update(User user);
    List<User> list();
    User findById(int id);
    User findByUsername(String username);
    void delete(User user);
    List<User> searchByUsername(String username);

}
