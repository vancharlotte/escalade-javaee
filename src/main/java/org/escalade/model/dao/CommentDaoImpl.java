package org.escalade.model.dao;

import org.escalade.model.entity.Booking;
import org.escalade.model.entity.Comment;
import org.escalade.model.entity.Topo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Comment comment) { sessionFactory.getCurrentSession().save(comment);     }

    @Override
    public void update(Comment comment) { sessionFactory.getCurrentSession().update(comment);     }


    @Override
    public List<Comment> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<Comment> query = sessionFactory.getCurrentSession().createQuery("from Comment");
        return query.getResultList();
    }

    @Override
    public Comment findById(int id) {
        Comment comment = sessionFactory.getCurrentSession().get(Comment.class, id);
        return comment;
    }

    @Override
    public void delete(Comment comment) {
        sessionFactory.getCurrentSession().delete(comment);

    }
}
