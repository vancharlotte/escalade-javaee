package org.escalade.model.dao;

import org.escalade.config.HibernateUtil;
import org.escalade.model.entity.Site;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class SiteDaoImpl implements SiteDao {

    static final Logger logger = LoggerFactory.getLogger(SiteDaoImpl.class);


    @Override
    public void save(Site site) {

        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.save(site);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(Site site) {

        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.update(site);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public List<Site> list() {
        List<Site> sites = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            Query<Site> q = session.createQuery("from Site");
            sites = q.getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sites;
    }

    @Override
    public Site findById(int id) {
        Site site = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            site = session.get(Site.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return site;
    }


    @Override
    public void delete(Site site) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(site);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public List<Site> findByName(String name) {
        List<Site> sites = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Site> query = builder.createQuery(Site.class);
            Root<Site> root = query.from(Site.class);

            Predicate predicate = builder.equal(root.get("name"), name);
            query.where(predicate);
            Query<Site> q = session.createQuery(query);
            sites = q.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sites;
    }

    @Override
    public List<Site> findByQuotation(String quotation) {
        List<Site> sites = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Site> query = builder.createQuery(Site.class);
            Root<Site> root = query.from(Site.class);

            Predicate predicate = builder.equal(root.get("quotation"), quotation);
            query.where(predicate);
            Query<Site> q = session.createQuery(query);
            sites = q.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sites;
    }

    @Override
    public List<Site> findByLotation(String location) {
        List<Site> sites = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Site> query = builder.createQuery(Site.class);
            Root<Site> root = query.from(Site.class);

            Predicate predicate = builder.equal(root.get("location"), location);
            query.where(predicate);
            Query<Site> q = session.createQuery(query);
            sites = q.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sites;
    }

    @Override
    public List<Site> findByChecked(boolean checked) {
        List<Site> sites = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Site> query = builder.createQuery(Site.class);
            Root<Site> root = query.from(Site.class);

            Predicate predicate = builder.equal(root.get("checked"), checked);
            query.where(predicate);
            Query<Site> q = session.createQuery(query);
            sites = q.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sites;
    }

    @Override
    public List<Site> search(String name, String quotation, String location, boolean checked) {
        List<Site> sites = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Site> query = builder.createQuery(Site.class);
            Root<Site> root = query.from(Site.class);

            Predicate prName = builder.equal(root.get("name"), name);
            Predicate prQuotation = builder.equal(root.get("quotation"), quotation);
            Predicate prLocation = builder.equal(root.get("location"), location);
            Predicate prChecked = builder.equal(root.get("checked"), checked);

            if (name != null) {
                query.where(prName);
            }
            if (quotation != null) {
                query.where(prQuotation);
            }
            if (location != null) {
                query.where(prLocation);
            }
            query.where(prChecked);

            Query<Site> q = session.createQuery(query);
            sites = q.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sites;
    }

}

