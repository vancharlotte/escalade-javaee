package org.escalade.model.dao;

import org.escalade.model.entity.Route;

import java.util.List;

public interface RouteDao {

    void save(Route route);
    void update(Route route);
    List<Route> list();
    Route findById(int id);
    void delete(Route route);
}
