package org.escalade.model.dao;

import org.escalade.config.HibernateUtil;
import org.escalade.model.entity.Site;

import org.escalade.model.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
    public List<Site> searchByName(String name) {
        List<Site> sites = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Site> query = builder.createQuery(Site.class);
            Root<Site> root = query.from(Site.class);

            Predicate predicate = builder.like(root.get("name"), "%" + name + "%");
            query.where(predicate);
            query.orderBy(builder.asc(root.get("name")));
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
    public Site findByName(String name) {
        Site site = null;
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Site> query = builder.createQuery(Site.class);
            Root<Site> root = query.from(Site.class);

            Predicate namePredicate = builder.equal(builder.lower(root.get("name")), name.toLowerCase());

            query.where(namePredicate);
            Query<Site> q = session.createQuery(query);
            site = q.getSingleResult();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
          //  e.printStackTrace();
        }
        return site;
    }

    @Override
    public List<Site> search(String name, String city, String departement, String nbRoutes, boolean checked, String quotation) {

        List<Site> sites = null;
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Site> query = builder.createQuery(Site.class);
            Root<Site> root = query.from(Site.class);

            List<Predicate> predicates = new ArrayList<>();

            if (!name.equals("")) {
                predicates.add(builder.like(root.get("name"), "%" + name + "%"));
            }

            if (!city.equals("")) {
                predicates.add(builder.like(root.get("city"), "%" + city + "%"));
            }

            if (!departement.equals("")) {
                predicates.add(builder.equal(root.get("departement"), departement));
            }

            if (!departement.equals("")) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("nbRoutes"), nbRoutes));
            }
            if (checked) {
                predicates.add(builder.equal(root.get("checked"), checked));
            }

            if (!quotation.equals("")) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("quotationMax"), quotation));

                predicates.add(builder.lessThanOrEqualTo(root.get("quotationMin"), quotation));
            }


            Predicate predicate = builder.and(predicates.toArray(new Predicate[predicates.size()]));
            query.orderBy(builder.asc(root.get("name")));
            Query<Site> q = session.createQuery(query.where(predicate));
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
    public List<Site> listPage(int pageNumber) {
        List<Site> sites = null;
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();

            int pageSize = 10;

            CriteriaQuery<Site> query = builder.createQuery(Site.class);
            Root<Site> root = query.from(Site.class);
            query.select(root);
            query.orderBy(builder.desc(root.get("siteId")));

            TypedQuery<Site> typedQuery = session.createQuery(query);
                typedQuery.setFirstResult(pageNumber*pageSize -(pageSize));
                typedQuery.setMaxResults(pageSize);
                sites = typedQuery.getResultList();

                logger.info("sites size : " + sites.size());

                transaction.commit();

            } catch(Exception e){
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
            return sites;
        }

    }

