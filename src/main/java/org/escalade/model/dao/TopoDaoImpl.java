package org.escalade.model.dao;

import org.escalade.model.entity.Topo;
import org.escalade.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TopoDaoImpl implements TopoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Topo topo) {
        sessionFactory.getCurrentSession().save(topo);
    }

    public void update(Topo topo) {
        sessionFactory.getCurrentSession().update(topo);
    }


    @Override
    public List<Topo> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<Topo> query = sessionFactory.getCurrentSession().createQuery("from Topo");
        return query.getResultList();
    }

    @Override
    public Topo findById(int id) {
        Topo topo = sessionFactory.getCurrentSession().get(Topo.class, id);
        return topo;
    }

    @Override
    public void delete(Topo topo) {
        sessionFactory.getCurrentSession().delete(topo);
    }

    @Override
    public List<Topo> findByUser(User user) {
        try {
            Session session = sessionFactory.getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Topo> query = builder.createQuery(Topo.class);
            Root<Topo> root = query.from(Topo.class);

            Predicate usernamePredicate = builder.equal(root.get("user"), user);
            query.where(usernamePredicate);
            Query<Topo> q = session.createQuery(query);
            return q.getResultList();

        } catch (Exception e) {
            return null;
        }
    }

}
