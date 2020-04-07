package org.escalade.controller.search;

import org.escalade.model.dao.TopoDao;
import org.escalade.model.dao.TopoDaoImpl;
import org.escalade.model.entity.EntityUtil;
import org.escalade.model.entity.Topo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchTopoServlet", urlPatterns ={ "/searchTopo", "/user/searchTopo"})
public class SearchTopoServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(SearchTopoServlet.class);

    TopoDao topoDao;

    @Override
    public void init() throws ServletException {
        topoDao = new TopoDaoImpl();
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("searchByName");
        String city = req.getParameter("searchByCity");
        String departement = req.getParameter("searchByDepartement");
        String availableString = req.getParameter("searchByAvailable");
        boolean available = true;
        if (availableString==null) { available=false; }

        List<Topo> topoList = topoDao.search(name, city, departement, available);
        req.setAttribute("topoList", topoList);
        req.setAttribute("departementList", EntityUtil.InitDepartementList());


        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/search/searchTopo.jsp").forward(req, resp);
    }
}
