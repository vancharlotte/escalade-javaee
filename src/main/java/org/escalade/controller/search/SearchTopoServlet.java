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

@WebServlet(name = "SearchTopoServlet", urlPatterns ={ "/searchTopo", "/user/searchTopo",  "/admin/searchTopo"})
public class SearchTopoServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(SearchTopoServlet.class);

    TopoDao topoDao;

    @Override
    public void init() throws ServletException {
        topoDao = new TopoDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name")==null? "" : req.getParameter("name");
        String city = req.getParameter("city")==null? "" : req.getParameter("city");
        String departement = req.getParameter("departement")==null? "" : req.getParameter("departement");
        String availableString = req.getParameter("available")==null? "false" : req.getParameter("available");
        boolean available = availableString.equals("true");

        logger.info("Topo, selected criteria for research : name " +  name);

        List<Topo> topoList = topoDao.search(name, city, departement, available);
        req.setAttribute("topoList", topoList);
        req.setAttribute("departementList", EntityUtil.InitDepartementList());

        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/search/searchTopo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("searchByName")==null? "" : req.getParameter("searchByName");
        String city = req.getParameter("searchByCity")==null? "" : req.getParameter("searchByCity");
        String departement = req.getParameter("searchByDepartement")==null? "" : req.getParameter("searchByDepartement");
        String availableString = req.getParameter("searchByAvailable")==null? "false" : req.getParameter("searchByAvailable");
        boolean available = availableString.equals("true");

        logger.info("Topo, selected criteria for research : name " +  name + " ,city " +  city + " ,departement " + departement +  " ,available" + availableString );

        List<Topo> topoList = topoDao.search(name, city, departement, available);
        req.setAttribute("topoList", topoList);
        req.setAttribute("departementList", EntityUtil.InitDepartementList());

        resp.sendRedirect(req.getContextPath() + "/searchTopo?name="+ name +"&city="+ city +"&departement=" + departement+"&available="+ available);

    }
}
