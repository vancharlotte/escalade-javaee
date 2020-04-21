package org.escalade.controller.comment;

import org.escalade.model.dao.CommentDao;
import org.escalade.model.dao.CommentDaoImpl;
import org.escalade.model.dao.SiteDao;
import org.escalade.model.dao.SiteDaoImpl;
import org.escalade.model.entity.Comment;
import org.escalade.model.entity.Site;
import org.escalade.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Set;

@WebServlet(name = "AddCommentServlet", urlPatterns = "/user/addComment")

public class AddCommentServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(AddCommentServlet.class);

    CommentDao commentDao;
    SiteDao siteDao;

    public void init() {
        commentDao = new CommentDaoImpl();
        siteDao = new SiteDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int siteId = Integer.parseInt(req.getQueryString());
        Site site = siteDao.findById(siteId);

        req.setAttribute("site", site);


        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/comment/addComment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Site site = siteDao.findById(Integer.parseInt(req.getParameter("site")));
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        Comment comment = new Comment();
        comment.setTitle(req.getParameter("title"));
        comment.setDescription(req.getParameter("description"));
        comment.setSite(site);
        comment.setUser(user);
        comment.setTime(new Timestamp(System.currentTimeMillis()));

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
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/comment/addComment.jsp").forward(req, resp);

        } else {

            commentDao.save(comment);

            resp.sendRedirect(req.getContextPath() + "/site?" + site.getSiteId());
        }
    }
}
