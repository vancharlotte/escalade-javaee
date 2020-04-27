package org.escalade.controller.search;

import org.escalade.model.dao.*;
import org.escalade.model.entity.EntityUtil;
import org.escalade.model.entity.Site;
import org.escalade.model.entity.Topo;
import org.escalade.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = {"/search", "/user/search"})
public class SearchServlet extends HttpServlet {

    static final Logger logger = LoggerFactory.getLogger(SearchServlet.class);

    SiteDao siteDao;
    TopoDao topoDao;
    UserDao userDao;

    @Override
    public void init() throws ServletException {
        siteDao = new SiteDaoImpl();
        topoDao = new TopoDaoImpl();
        userDao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/search/advancedSearch.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String object = req.getParameter("search_object");
        logger.info("object : " + object);

        String word = req.getParameter("search_word");
        logger.info("word : " + word);

        req.setAttribute("departementList", EntityUtil.InitDepartementList());
        req.setAttribute("quotationList", EntityUtil.InitQuotationList());

        if (object.equals("site")) {
            List<Site> siteList = siteDao.searchByName(word);
            req.setAttribute("siteList", siteList);
            resp.sendRedirect(req.getContextPath() + "/searchSite?name="+ word +"&city=&departement=&nbRoutes=&quotation=&checked=");
        } else if (object.equals("topo")) {
            List<Topo> topoList = topoDao.searchByName(word);
            req.setAttribute("topoList", topoList);
            resp.sendRedirect(req.getContextPath() + "/searchTopo?name="+ word +"&city=&departement=&available=");
        } else if (object.equals("user")) {
            List<User> userList = userDao.searchByUsername(word);
            req.setAttribute("userList", userList);
            resp.sendRedirect(req.getContextPath() + "/searchUser?username="+ word);

        } else {
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }
}
