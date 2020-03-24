package org.escalade.model.dao;

import org.escalade.model.entity.Site;

import java.util.List;

public interface SiteDao {

    void save(Site site);
    void update(Site site);
    List<Site> list();
    Site findById(int id);
    void delete(Site site);
    List<Site> findByName(String name);
    List<Site> findByQuotation(String quotation);
    List<Site> findByLotation(String lotation);
    List<Site> findByChecked(boolean checked);

    List<Site> search(String name, String quotation, String location, boolean checked);
}
