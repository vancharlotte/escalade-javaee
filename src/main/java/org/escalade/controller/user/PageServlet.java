package org.escalade.controller.user;

import org.escalade.model.dao.TopoDao;
import org.escalade.model.dao.TopoDaoImpl;
import org.escalade.model.dao.UserDao;
import org.escalade.model.dao.UserDaoImpl;
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
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PageServlet", urlPatterns = {"/page", "/user/page"})
public class PageServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(PageServlet.class);

    UserDao userDao;
    TopoDao topoDao;

    public void init() {
        userDao = new UserDaoImpl();
        topoDao = new TopoDaoImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        int userId = Integer.parseInt(req.getParameter("userId"));
        logger.info("doGet page userId : " + req.getParameter("userId"));

        User owner = userDao.findById(userId);

        logger.info("user : " + user.getUsername());
        logger.info("owner : " + owner.getUsername());

        req.setAttribute("user", user);
        req.setAttribute("owner", owner);

        List<Topo> list = topoDao.findByUser(owner);

        req.setAttribute("topoList", list);


        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/page.jsp").forward(req, resp);
    }

}
