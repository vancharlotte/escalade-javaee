package org.escalade.controller.comment;

import org.escalade.model.dao.CommentDao;
import org.escalade.model.dao.CommentDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddCommentServlet", urlPatterns ="/user/addComment")

public class AddCommentServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(AddCommentServlet.class);

    CommentDao commentDao;

    public void init() {
        commentDao = new CommentDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", req.getParameter("message"));

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/comment/addComment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
