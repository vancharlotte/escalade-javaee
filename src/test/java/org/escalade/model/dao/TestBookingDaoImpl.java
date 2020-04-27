package org.escalade.model.dao;

import org.escalade.model.dao.BookingDaoImpl;
import org.escalade.model.dao.TopoDaoImpl;
import org.escalade.model.dao.UserDao;
import org.escalade.model.dao.UserDaoImpl;
import org.escalade.model.entity.Booking;
import org.escalade.model.entity.Topo;
import org.escalade.model.entity.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestBookingDaoImpl {

    User user = new User();
    User user2 = new User();
    Topo topo = new Topo();
    Booking booking = new Booking();


    BookingDaoImpl bookingDao = new BookingDaoImpl();
    TopoDaoImpl topoDao = new TopoDaoImpl();
    UserDaoImpl userDao = new UserDaoImpl();


    @Before
    public void before() {
        user.setUsername("Jean");
        user.setPassword("abcdefgh");
        user.setEmail("jean@gmail.com");

        user2.setUsername("Paul");
        user2.setPassword("abcdefgh");
        user2.setEmail("paul@gmaail.com");
        userDao.save(user);
        userDao.save(user2);

        topo.setName("topo1");
        topo.setUser(user);
        topo.setAvailable(true);
        topo.setCity("ici");
        topo.setDepartement("59 - Nord");
        topo.setDescription("description");
        topo.setReleaseDate("0");
        topoDao.save(topo);

        booking.setTopo(topo);
        booking.setUser(user2);
        booking.setStatus("en attente");
        bookingDao.save(booking);
    }


    @Test
    public void testFindByOwner() {
        List<Booking> test = bookingDao.findByOwner(user);
        Assert.assertEquals(test.size(),1);
    }


    @Test
    public void testCheckAvailability() {
        Booking test = bookingDao.checkAvailability(topo, user2);
        Assert.assertNotNull(test);
    }


    @After
    public void after(){
        bookingDao.delete(booking);
        topoDao.delete(topo);
        userDao.delete(user);
        userDao.delete(user2);
    }

    }
