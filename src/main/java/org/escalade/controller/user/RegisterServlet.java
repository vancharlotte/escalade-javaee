package org.escalade.controller.user;

import org.escalade.model.dao.RoleDao;
import org.escalade.model.dao.RoleDaoImpl;
import org.escalade.model.dao.UserDao;
import org.escalade.model.dao.UserDaoImpl;
import org.escalade.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.*;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(RegisterServlet.class);

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

        HttpSession session = req.getSession();

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<User>> errors = validator.validate(user);

        logger.info(user.getPassword() + "/" +user.getConfirmPassword());

        if (!errors.isEmpty()) {
            String errorList = "<ul>";
            for (ConstraintViolation<User> constraintViolation :errors) {
                errorList += "<li> " + constraintViolation.getMessage()
                        + "</li>";
            }
            errorList += "</ul>";
            req.setAttribute("message", errorList);
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/addUser.jsp").forward(req, resp);


        } else {
            userDao.save(user);
            session.setAttribute("user", user);
            req.setAttribute("user", user);
            req.setAttribute("message", "Inscription réussie, veuillez saisir vos identifiants pour vous connecter");
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(req, resp);

        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(req, resp);
        
    }
}
