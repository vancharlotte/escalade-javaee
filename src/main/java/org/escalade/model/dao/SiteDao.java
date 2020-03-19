package org.escalade.model.dao;

import org.escalade.model.entity.Site;

import java.util.List;

public interface SiteDao {

    void save(Site site);
    void update(Site site);
    List<Site> list();
    Site findById(int id);
    void delete(Site site);
}
