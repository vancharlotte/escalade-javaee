package org.escalade.model.dao;

import org.escalade.model.entity.Booking;

import java.util.List;

public interface BookingDao {

    void save(Booking booking);
    void update(Booking booking);
    List<Booking> list();
    Booking findById(int id);
    void delete(Booking booking);
}
