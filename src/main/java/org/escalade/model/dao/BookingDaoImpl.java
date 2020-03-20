package org.escalade.model.dao;

import org.escalade.model.entity.Booking;
import org.escalade.model.entity.Topo;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import java.util.List;

public class BookingDaoImpl implements BookingDao {

    private SessionFactory sessionFactory;

    @Override
    public void save(Booking booking) {sessionFactory.getCurrentSession().save(booking);     }

    @Override
    public void update(Booking booking) {sessionFactory.getCurrentSession().update(booking);     }

    @Override
    public List<Booking> list() {
       // @SuppressWarnings("unchecked")
       // TypedQuery<Booking> query = sessionFactory.getCurrentSession().createQuery("from Booking");
       // return query.getResultList();
        return null;}

    @Override
    public Booking findById(int id) {
        Booking booking = sessionFactory.getCurrentSession().get(Booking.class, id);
        return booking;    }

    @Override
    public void delete(Booking booking) {
        sessionFactory.getCurrentSession().delete(booking);
    }
}
