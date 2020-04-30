package org.escalade.controller.comment;

import org.escalade.model.dao.CommentDao;
import org.escalade.model.dao.CommentDaoImpl;
import org.escalade.model.entity.Comment;
import org.escalade.model.entity.Topo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Set;

@WebServlet(name = "DeleteCommentServlet", urlPatterns = {"/admin/deleteComment", "/admin/editComment"})
public class EditCommentServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(EditCommentServlet.class);

    private CommentDao commentDao;

    @Override
    public void init() throws ServletException {
        commentDao = new CommentDaoImpl();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int commentId = Integer.parseInt(req.getParameter("commentId"));
        Comment comment = commentDao.findById(commentId);

        req.setAttribute("comment", comment);

        if (req.getRequestURL().toString().contains("deleteComment")) {
            commentDao.delete(comment);
            logger.info("success delete comment");

            resp.sendRedirect(req.getContextPath() + "/site?" + comment.getSite().getSiteId());

        } else if (req.getRequestURL().toString().contains("editComment")) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/comment/editComment.jsp").forward(req, resp);

        } else {
            resp.sendRedirect(req.getContextPath() + "/site?" + comment.getSite().getSiteId());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int commentId = Integer.parseInt(req.getParameter("commentId"));
        Comment comment = commentDao.findById(commentId);

        comment.setTitle(req.getParameter("title"));
        comment.setDescription(req.getParameter("description"));

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Comment>> errors = validator.validate(comment);

        if (!errors.isEmpty()) {
            String errorList = "<ul>";
            for (ConstraintViolation<Comment> constraintViolation : errors) {
                errorList += "<li> " + constraintViolation.getMessage()
                        + "</li>";
            }
            errorList += "</ul>";
            req.setAttribute("message", errorList);
            logger.info("error update comment");

            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/comment/editComment.jsp").forward(req, resp);

        } else {
            commentDao.update(comment);
            logger.info("success update comment");

            resp.sendRedirect(req.getContextPath() + "/site?" + comment.getSite().getSiteId());
        }
    }
}
