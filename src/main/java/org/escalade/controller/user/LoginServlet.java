package org.escalade.controller.user;

import org.escalade.model.dao.UserDao;
import org.escalade.model.dao.UserDaoImpl;
import org.escalade.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login", "/successLogin"})
public class LoginServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    UserDao userDao;

    public void init() {
        userDao = new UserDaoImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userDao.findByUsername(req.getParameter("username"));
        String password = req.getParameter("password");


        if (SecurityContextHolder.getContext().getAuthentication()!=null) {
            logger.info("authenticated");
            String message = "Bonjour " + req.getParameter("username");
            req.setAttribute("message", message);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            req.setAttribute("user",user);
            req.setAttribute("owner", user);
            resp.sendRedirect(req.getContextPath() + "/user/page?userId=" + user.getUserId());

        } else {
            String message = "identifiant ou mot de passe incorrect.";
            req.setAttribute("message", message);
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(req, resp);
        }
    }
}

