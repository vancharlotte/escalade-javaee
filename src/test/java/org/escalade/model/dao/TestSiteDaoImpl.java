package org.escalade.model.dao;

import org.escalade.model.entity.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestSiteDaoImpl {

    Role role = new Role();
    User user = new User();
    Site site = new Site();

    RoleDaoImpl roleDao = new RoleDaoImpl();
    UserDaoImpl userDao = new UserDaoImpl();
    SiteDaoImpl siteDao = new SiteDaoImpl();

    @Before
    public void before() {
        role.setName("USER");
        roleDao.save(role);

        user.setUsername("Jean");
        user.setPassword("1ABCDefgh");
        user.setEmail("jean@gmail.com");
        user.setRole(role);
        userDao.save(user);

        site.setName("Site1");
        site.setCity("ville");
        site.setDepartement("departement");
        site.setDescription("description du site1");
        site.setQuotationMin("1");
        site.setQuotationMax("5");
        site.setNbRoutes("50");
        site.setUser(user);
        siteDao.save(site);

    }


    @Test
    public void testFindByName() {
        String name = "site1";

        Assert.assertEquals(siteDao.findByName(name).getName(), "Site1");
    }

    @After
    public void after(){
        siteDao.delete(site);
        userDao.delete(user);
        roleDao.delete(role);
    }


}
