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

@WebServlet(name = "EditTopoServlet", urlPatterns = {"/editTopo", "/editStatusTopo", "/deleteTopo"})
public class EditTopoServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(AddTopoServlet.class);

    TopoDao topoDao;
    HttpSession session;

    public void init() {
        topoDao = new TopoDaoImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int topoId = Integer.parseInt(req.getQueryString());

        Topo topo = topoDao.findById(topoId);
        req.setAttribute("topo", topo);
        req.setAttribute("departementList", EntityUtil.InitDepartementList());

        if (req.getRequestURL().toString().contains("Status")) {
            if (topo.isAvailable()) {
                topo.setAvailable(false);
            } else {
                topo.setAvailable(true);
            }
            topoDao.update(topo);
            resp.sendRedirect(req.getContextPath() + "/myTopo");
        }

        else if (req.getRequestURL().toString().contains("delete")) {
            topoDao.delete(topo);
            resp.sendRedirect(req.getContextPath() + "/myTopo");
        }

        else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/topo/editTopo.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int topoId = Integer.parseInt(req.getParameter("topoId"));
        Topo topo = topoDao.findById(topoId);
        logger.info("topo : " + topo.getName() + topo.getTopoId());

        topo.setName(req.getParameter("name"));
        topo.setDescription(req.getParameter("description"));
        topo.setCity(req.getParameter("city"));
        topo.setDepartement(req.getParameter("departement"));
        topo.setReleaseDate(req.getParameter("releaseDate"));

        String available = req.getParameter("available");
        logger.info("available?" + available);
        if (available.equals("true")) {
            topo.setAvailable(true);
        } else {
            topo.setAvailable(false);
        }

        topoDao.update(topo);

        resp.sendRedirect(req.getContextPath() + "/myTopo");

    }
}
