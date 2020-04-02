package org.escalade.controller.user;

import org.escalade.controller.topo.AddTopoServlet;
import org.escalade.model.dao.UserDao;
import org.escalade.model.dao.UserDaoImpl;
import org.escalade.model.dao.UserDetailsServiceImpl;
import org.escalade.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    UserDao userDao;
    UserDetailsServiceImpl userDetailsService;

    public void init() {
        userDao = new UserDaoImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = userDao.findByUsername(req.getParameter("username"));
        String password = req.getParameter("password");
        HttpSession session = req.getSession();


        if (user != null && user.getPassword().equals(req.getParameter("password"))) {
            String message = "Bonjour " + req.getParameter("username");
            req.setAttribute("message", message);
            session.setAttribute("user", user);
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/page.jsp").forward(req, resp);
        } else {
            
            logger.info("erreur : " + user + "et " + password);
            String message = "identifiant ou mot de passe incorrect.";
            req.setAttribute("message", message);
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
        }
    }
}

