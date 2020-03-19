package org.escalade.model.service;

import org.escalade.model.dao.TopoDao;
import org.escalade.model.dao.TopoDaoImpl;
import org.escalade.model.entity.Topo;
import org.escalade.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TopoServiceImpl implements TopoService {

    @Autowired
    TopoDao topoDao;
    @Autowired
    UserService userService;

    @Override
    public List<Topo> list() {
        return topoDao.list();
    }

    @Override
    public Topo findById(int id) {
        topoDao.findById(id);
        return topoDao.findById(id);
    }

    @Override
    public void save(Topo topo) {
       topoDao.save(topo);
    }

    @Override
    public void update(Topo topo) {
        topoDao.update(topo);
    }

    @Override
    public void delete(Topo topo) {
        topoDao.delete(topo);
    }

    @Override
    public List<Topo> findByUser(User user) {
        return topoDao.findByUser(user);
    }
}
