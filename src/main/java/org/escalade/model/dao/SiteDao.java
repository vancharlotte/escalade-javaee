package org.escalade.model.dao;

import org.escalade.model.entity.Site;

import java.util.List;

public interface SiteDao {

    void save(Site site);
    void update(Site site);
    List<Site> list();
    Site findById(int id);
    void delete(Site site);
    List<Site> searchByName(String name);

    Site findByName(String name);

    List<Site> search(String name, String city, String departement, String nbRoutes, boolean checked, String quotation);
    List<Site> listPage(int pageNumber);

}
