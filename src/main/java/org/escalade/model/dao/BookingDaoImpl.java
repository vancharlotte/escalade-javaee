package org.escalade.model.dao;

import org.escalade.config.HibernateUtil;
import org.escalade.model.entity.Booking;
import org.escalade.model.entity.Comment;
import org.escalade.model.entity.Topo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.List;

public class BookingDaoImpl implements BookingDao {


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
}
