package org.escalade.model.dao;

import org.escalade.model.entity.Topo;
import org.escalade.model.entity.User;

import java.util.List;

public interface TopoDao {
    void save(Topo topo);
    void update(Topo topo);
    List<Topo> list();
    Topo findById(int id);
    void delete(Topo Topo);
    List<Topo> findByUser(User user);
}
