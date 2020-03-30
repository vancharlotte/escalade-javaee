package org.escalade.model.dao;

import org.escalade.model.entity.Topo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.List;


public class TestTopoDaoImpl {

    private TopoDaoImpl topoDaoImpl = new TopoDaoImpl();
    private Topo topo = new Topo();


    @Before
    public void createTopo() {
        topo.setName("topoA");
        topo.setDescription("abcdef");
        topo.setCity("abcdef");
        topo.setDepartement("59 - Nord");
        topo.setReleaseDate("01/01/2000");
        topo.setAvailable(true);
    }

    @Test
    public void testSaveUser() {
        topoDaoImpl.save(topo);
        List<Topo> users = topoDaoImpl.list();
        Assert.assertEquals("topoA", users.get(0).getName());
    }

    @Test
    public void testUpdateUser() {
        topoDaoImpl.save(topo);
        topo.setName("topoB");
        topoDaoImpl.update(topo);
        List<Topo> topos = topoDaoImpl.list();
        Assert.assertEquals("topoB", topos.get(0).getName());
    }

    @Test
    public void testListUser() {
        topoDaoImpl.save(topo);
        List<Topo> topos = topoDaoImpl.list();
        Assert.assertEquals(1, topos.size());
    }

    @Test
    public void testFindById() {
        topoDaoImpl.save(topo);
        Topo topo2 = topoDaoImpl.findById(topo.getTopoId());
        Assert.assertEquals("topoA", topo2.getName());
    }

    @Test
    public void testDeleteUser() {
        topoDaoImpl.save(topo);
        topoDaoImpl.delete(topo);
        List<Topo> topos = topoDaoImpl.list();
        boolean isEmpty = topos.isEmpty();
        Assert.assertTrue(isEmpty);
    }

}

