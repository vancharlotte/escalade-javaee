package org.kreo.model.dao;

import java.util.List;

import org.escalade.config.AppInitializer;
import org.escalade.model.dao.UserDaoImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.escalade.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = {AppInitializer.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserDaoImpl {

    @Autowired
    private UserDaoImpl userDaoImpl;
    private User user = new User();


    @Before
    public void createUser() {
        user.setUsername("Paul");
        user.setPassword("aaaaaaaaa");
        user.setEmail("Paul@gmail.com");
    }

    @Test
    @Transactional
    public void testSaveUser() {
        userDaoImpl.save(user);
        List<User> users = userDaoImpl.list();
        Assert.assertEquals("Paul", users.get(0).getUsername());
    }

    @Test
    @Transactional
    public void testUpdateUser() {
        userDaoImpl.save(user);
        user.setUsername("Pierre");
        userDaoImpl.update(user);
        List<User> users = userDaoImpl.list();
        Assert.assertEquals("Pierre", users.get(0).getUsername());
    }

    @Test
    @Transactional
    public void testListUser() {
        userDaoImpl.save(user);
        List<User> users = userDaoImpl.list();
        Assert.assertEquals(1, users.size());
    }

    @Test
    @Transactional
    public void testFindById() {
        userDaoImpl.save(user);
        User user2 = userDaoImpl.findById(user.getUserId());
        Assert.assertEquals("Paul", user2.getUsername());
    }

    @Test
    @Transactional
    public void testFindByUsername() {
        userDaoImpl.save(user);
        User user2 = userDaoImpl.findByUsername(user.getUsername());
        Assert.assertEquals("Paul", user2.getUsername());
    }


    @Test
    @Transactional
    public void testFindByEmail() {
        userDaoImpl.save(user);
        User user2 = userDaoImpl.findByEmail (user.getEmail());
        Assert.assertEquals("Paul@gmail.com", user2.getEmail());
    }

    @Test
    @Transactional
    public void testDeleteUser() {
        userDaoImpl.save(user);
        userDaoImpl.delete(user);
        List<User> users2 = userDaoImpl.list();
        boolean isEmpty = users2.isEmpty();
        Assert.assertTrue(isEmpty);
    }


}
