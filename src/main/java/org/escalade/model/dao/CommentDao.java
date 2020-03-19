package org.escalade.model.dao;

import org.escalade.model.entity.Comment;

import java.util.List;

public interface CommentDao {

    void save(Comment comment);
    void update(Comment comment);
    List<Comment> list();
    Comment findById(int id);
    void delete(Comment comment);
}
