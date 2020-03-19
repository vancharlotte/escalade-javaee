package org.escalade.model.service;

import org.escalade.model.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);
    User update(User user);
    User findById(int id);
    User existUsername(String username);
    User existEmail(String email);
    void deleteById(int id);
    List<User> list();
}
