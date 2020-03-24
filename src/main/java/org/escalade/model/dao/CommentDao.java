package org.escalade.model.dao;

import org.escalade.model.entity.Comment;
import org.escalade.model.entity.Site;

import java.util.List;

public interface CommentDao {

    void save(Comment comment);
    void update(Comment comment);
    void delete(Comment comment);
    List<Comment> list();
    Comment findById(int id);
    List<Comment> findBySite(int siteId);

}
