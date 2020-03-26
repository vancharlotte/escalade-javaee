package org.escalade.model.dao;

import java.util.List;

import org.escalade.model.dao.UserDaoImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.escalade.model.entity.User;


public class TestUserDaoImpl {


 UserDaoImpl userDaoImpl;
 User user = new User();


    @Before
    public void createUser() {
        user.setUsername("Paul");
        user.setPassword("aaaaaaaaa");
        user.setEmail("Paul@gmail.com");
    }

    @Test
    public void testSaveUser() {
        userDaoImpl.save(user);
        List<User> users = userDaoImpl.list();
        Assert.assertEquals("Paul", users.get(0).getUsername());
    }

    @Test
    public void testUpdateUser() {
        userDaoImpl.save(user);
        user.setUsername("Pierre");
        userDaoImpl.update(user);
        List<User> users = userDaoImpl.list();
        Assert.assertEquals("Pierre", users.get(0).getUsername());
    }

    @Test
    public void testListUser() {
        userDaoImpl.save(user);
        List<User> users = userDaoImpl.list();
        Assert.assertEquals(1, users.size());
    }

    @Test
    public void testFindById() {
        userDaoImpl.save(user);
        User user2 = userDaoImpl.findById(user.getUserId());
        Assert.assertEquals("Paul", user2.getUsername());
    }

    @Test
    public void testFindByUsername() {
        userDaoImpl.save(user);
        User user2 = userDaoImpl.findByUsername(user.getUsername());
        Assert.assertEquals("Paul", user2.getUsername());
    }



    @Test
    public void testDeleteUser() {
        userDaoImpl.save(user);
        userDaoImpl.delete(user);
        List<User> users2 = userDaoImpl.list();
        boolean isEmpty = users2.isEmpty();
        Assert.assertTrue(isEmpty);
    }


}
