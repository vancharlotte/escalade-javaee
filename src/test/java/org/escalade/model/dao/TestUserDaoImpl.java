package org.escalade.model.dao;

import java.util.List;

import org.escalade.model.entity.Booking;
import org.escalade.model.entity.Topo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.escalade.model.entity.User;


public class TestUserDaoImpl {

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

        userDao.save(user);




    }


    @Test
    public void testUpdateUser() {
        user.setUsername("Pierre");
        userDao.update(user);
        List<User> users = userDao.list();
        Assert.assertEquals("Pierre", users.get(0).getUsername());
    }

    @Test
    public void testListUser() {
        List<User> users = userDao.list();
        Assert.assertEquals(1, users.size());
    }

    @Test
    public void testFindById() {
        User user2 = userDao.findById(user.getUserId());
        Assert.assertEquals("Jean", user2.getUsername());
    }

    @Test
    public void testSearchByUsername() {
        List<User> users = userDao.searchByUsername(user.getUsername());
        Assert.assertEquals(1,users.size());
        System.out.println("name user : " + users.get(0).getUsername());

    }

    @Test
    public void testFindByUsername() {
        User user2 = userDao.findByUsername(user.getUsername());
        Assert.assertEquals("Jean", user2.getUsername());
    }

    @Test
    public void testDeleteUser() {
        userDao.delete(user);
        List<User> users = userDao.list();
        boolean isEmpty = users.isEmpty();
        Assert.assertTrue(isEmpty);
    }


@After
    public void after(){
        userDao.delete(user);
}

}
