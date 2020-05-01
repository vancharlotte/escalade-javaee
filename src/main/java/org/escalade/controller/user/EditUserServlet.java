package org.escalade.controller.user;

import org.escalade.model.dao.TopoDaoImpl;
import org.escalade.model.dao.UserDao;
import org.escalade.model.dao.UserDaoImpl;
import org.escalade.model.entity.EntityUtil;
import org.escalade.model.entity.Topo;
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
import java.util.Set;

@WebServlet(name = "EditUserServlet", urlPatterns = {"/editUser", "/user/editUser"})
public class EditUserServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(EditUserServlet.class);

    UserDao userDao;

    public void init() {
        userDao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        logger.info("userId :" + userId);
        User user = userDao.findById(userId);
        logger.info("user :" + user.getUsername());

        req.setAttribute("user", user);
        req.setAttribute("message", req.getParameter("message"));

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/editUser.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        User user = userDao.findById(userId);

        user.setUsername(req.getParameter("username"));
        user.setEmail(req.getParameter("email"));
        user.setConfirmPassword(user.getPassword());


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
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/editUser.jsp").forward(req, resp);

        } else {
            userDao.update(user);
            HttpSession session = req.getSession();
           // req.setAttribute("message", "Vos informations ont été mises à jour.");
            session.setAttribute("user", user);
            req.setAttribute("user",user);
            resp.sendRedirect(req.getContextPath() + "/user/page?userId=" + user.getUserId()+"&message="+ "success");


        }
    }
}
