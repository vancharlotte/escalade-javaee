package org.escalade.controller.search;

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
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchUserServlet", urlPatterns = {"/searchUser", "/user/searchUser"})
public class SearchUserServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(SearchUserServlet.class);

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username")==null? "" : req.getParameter("username");

        List<User> userList = userDao.searchByUsername(username);
        req.setAttribute("userList", userList);

        logger.info("User, selected criteria for research : username " +  username);


        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/search/searchUser.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("searchByUsername")==null? "" : req.getParameter("searchByUsername");

        List<User> userList = userDao.searchByUsername(username);
        req.setAttribute("userList", userList);

        logger.info("User, selected criteria for research : username " +  username);

        resp.sendRedirect(req.getContextPath() + "/searchUser?username="+ username);
    }
}
