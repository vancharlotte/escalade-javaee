package org.escalade.controller.topo;

import org.escalade.model.dao.TopoDao;
import org.escalade.model.dao.TopoDaoImpl;
import org.escalade.model.dao.UserDao;
import org.escalade.model.dao.UserDaoImpl;
import org.escalade.model.entity.Topo;
import org.escalade.model.entity.User;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "TopoServlet", urlPatterns = {"/topo"})
public class TopoServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(MyTopoServlet.class);

    TopoDao topoDao;
    UserDao userDao;

    public void init() {
        topoDao = new TopoDaoImpl();
        userDao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");


        int topoId = Integer.parseInt(req.getParameter("topoId"));
        Topo topo = topoDao.findById(topoId);
        User owner = userDao.findById(topo.getUser().getUserId());
        req.setAttribute("topo", topo);
        req.setAttribute("owner", owner);
        req.setAttribute("user", user);
        String message;

        if (topo.isAvailable()) {
            message = "Ce topo est disponible.";
        } else {
            message = "Ce topo n'est pas disponible.";
        }
        req.setAttribute("message", message);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/topo/Topo.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
