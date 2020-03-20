package org.escalade.model.dao;

import org.escalade.model.entity.Booking;
import org.escalade.model.entity.Comment;
import org.escalade.model.entity.Role;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    private SessionFactory sessionFactory;

    @Override
    public void save(Role role) { sessionFactory.getCurrentSession().save(role);     }

    @Override
    public void update(Role role) { sessionFactory.getCurrentSession().update(role);     }


    @Override
    public List<Role> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery("from Role");
        return query.getResultList();    }

    @Override
    public Role findById(int id) {
        Role role  = sessionFactory.getCurrentSession().get(Role.class, id);
        return role;       }

    @Override
    public void delete(Role role) {
        sessionFactory.getCurrentSession().delete(role);
    }
}
