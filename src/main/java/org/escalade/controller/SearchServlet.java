package org.escalade.controller;

import org.escalade.controller.site.AddSiteServlet;
import org.escalade.model.dao.*;
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

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String object = req.getParameter("search_object");
        logger.info("object : " + object);

        String word = req.getParameter("search_word");
        logger.info("word : "+ word);

        if(object.equals("site")){
            List<Site> siteList = siteDao.searchByName(word);
            req.setAttribute("siteList", siteList);
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/search/searchSite.jsp").forward(req, resp);
        }

        else if(object.equals("topo")){
            List<Topo> topoList =  topoDao.searchByName(word);
            req.setAttribute("topoList", topoList);
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/search/searchTopo.jsp").forward(req, resp);
        }

        else if(object.equals("user")){
            User user = userDao.findByUsername(word);
            List<User> userList = new ArrayList<>();
            userList.add(user);

            req.setAttribute("userList", userList);
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/search/searchUser.jsp").forward(req, resp);

        }
        else{
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }
}
