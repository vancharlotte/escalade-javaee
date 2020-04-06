package org.escalade.controller.comment;

import org.escalade.model.dao.CommentDao;
import org.escalade.model.dao.CommentDaoImpl;
import org.escalade.model.entity.Comment;
import org.escalade.model.entity.Topo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCommentServlet", urlPatterns = {"/admin/deleteComment", "/admin/editComment"})
public class EditCommentServlet extends HttpServlet {

    CommentDao commentDao;

    @Override
    public void init() throws ServletException {
        commentDao = new CommentDaoImpl();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int commentId = Integer.parseInt(req.getQueryString());
        Comment comment = commentDao.findById(commentId);

        if (req.getRequestURL().toString().contains("delete")) {
            commentDao.delete(comment);
            resp.sendRedirect(req.getContextPath() + "/site?" + comment.getSite().getSiteId());
            //a vérifier
        }
        else{
            req.setAttribute("comment", comment);
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/comment/editComment.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int commentId = Integer.parseInt(req.getParameter("commentId"));
        Comment comment = commentDao.findById(commentId);

        comment.setTitle(req.getParameter("title"));
        comment.setDescription(req.getParameter("description"));

        commentDao.update(comment);

        resp.sendRedirect(req.getContextPath() + "/site?" + comment.getSite().getSiteId());
        //a vérifier

    }
}
