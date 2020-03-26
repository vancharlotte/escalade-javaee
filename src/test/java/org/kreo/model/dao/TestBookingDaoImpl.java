package org.kreo.model.dao;

import org.escalade.model.dao.BookingDaoImpl;
import org.escalade.model.dao.TopoDaoImpl;
import org.escalade.model.dao.UserDao;
import org.escalade.model.dao.UserDaoImpl;
import org.escalade.model.entity.Booking;
import org.escalade.model.entity.Topo;
import org.escalade.model.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestBookingDaoImpl {

    User user = new User();
    BookingDaoImpl bookingDao = new BookingDaoImpl();
    UserDaoImpl userDao = new UserDaoImpl();


    @Before
    public void createEntity() {
        user.setUsername("Jean");
        user.setPassword("abcdefgh");
        user.setEmail("jean@gmail.com");

        User user2 = new User();
        user2.setUsername("Paul");
        user2.setPassword("abcdefgh");
        user2.setEmail("paul@gmaail.com");

        userDao.save(user);
        userDao.save(user2);

        Topo topo = new Topo();
        topo.setName("topo1");
        topo.setUser(user);
        topo.setAvailable(true);
        topo.setLocation("ici");
        topo.setDescription("description");
        topo.setReleaseDate("0");

        TopoDaoImpl topoDao = new TopoDaoImpl();
        topoDao.save(topo);

        Booking booking = new Booking();
        booking.setTopo(topo);
        booking.setUser(user2);
        booking.setStatus("en attente");

        bookingDao.save(booking);
    }


    @Test
    public void testfindByOwner() {
        List<Booking> test = bookingDao.findByOwner(user);
        Assert.assertEquals(test.size(),1);
    }
}
