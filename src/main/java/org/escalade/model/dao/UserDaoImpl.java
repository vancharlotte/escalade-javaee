package org.escalade.model.dao;

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
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }


    @Override
    public List<User> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User findById(int id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        try {
            Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        Predicate usernamePredicate = builder.equal(root.get("username"), username);
        query.where(usernamePredicate);
        Query<User> q = session.createQuery(query);
        return q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User findByEmail(String email) {
        try {
            Session session = sessionFactory.getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);

            Predicate emailPredicate = builder.equal(root.get("email"), email);
            query.where(emailPredicate);
            Query<User> q = session.createQuery(query);
            return q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);

    }
}
