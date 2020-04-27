package org.escalade.model.dao;

import org.escalade.model.entity.Booking;
import org.escalade.model.entity.Topo;
import org.escalade.model.entity.User;

import java.util.List;

public interface BookingDao {

    void save(Booking booking);
    void update(Booking booking);
    List<Booking> list();
    Booking findById(int id);
    void delete(Booking booking);

    List<Booking> findByOwner(User user);
    List<Booking> findByUser(User user);
    Booking checkAvailability(Topo topo, User user);

    }
