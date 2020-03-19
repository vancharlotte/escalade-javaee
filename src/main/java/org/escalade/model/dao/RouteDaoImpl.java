package org.escalade.model.dao;

import org.escalade.model.entity.Comment;
import org.escalade.model.entity.Role;
import org.escalade.model.entity.Route;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RouteDaoImpl implements RouteDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Route route) { sessionFactory.getCurrentSession().save(route);    }

    @Override
    public void update(Route route) { sessionFactory.getCurrentSession().update(route);     }

    @Override
    public List<Route> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<Route> query = sessionFactory.getCurrentSession().createQuery("from Route");
        return query.getResultList();    }

    @Override
    public Route findById(int id) {
        Route route  = sessionFactory.getCurrentSession().get(Route.class, id);
        return route;      }

    @Override
    public void delete(Route route) {
        sessionFactory.getCurrentSession().update(route);

    }
}
