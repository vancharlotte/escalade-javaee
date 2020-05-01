package org.escalade.controller.user;

import org.escalade.model.dao.UserDao;
import org.escalade.model.dao.UserDaoImpl;
import org.escalade.model.entity.User;

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
import java.util.Set;

@WebServlet(name = "EditPasswordServlet", urlPatterns = {"/editPassword", "/user/editPassword"})
public class EditPasswordServlet extends HttpServlet {

    UserDao userDao;

    public void init() {
        userDao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        User user = userDao.findById(userId);

        req.setAttribute("user", user);
        req.setAttribute("message", req.getParameter("message"));


        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/editPassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        User user = userDao.findById(userId);

        String oldPassword = req.getParameter("oldPassword");

        if (!oldPassword.equals(user.getPassword())) {
            req.setAttribute("message", "Votre ancien mot de passe est incorrect!");
            req.setAttribute("user", user);
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/editPassword.jsp").forward(req, resp);

        } else {

            user.setPassword(req.getParameter("password"));
            user.setConfirmPassword(req.getParameter("confirmPassword"));

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<User>> errors = validator.validate(user);

            if (!errors.isEmpty()) {
                String errorList = "<ul>";
                for (ConstraintViolation<User> constraintViolation : errors) {
                    errorList += "<li> " + constraintViolation.getMessage()
                            + "</li>";
                }
                errorList += "</ul>";
                req.setAttribute("message", errorList);
                req.setAttribute("user", user);
                this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/editPassword.jsp").forward(req, resp);

            } else {
                userDao.update(user);
                resp.sendRedirect(req.getContextPath() + "/user/page?userId=" + user.getUserId()+"&message="+ "success");
            }
        }
    }

}
