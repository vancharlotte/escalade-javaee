package org.escalade.model.dao;

import org.escalade.config.HibernateUtil;
import org.escalade.model.entity.Topo;
import org.escalade.model.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


public class UserDaoImpl implements UserDao {

    Transaction transaction;

    @Override
    public void save(User user) {
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save user object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }


    }

    public void update(User user) {
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }


    }

    @Override
    public List<User> list() {
        List<User> users = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            Query<User> q = session.createQuery("from User");
            users = q.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return users;
    }


    @Override
    public User findById(int id) {
        User user = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            user = HibernateUtil.sessionFactory.getCurrentSession().get(User.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);
            Predicate usernamePredicate = builder.equal(root.get("username"), username);
            query.where(usernamePredicate);
            Query<User> q = session.createQuery(query);
            user = q.getSingleResult();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public void delete(User user) {
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }


    }

    @Override
    public List<User> searchByUsername(String username) {
        List<User> users = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);
            Predicate usernamePredicate = builder.like(root.get("username"), "%" + username + "%");

            query.where(usernamePredicate);
            Query<User> q = session.createQuery(query);
            users = q.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return users;
    }

}
