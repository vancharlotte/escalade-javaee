package org.escalade.model.dao;

import org.escalade.model.entity.Sector;

import java.util.List;

public interface SectorDao {

    void save(Sector sector);
    void update(Sector sector);
    List<Sector> list();
    Sector findById(int id);
    void delete(Sector sector);
}
