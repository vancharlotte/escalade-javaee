package org.kreo.model.dao;
/*
import org.escalade.config.AppInitializer;
import org.escalade.model.dao.TopoDaoImpl;
import org.escalade.model.entity.Topo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.util.List;

@ContextConfiguration(classes = {AppInitializer.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTopoDaoImpl {

    @Autowired
    private TopoDaoImpl topoDaoImpl;
    private Topo topo = new Topo();


    @Before
    public void createUser() {
        topo.setName("topoA");
        topo.setDescription("abcdef");
        topo.setLocation("abcdef");
        topo.setReleaseDate("01/01/2000");
        topo.setAvailable(true);
    }

    @Test
    @Transactional
    public void testSaveUser() {
        topoDaoImpl.save(topo);
        List<Topo> users = topoDaoImpl.list();
        Assert.assertEquals("topoA", users.get(0).getName());
    }

    @Test
    @Transactional
    public void testUpdateUser() {
        topoDaoImpl.save(topo);
        topo.setName("topoB");
        topoDaoImpl.update(topo);
        List<Topo> topos = topoDaoImpl.list();
        Assert.assertEquals("topoB", topos.get(0).getName());
    }

    @Test
    @Transactional
    public void testListUser() {
        topoDaoImpl.save(topo);
        List<Topo> topos = topoDaoImpl.list();
        Assert.assertEquals(1, topos.size());
    }

    @Test
    @Transactional
    public void testFindById() {
        topoDaoImpl.save(topo);
        Topo topo2 = topoDaoImpl.findById(topo.getTopoId());
        Assert.assertEquals("topoA", topo2.getName());
    }

    @Test
    @Transactional
    public void testDeleteUser() {
        topoDaoImpl.save(topo);
        topoDaoImpl.delete(topo);
        List<Topo> topos = topoDaoImpl.list();
        boolean isEmpty = topos.isEmpty();
        Assert.assertTrue(isEmpty);
    }

}

*/