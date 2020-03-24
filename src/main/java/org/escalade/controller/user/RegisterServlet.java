package org.escalade.controller.user;

import org.escalade.controller.validator.UserFormValidator;
import org.escalade.model.dao.UserDao;
import org.escalade.model.dao.UserDaoImpl;
import org.escalade.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    UserDao userDao;

    public void init() {
        userDao = new UserDaoImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/addUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setConfirmPassword(req.getParameter("confirmPassword"));
        user.setEmail(req.getParameter("email"));
        userDao.save(user);

        HttpSession session = req.getSession();
        session.setAttribute("user",user);

        String message = "Bonjour " + req.getParameter("username");
        req.setAttribute("message", message);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/page.jsp").forward(req, resp);
    }
}
