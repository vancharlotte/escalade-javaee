package org.escalade.model.dao;

import org.escalade.config.HibernateUtil;
import org.escalade.model.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.*;
import java.util.List;

public class BookingDaoImpl implements BookingDao {

    static final Logger logger = LoggerFactory.getLogger(BookingDaoImpl.class);


    @Override
    public void save(Booking booking) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.save(booking);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(Booking booking) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.update(booking);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Booking> list() {
        List<Booking> bookings = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            Query<Booking> q = session.createQuery("from Booking ");
            bookings = q.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return bookings;
    }

    @Override
    public Booking findById(int bookingId) {
        Booking booking = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            booking = session.get(Booking.class, bookingId);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return booking;
    }

    @Override
    public void delete(Booking booking) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(booking);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Booking> findByOwner(User user) {

        List<Booking> bookings = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Booking> query = builder.createQuery(Booking.class);
            Root<Booking> bookingRoot = query.from(Booking.class);
            query.select(bookingRoot);
            Join<Object, Object> bookingTopoJoin = bookingRoot.join("topo", JoinType.INNER);

            query.where(builder.equal(bookingTopoJoin.get("user"), user));

            Query<Booking> q = session.createQuery(query);
            bookings = q.getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return bookings;
    }

    @Override
    public List<Booking> findByUser(User user) {

        List<Booking> bookings = null;
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Booking> query = builder.createQuery(Booking.class);
            Root<Booking> root = query.from(Booking.class);

            Predicate predicate = builder.equal(root.get("user"), user);
            query.where(predicate);
            Query<Booking> q = session.createQuery(query);
            bookings = q.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return bookings;
    }
}
