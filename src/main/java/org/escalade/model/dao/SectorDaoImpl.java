package org.escalade.model.dao;

import org.escalade.model.entity.Comment;
import org.escalade.model.entity.Role;
import org.escalade.model.entity.Sector;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import java.util.List;

public class SectorDaoImpl implements SectorDao {

    private SessionFactory sessionFactory;

    @Override
    public void save(Sector sector) { sessionFactory.getCurrentSession().save(sector);    }

    @Override
    public void update(Sector sector) { sessionFactory.getCurrentSession().update(sector);     }


    @Override
    public List<Sector> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<Sector> query = sessionFactory.getCurrentSession().createQuery("from Sector");
        return query.getResultList();    }

    @Override
    public Sector findById(int id) {
        Sector sector  = sessionFactory.getCurrentSession().get(Sector.class, id);
        return sector;      }

    @Override
    public void delete(Sector sector) {
        sessionFactory.getCurrentSession().delete(sector);

    }
}
