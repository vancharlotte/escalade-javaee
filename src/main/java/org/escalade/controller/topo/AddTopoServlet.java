package org.escalade.controller.topo;

import org.escalade.model.dao.TopoDao;
import org.escalade.model.dao.TopoDaoImpl;
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
import java.io.IOException;

@WebServlet(name = "AddTopoServlet", urlPatterns = {"/user/addTopo", "/addTopo"})

public class AddTopoServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(AddTopoServlet.class);

    TopoDao topoDao;

    public void init() {
        topoDao = new TopoDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", req.getParameter("message"));
        req.setAttribute("departementList", EntityUtil.InitDepartementList());


        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/topo/addTopo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Topo topo = new Topo();

        topo.setName(req.getParameter("name"));
        topo.setDescription(req.getParameter("description"));
        topo.setCity(req.getParameter("city"));
        topo.setDepartement(req.getParameter("departement"));
        topo.setReleaseDate(req.getParameter("releaseDate"));
        topo.setUser((User) session.getAttribute("user"));

        String available = req.getParameter("available");
        if (available.equals("true")) {
            topo.setAvailable(true);
        } else {
            topo.setAvailable(false);
        }


        topoDao.save(topo);
        logger.info("save");

        resp.sendRedirect(req.getContextPath() + "/user/myTopo");
    }
}
