package org.escalade.controller.topo;

import org.escalade.model.dao.TopoDao;
import org.escalade.model.dao.TopoDaoImpl;
import org.escalade.model.entity.Site;
import org.escalade.model.entity.Topo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchTopoServlet", urlPatterns = "/searchTopo")
public class SearchTopoServlet extends HttpServlet {

    TopoDao topoDao;

    @Override
    public void init() throws ServletException {
        topoDao = new TopoDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Topo> topoList = topoDao.list();
        req.setAttribute("topoList", topoList);

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/search/searchTopo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/site/searchTopo.jsp").forward(req, resp);
    }
}
