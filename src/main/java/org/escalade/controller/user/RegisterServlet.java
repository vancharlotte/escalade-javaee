package org.escalade.controller.user;

import org.escalade.controller.validator.UserFormValidator;
import org.escalade.model.dao.RoleDao;
import org.escalade.model.dao.RoleDaoImpl;
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
    RoleDao roleDao;

    public void init() {
        userDao = new UserDaoImpl();
        roleDao = new RoleDaoImpl();
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
        user.setRole(roleDao.findByName("USER"));
        userDao.save(user);

        HttpSession session = req.getSession();
        session.setAttribute("user",user);

        req.setAttribute("message", "Inscription réussie, veuillez saisir vos identifiants pour vous connecter");
/*

        String message = "Bonjour " + req.getParameter("username");
        req.setAttribute("message", message);
        req.setAttribute("user",user);
        req.setAttribute("owner", user);*/

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(req, resp);

     //   resp.sendRedirect(req.getContextPath() + "/user/page?" + user.getUserId());

    }
}
