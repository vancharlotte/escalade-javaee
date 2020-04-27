package org.escalade.model.dao;

import org.escalade.config.HibernateUtil;
import org.escalade.controller.topo.AddTopoServlet;
import org.escalade.model.entity.Topo;
import org.escalade.model.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TopoDaoImpl implements TopoDao {

    static final Logger logger = LoggerFactory.getLogger(AddTopoServlet.class);


    @Override
    public void save(Topo topo) {

        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.save(topo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void update(Topo topo) {

        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.update(topo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public List<Topo> list() {
        List<Topo> topos = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            Query<Topo> q = session.createQuery("from Topo");
            topos = q.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return topos;
    }

    @Override
    public Topo findById(int id) {
        Topo topo = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            topo = session.get(Topo.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return topo;
    }


    @Override
    public void delete(Topo topo) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(topo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Topo> searchByName(String name) {
        List<Topo> topos = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Topo> query = builder.createQuery(Topo.class);
            Root<Topo> root = query.from(Topo.class);

            Predicate predicate = builder.like(builder.lower(root.get("name")), "%"+name.toLowerCase()+"%");
            query.where(predicate);
            query.orderBy(builder.asc(root.get("name")));
            Query<Topo> q = session.createQuery(query);
            topos = q.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return topos;
    }

    @Override
    public List<Topo> search(String name, String city, String departement, boolean available) {
        List<Topo> topos = null;
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Topo> query = builder.createQuery(Topo.class);
            Root<Topo> root = query.from(Topo.class);

            List<Predicate> predicates = new ArrayList<>();

            if (!name.equals("")) {
                predicates.add(builder.like(builder.lower(root.get("name")), "%"+name.toLowerCase()+"%"));
            }

            if (!city.equals("")) {
                predicates.add( builder.like(root.get("city"), "%"+city+"%"));
            }
            if (!departement.equals("")) {
                predicates.add( builder.equal(root.get("departement"), departement));
            }
            if (available) {
                predicates.add(builder.equal(root.get("available"), available));
            }


            Predicate predicate = builder.and(predicates.toArray(new Predicate[predicates.size()]));
            Query<Topo> q = session.createQuery(query.where(predicate));
            query.orderBy(builder.asc(root.get("name")));
            topos = q.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return topos;
    }


    @Override
    public List<Topo> findByUser(User user) {
        List<Topo> topos = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Topo> query = builder.createQuery(Topo.class);
            Root<Topo> root = query.from(Topo.class);

            Predicate predicate = builder.equal(root.get("user"), user);
            query.where(predicate);
            query.orderBy(builder.asc(root.get("name")));
            Query<Topo> q = session.createQuery(query);
            topos = q.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return topos;
    }
}