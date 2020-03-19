package org.escalade.model.dao;

import org.escalade.model.entity.Comment;
import org.escalade.model.entity.Role;
import org.escalade.model.entity.Site;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SiteDaoImpl implements SiteDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Site site) { sessionFactory.getCurrentSession().save(site);    }

    @Override
    public void update(Site site) { sessionFactory.getCurrentSession().update(site);     }

    @Override
    public List<Site> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<Site> query = sessionFactory.getCurrentSession().createQuery("from Site");
        return query.getResultList();    }

    @Override
    public Site findById(int id) {
        Site site  = sessionFactory.getCurrentSession().get(Site.class, id);
        return site;      }

    @Override
    public void delete(Site site) {
        sessionFactory.getCurrentSession().delete(site);

    }
}
