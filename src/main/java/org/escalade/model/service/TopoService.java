package org.escalade.model.service;

import org.escalade.model.entity.Topo;
import org.escalade.model.entity.User;

import java.util.List;

public interface TopoService {

    List<Topo> list();
    Topo findById(int id);
    void save(Topo topo);
    void update(Topo topo);
    void delete(Topo topo);
    List<Topo> findByUser(User user);

}
