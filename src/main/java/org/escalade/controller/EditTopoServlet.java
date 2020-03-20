package org.escalade.controller;

import org.escalade.model.dao.TopoDao;
import org.escalade.model.dao.TopoDaoImpl;
import org.escalade.model.entity.Topo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditTopoServlet", urlPatterns = "/editTopo")
public class EditTopoServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(AddTopoServlet.class);

    TopoDao topoDao;

    public void init() {
        topoDao = new TopoDaoImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int topoId = Integer.parseInt(req.getQueryString());
        Topo topo = topoDao.findById(topoId);
        req.setAttribute("topo", topo);
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/topo/addTopo.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
