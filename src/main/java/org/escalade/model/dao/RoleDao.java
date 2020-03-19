package org.escalade.model.dao;

import org.escalade.model.entity.Role;

import java.util.List;

public interface RoleDao {

    void save(Role role);
    void update(Role role);
    List<Role> list();
    Role findById(int id);
    void delete(Role role);
}
